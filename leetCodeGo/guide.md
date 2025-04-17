1. 搭建环境
安装Go
下载Go：

访问 Go官方网站 下载适合你操作系统的Go安装包。
选择最新的稳定版本。
安装Go：

Windows：运行下载的安装包，按照提示进行安装。
macOS/Linux：解压下载的文件，并将Go的安装路径添加到环境变量中。例如，在macOS上：
SH
tar -C /usr/local -xzf go1.19.darwin-amd64.tar.gz
echo 'export PATH=$PATH:/usr/local/go/bin' >> ~/.zshrc
source ~/.zshrc
验证安装：

打开终端，输入 go version 命令，确保安装成功。
创建一个简单的Go程序来验证环境：
SH
mkdir hello-go
cd hello-go
touch main.go
编辑 main.go 文件：
GO
package main

import "fmt"

func main() {
    fmt.Println("Hello, Go!")
}
运行程序：
SH
go run main.go
2. 配置IDE
推荐IDE
Visual Studio Code (VSCode)：轻量级且功能强大，有很好的Go插件支持。
GoLand：JetBrains出品的Go IDE，功能丰富，适合大型项目。
安装和配置VSCode
安装VSCode：

访问 VSCode官方网站 下载并安装VSCode。
安装Go插件：

打开VSCode，进入扩展市场（Extensions Marketplace）。
搜索并安装“Go”插件，这是由Go团队维护的官方插件。
配置Go插件：

插件会自动检测你的Go安装路径，如果未自动检测到，可以在设置中手动指定。
安装必要的工具，插件会在安装时提示你安装一些必要的工具，如 gopls、delve 等。
安装和配置GoLand
安装GoLand：

访问 GoLand官方网站 下载并安装GoLand。
配置GoLand：

打开GoLand，选择“File” -> “Settings”（或“Preferences”）。
在“Build, Execution, Deployment” -> “Go” 中配置Go SDK路径。
GoLand会自动检测并安装必要的工具。
3. 写出第一个API
使用Gin框架
Gin是一个非常流行的Go Web框架，适合快速开发API。

安装Gin：

在终端中运行以下命令：
SH
go get -u github.com/gin-gonic/gin
创建项目：

在你的工作目录中创建一个新的项目：
SH
mkdir go-api
cd go-api
go mod init go-api
编写代码：

编辑 main.go 文件，编写一个简单的API：
GO
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
            "message": "Hello, Go!",
        })
    })

    // 启动HTTP服务器，监听端口8080
    router.Run(":8080")
}
运行API：

在终端中运行以下命令：
SH
go run main.go
打开浏览器，访问 http://localhost:8080/hello，你应该会看到以下JSON响应：
JSON
{
    "message": "Hello, Go!"
}
总结
环境搭建：通常需要1-2小时。
配置IDE：如果使用VSCode，大约需要1小时；如果使用GoLand，可能更快，大约30分钟。
写出第一个API：学习Gin框架并编写一个简单的API，大约需要2-3小时。
