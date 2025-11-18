require("dotenv").config();
const mongoose = require("mongoose");

// Allow jest.fn() in test mode
let jestMock;
if (process.env.NODE_ENV === "test") {
  jestMock = require("@jest/globals").jest;
}

// ------------------ TEST MODE ------------------
if (process.env.NODE_ENV === "test") {
  console.log("🧪 Test mode: Using MOCK DB connection");

  const fakeMethods = {
    find: jestMock.fn(),
    findOne: jestMock.fn(),
    findById: jestMock.fn(),
    findByIdAndUpdate: jestMock.fn(),  //  ✅ ADD THIS
    create: jestMock.fn(),
    updateOne: jestMock.fn(),
    deleteOne: jestMock.fn(),
    save: jestMock.fn(),
  };

  const fakeConnection = {
    model: () => fakeMethods,
  };

  module.exports = fakeConnection;
}
