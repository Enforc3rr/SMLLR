const express = require("express");
const router = express.Router();
const {getKey,restoreUsedStatusOfKey} = require("../controller/keyGenController");


router.route("/getKeys")
    .get(getKey);
router.route("/updateStatus")
    .post(restoreUsedStatusOfKey);

module.exports = router;