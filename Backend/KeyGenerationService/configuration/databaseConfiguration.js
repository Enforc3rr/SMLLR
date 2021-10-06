const mongoose = require("mongoose");

const database = async ()=>{
    await mongoose.connect(process.env.DB);
}

module.exports = database;