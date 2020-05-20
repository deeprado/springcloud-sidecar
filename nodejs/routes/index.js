var express = require("express");
var router = express.Router();

router.get(
  "/",
  function (req, res, next) {
    //res.send('hello express')
    console.log("next1");
    next();
  },
  function (req, res) {
    console.log("next2");
    res.send("Hello World!");
  }
);

router.get("/hello", (req, res) => {
  res.render("hello.ejs", { title: "hello" });
});

router.get("/health", (req, res) => res.json({ status: "UP" }));
router.get("/getUser", (req, res) =>
  res.json({ username: "node", password: "node" })
);

module.exports = router;
