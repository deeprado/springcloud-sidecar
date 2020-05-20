package main

import (
	"net/http"

	"github.com/labstack/echo"
	"github.com/labstack/echo/middleware"
)

type Result struct {
	Status string `json:"status" xml:"status"`
}

type User struct {
	Username string `json:"username" xml:"username"`
	Password string `json:"password" xml:"password"`
}

func main() {
	// Echo instance
	e := echo.New()

	// Middleware
	e.Use(middleware.Logger())
	e.Use(middleware.Recover())

	// Routes
	e.GET("/", hello)
	e.GET("/health", health)
	e.GET("/getUser", getUser)

	// Start server
	e.Logger.Fatal(e.Start(":10000"))
}

// Handler
func hello(c echo.Context) error {
	return c.String(http.StatusOK, "Hello, World!")
}

func health(c echo.Context) error {
	s := &Result{
		Status: "UP",
	}
	return c.JSON(http.StatusOK, s)
}

func getUser(c echo.Context) error {
	u := &User{
		Username: "go",
		Password: "go",
	}
	return c.JSON(http.StatusOK, u)
}
