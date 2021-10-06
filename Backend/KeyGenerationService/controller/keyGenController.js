const keyGenDatabase = require("../models/keyGenModel");
const crypto = require("crypto");

exports.storingKeys = async (req,res)=>{
    const key = crypto.randomBytes(4).toString('hex');

}