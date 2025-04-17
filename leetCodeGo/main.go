package main

import (
	"net/http"

	"github.com/gin-gonic/gin"
)

func main() {
	// 创建一个默认的路由引擎
	router := gin.Default()

	// 定义一个简单的GET路由
	router.GET("/hello", func(c *gin.Context) {
		c.JSON(http.StatusOK, gin.H{
			"message": "你好golang!",
		})
	})

	// 启动HTTP服务器，监听端口8080
	router.Run(":8080")
}
