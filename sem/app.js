const express = require("express");
const cors = require("cors");

const newUserRoutes = require("./routes/user/newUser");
const loginRoutes = require("./routes/user/loginUser");
const forgotPassRoutes = require("./routes/user/forgotPass");
const paperRoute = require("./routes/author/paperUpl");
const viewpaperRoutes = require("./routes/author/viewPaper");
const viewpapercountRoutes = require("./routes/author/viewPaperCout");
const viewpaperRevRoutes = require("./routes/reviwer/viewPaperRev");
const viewpapercountRevRoutes = require("./routes/reviwer/viewPaperCoutRev");
const updatepaperrev = require("./routes/reviwer/updatePaperRev");

const app = express();

app.use(cors());
app.use(express.json());
app.use(express.static("public"));
app.use("/uploads", express.static("uploads"));

// All routes
app.use("/", newUserRoutes);
app.use("/", loginRoutes);
app.use("/", forgotPassRoutes);
app.use("/", paperRoute);
app.use("/", viewpaperRoutes);
app.use("/", viewpapercountRoutes);
app.use("/", viewpaperRevRoutes);
app.use("/", viewpapercountRevRoutes);
app.use("/", updatepaperrev);

module.exports = app;
