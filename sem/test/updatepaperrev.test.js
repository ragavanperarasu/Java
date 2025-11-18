jest.mock("../models/Paper");

const request = require("supertest");
const app = require("../app");
const Paper = require("../models/Paper");

describe("POST /updatepaperrev", () => {
  it("should update and return done", async () => {
    Paper.findByIdAndUpdate.mockResolvedValue({
      _id: "123",
      mark: 80,
      reviewer: "John",
      reviewdes: "Good",
      status: "Public",
    });

    const res = await request(app)
      .post("/updatepaperrev")
      .send({
        pid: "123",
        mark: 80,
        reviewer: "John",
        reviewdes: "Good"
      });

    expect(res.status).toBe(200);
    expect(res.body).toBe("done");
  });

  it("should return 404 if paper not found", async () => {
    Paper.findByIdAndUpdate.mockResolvedValue(null);

    const res = await request(app)
      .post("/updatepaperrev")
      .send({
        pid: "999",
        mark: 10,
        reviewer: "None",
        reviewdes: "Bad"
      });

    expect(res.status).toBe(404);
  });
});
