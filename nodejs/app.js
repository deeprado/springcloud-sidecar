const express = require("express");
var ejs = require("ejs");
var path = require("path");

var indexRouter = require("./routes/index");

const app = express();
const port = 3000;

app.engine("html", ejs.__express);
app.set("view engine", "html");
app.set("views", path.join(__dirname, "views"));

app.use(require("stylus").middleware(__dirname + "/public"));
app.use(express.static(path.join(__dirname, "public")));


// 设置允许跨域访问该服务.
app.all('*', function (req, res, next) {
  res.header('Access-Control-Allow-Origin', '*');
  res.header('Access-Control-Allow-Headers', 'Content-Type');
  res.header('Access-Control-Allow-Methods', '*');
  res.header('Content-Type', 'application/json;charset=utf-8');
  next();
});

app.use("/", indexRouter);

// 放在路由后面
// catch 404 and forward to error handler
app.use(function (req, res, next) {
  var err = new Error("Not Found");
  err.status = 404;
  res.render("notfound.ejs");
});

// error handler
app.use(function (err, req, res, next) {
  // set locals, only providing error in development
  res.locals.message = err.message;
  res.locals.error = req.app.get("env") === "development" ? err : {};

  // render the error page
  res.status(err.status || 500);
  res.render("error.ejs");
});

app.listen(port, () => console.log(`Example app listening on port ${port}!`));
