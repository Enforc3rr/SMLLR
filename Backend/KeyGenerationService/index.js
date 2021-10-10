const express = require("express");
const app = express();
const dotenv = require("dotenv");
dotenv.config({path:"./configuration/configuration.env"});
const database = require("./configuration/databaseConfiguration");
const nodeSchedule = require("node-schedule");
const keyGenerator = require("./utils/keyGenAndStore");
const keyRouter = require("./routes/keysRoute");


app.use(express.urlencoded({extended : true}));
app.use("/key",keyRouter);


database()
    .then(()=>console.log("Connected To Database"))
    .catch(()=>console.log("Connection To Database Failed"));

nodeSchedule.scheduleJob("* * * * *",async ()=>{
    await keyGenerator();
})

const PORT = 8000 || process.env.PORT;
app.listen(PORT , ()=>console.log(`Key Generation Server Started At ${PORT}`));
