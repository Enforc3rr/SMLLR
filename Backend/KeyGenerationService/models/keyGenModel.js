const mongoose = require("mongoose");

const schema = new mongoose.Schema({
    key : {
        type : String ,
        unique : true ,
        required : true
    },
    isBeingUsed : {
        type : Boolean ,
        required : true
    }
});

module.exports = mongoose.model("key",schema);
