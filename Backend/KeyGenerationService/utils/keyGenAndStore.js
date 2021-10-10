const crypto = require("crypto");
const keyGenDatabase = require("../models/keyGenModel");

const generatingAndStoring = async ()=>{
    try{
        const keyModel = {
            key : crypto.randomBytes(3).toString("hex"),
            isBeingUsed : false
        }
        console.log("Generated Key " + keyModel.key);
        await keyGenDatabase.create(keyModel);
    }catch (e) {
        console.log("Duplicate Key Found");
    }
}

module.exports = generatingAndStoring;