const express = require("express");
const app = express();
const dotenv = require("dotenv");
dotenv.config({path:"./configuration/configuration.env"});
const database = require("./configuration/databaseConfiguration");



database()
    .then(()=>console.log("Connected To Database"))
    .catch(()=>console.log("Connection To Database Failed"));



const PORT = 8000 || process.env.PORT;
app.listen(PORT , ()=>console.log(`Key Generation Server Started At ${PORT}`));
