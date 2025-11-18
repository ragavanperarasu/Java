const express = require("express");
const Paper = require("../../models/Paper");
const router = express.Router();

router.post("/viewpaper", async (req, res) => {
  try {
    const { email, status } = req.body;

    const papers = await Paper.find({ email});

    if (papers.length == 0) return res.send("paper not found");

    res.send(papers);

  } catch (err) {
    console.error(err);
    res.status(500).send("Server error");
  }
});

module.exports = router;
