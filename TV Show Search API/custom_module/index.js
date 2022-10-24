const superagent = require('superagent');

//holds out base url
const config = require('./config.json');

//searches show by inputting name
const searchShow = async (showName) => {
    try {
        const searchURL = `${config.url}/search/shows?q=${showName}`;
        const response = await superagent.get(searchURL);

        return response.body;
    } catch (error) {
        return error;
    }
}

//gets shows detail by id
const getShow = async (showID) => {
    try {
        const idURL = `${config.url}/shows/${showID}`;
        const response = await superagent.get(idURL);

        return response.body;
    } catch (error) {
        return error;
    }
};


module.exports = {
    searchShow,
    getShow
}