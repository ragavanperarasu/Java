jest.mock("../models/Paper");   // <-- use the mock file

const request = require("supertest");
const app = require("../app");
const Paper = require("../models/Paper");

describe("POST /viewpaper", () => {
  it("should return papers", async () => {
    // Mock response
    Paper.find.mockResolvedValue([{ title: "Sample", email: "test@test.com" }]);

    const res = await request(app)
      .post("/viewpaper")
      .send({ email: "test@test.com" });

    expect(res.status).toBe(200);
    expect(res.body.length).toBe(1);
    expect(res.body[0].title).toBe("Sample");
  });

  it("should return 'paper not found'", async () => {
    Paper.find.mockResolvedValue([]); // return empty list

    const res = await request(app)
      .post("/viewpaper")
      .send({ email: "none@test.com" });

    expect(res.text).toBe("paper not found");
  });
});
