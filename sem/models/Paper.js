const mongoose = require("mongoose");
const cmsConnection = require("../database/cms");

const paperSchema = new mongoose.Schema({
  topic: String,
  description: String,
  videoURL: String,
  status: String,
  email: String,
  filepath: String,
  mark: Number,
  reviewer: String,
  reviewdes: String,
  price: Number,
  CreateDate: {
    type: Date,
    default: Date.now,
  },
});

const papers = cmsConnection.model("papers", paperSchema);

module.exports = papers;
