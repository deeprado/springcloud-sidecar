var express = require("express");
var router = express.Router();


var BlogModel = require("./models/blog");


router.get("/findOne", (req, response) => {
  var wherestr = { title: "aaaaa" };
  BlogModel.findOne(wherestr, function (err, res) {
    if (err) {
      console.log("Error:" + err);
      res.json({ status: "fail" });
    } else {
      console.log("Res:" + res);

      response.json(res);
    }
  });
});

router.get("/findAll", (req, response) => {
  var wherestr = { title: "aaaaa" };
  BlogModel.find(wherestr, function (err, res) {
    if (err) {
      console.log("Error:" + err);
      res.json({ status: "fail" });
    } else {
      console.log("Res:" + res);

      response.json(res);
    }
  });
});

router.get("/create", (req, res) => {
  var blog = new BlogModel({
    title: "aaaaa",
    author: "aaaaa",
    body: "aaaa",
    comments: [{ body: "bbbbbb", date: new Date() }],
    date: new Date(),
    hidden: false,
    meta: {
      votes: 2,
      favs: 3,
    },
  });
  blog.save(function (err, res) {
    if (err) {
      console.log("Error:" + err);
    } else {
      console.log("Res:" + res);
    }
  });
  res.json({ status: "success" });
});

module.exports = router;