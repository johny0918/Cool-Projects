const router = require('express').Router();

//GET /history/search
router.get(`/search`, async (req, res) => {
    try {
        const db = req.app.locals.db;
        const collection = db.collection('History');

        //gets all documents
        const results = await collection.find({}).toArray();
        res.status(200).json(results);
    } catch (error) {
        res.status(500).json({ error:error.toString() });
    }
})

module.exports = router;