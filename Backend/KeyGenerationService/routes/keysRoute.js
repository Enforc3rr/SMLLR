const express = require("express");
const router = express.Router();
const {getKey} = require("../controller/keyGenController");


router.route("/getKeys")
    .get(getKey);

module.exports = router;