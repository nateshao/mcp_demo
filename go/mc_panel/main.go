package main

import (
	"net/http"

	"github.com/gin-gonic/gin"
)

var serverStatus = gin.H{
	"status":      "running",
	"players":     5,
	"max_players": 20,
	"motd":        "Welcome to MCP Minecraft Server!",
	"plugins":     []string{"Essentials", "WorldEdit", "Dynmap"},
	"backups":     []string{"backup_2024-06-01.zip", "backup_2024-06-02.zip"},
}

func main() {
	r := gin.Default()

	r.LoadHTMLGlob("templates/*")

	r.GET("/", func(c *gin.Context) {
		c.HTML(http.StatusOK, "index.tmpl", serverStatus)
	})

	r.GET("/api/status", func(c *gin.Context) {
		c.JSON(http.StatusOK, serverStatus)
	})

	r.Run(":5001")
}
