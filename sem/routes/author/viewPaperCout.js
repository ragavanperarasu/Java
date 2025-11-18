const express = require("express");
const Paper = require("../../models/Paper");
const router = express.Router();

router.post("/viewpapercount", async (req, res) => {
  try {
    const { email, status } = req.body;

    const papers = await Paper.find({ email, status });


    res.send(papers.length);

  } catch (err) {
    console.error(err);
    res.status(500).send("Server error");
  }
});

module.exports = router;
