// to start with nodemon from the package.json
// on OsX or Linux use: npm run start
// on Windows use: npm run windows
const cors = require('cors');
const express = require('express');

const MongoClient = require('mongodb').MongoClient;

const config = require('./config.json');

//requiring router handler files for search and history
const search = require(`./search`);
const history = require(`./history`);

//calls express
const app = express();
const port = 8888;

//applies the middleware to the application level
app.use(cors());
app.use(express.json());

//adds the search route to express application 
app.use('/search', search);

//adds the history route to express application
app.use('/history', history);

// mongodb+srv://dbAdmin:<password>@cluster0.sudtk.mongodb.net/myFirstDatabase?retryWrites=true&w=majority
const url = `mongodb+srv://${config.username}:${config.password}@${config.cluster}/${config.db_name}`;

//creates new mongo client
const client = new MongoClient(url);

//connects it to the url provided 
client.connect((err) => {
    //throws error code
    if (err) {
        throw new Error('Failed to connect to MongoDb');
    } 

    console.log('Connected successfully to Mongo');

    //storing the database instance in the app.locals object to reference in search.js and history.js
    app.locals.db = client.db();

    //starts server after connecting to mongo
    app.listen(port, () => {
        console.log(`Server is listening on port ${port}`);
    })
})