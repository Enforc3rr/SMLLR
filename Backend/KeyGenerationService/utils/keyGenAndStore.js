const crypto = require("crypto");
const keyGenDatabase = require("../models/keyGenModel");

const generatingAndStoring = async ()=>{
    const key = crypto.randomBytes(3).toString("hex");
    await keyGenDatabase.create(key);

}