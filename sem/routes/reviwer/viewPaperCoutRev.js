const express = require("express");
const Paper = require("../../models/Paper");
const router = express.Router();

router.post("/viewpapercountrev", async (req, res) => {
  try {
    const { status } = req.body;

    const papers = await Paper.find({ status });


    res.send(papers.length);

  } catch (err) {
    console.error(err);
    res.status(500).send("Server error");
  }
});

module.exports = router;
