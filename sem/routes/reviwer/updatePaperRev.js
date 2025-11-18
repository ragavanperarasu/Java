const express = require("express");
const Paper = require("../../models/Paper");
const router = express.Router();


router.post("/updatepaperrev", async (req, res) => {
  try {
    const { pid, mark, reviewer, reviewdes } = req.body;
    console.log(req.body);

    // Decide status based on marks
    const status = mark > 50 ? "Public" : "Rejected";

    // Find and update the paper
    const updatedPaper = await Paper.findByIdAndUpdate(
      pid,
      {
        mark,
        reviewer,
        reviewdes,
        status
      },
      { new: true } // returns updated document
    );

    if (!updatedPaper) {
      return res.status(404).send("Paper not found");
    }

    res.json("done");

  } catch (err) {
    console.error(err);
    res.status(500).send("Server error");
  }
});


module.exports = router;
