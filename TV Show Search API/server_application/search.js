const router = require('express').Router();

const searchResult = require('custom_module');
const { ObjectId } = require('mongodb');

// GET /search/shows?name=
router.get('/shows', async (req, res) => {
    try {
        let count = 0;
        //destructure the query 
        const { name } = req.query;

        //gets list of shows by name
        const listOfShows = await searchResult.searchShow(name);
        const idAndName = [];

        //creates array of objects of id and show name from search 
        listOfShows.forEach((shows) => {
            let object = {id: shows.show.id, displayText: shows.show.name};
            count += 1;
            idAndName.push(object);
        });

        //search history objects
        const searchHistoryData = {
            count: count,
            keyword: name
        }

        //inserts history objects into mongodb
        const db = req.app.locals.db;
        const collection = db.collection('History');

        await collection.insertOne(searchHistoryData);

        //gets recent document to get mongodb id
        const recent = await collection.findOne({}, {sort: {_id: -1}, limit: 1 });

        //count and result objects
        const data = {
            _id: recent._id,
            resultCount: count, 
            results: [...idAndName],
        };
        
        res.status(200).json(data);
    } catch (error) {
        res.status(500).json({ error: error.toString() });
    }
})

// Post /search/shows/details
router.post('/shows/details', async (req, res) => {
    try {
        //destructure the post body
        const { id } = req.body;
        const { _id } = req.body;

        //gets specific show from id
        const specificShow = await searchResult.getShow(id);

        const data = {
            ...specificShow
        }
        
        //gets date and time
        const today = new Date();
        const date = (today.getMonth()+1) + '-' + today.getDate()  + '-' + today.getFullYear();
        const time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
        const dateTime = 'Date: ' + date +', Time: '+ time;

        //calls db
        const db = req.app.locals.db;
        const collection = db.collection('History');

        //updates document with new search history objects
        await collection.updateOne({ _id: ObjectId(_id) }, { $set: { selectedId : id } });
        await collection.updateOne({ _id: ObjectId(_id) }, { $set: { selectedText : specificShow.name } });
        await collection.updateOne({ _id: ObjectId(_id) }, { $set: { timestamp: dateTime } });

        res.status(200).json(data);
    } catch (error) {
        res.status(500).json({ error: error.toString() });
    }
    
})


module.exports = router;