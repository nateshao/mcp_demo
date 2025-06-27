package main

import (
	"net/http"

	"github.com/gin-gonic/gin"
)

var services = make(map[string]string)

func main() {
	r := gin.Default()

	r.POST("/register", func(c *gin.Context) {
		var req struct {
			Name    string `json:"name"`
			Address string `json:"address"`
		}
		if err := c.ShouldBindJSON(&req); err != nil || req.Name == "" || req.Address == "" {
			c.JSON(http.StatusBadRequest, gin.H{"error": "name and address required"})
			return
		}
		services[req.Name] = req.Address
		c.JSON(http.StatusOK, gin.H{"message": "service " + req.Name + " registered"})
	})

	r.POST("/unregister", func(c *gin.Context) {
		var req struct {
			Name string `json:"name"`
		}
		if err := c.ShouldBindJSON(&req); err != nil || req.Name == "" {
			c.JSON(http.StatusNotFound, gin.H{"error": "service not found"})
			return
		}
		if _, ok := services[req.Name]; !ok {
			c.JSON(http.StatusNotFound, gin.H{"error": "service not found"})
			return
		}
		delete(services, req.Name)
		c.JSON(http.StatusOK, gin.H{"message": "service " + req.Name + " unregistered"})
	})

	r.GET("/services", func(c *gin.Context) {
		c.JSON(http.StatusOK, services)
	})

	r.Run(":5000")
}
