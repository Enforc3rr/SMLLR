const mongoose = require("mongoose");

const schema = new mongoose.Schema({
    key : {
        type : String ,
        unique : true ,
        required : true
    },
    isBeingUsed : {
        type : Boolean ,
        required : true ,
        default : false
    }
});

module.exports = mongoose.model("keys",schema);
