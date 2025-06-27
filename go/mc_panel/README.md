# MCP Minecraft Control Panel Go Demo

本示例实现了一个极简的 Minecraft 服务器控制面板（Go语言版，Gin+模板，仅模拟数据）。

## 文件说明
- `main.go`：Gin应用，提供前端页面和API，展示服务器状态、插件、备份等
- `templates/index.tmpl`：前端页面模板

## 运行方法

1. 安装依赖：
   ```bash
   go get github.com/gin-gonic/gin
   ```
2. 启动服务：
   ```bash
   go run main.go
   ```
3. 在浏览器访问：
   [http://127.0.0.1:5001/](http://127.0.0.1:5001/)

你会看到一个简洁的 Minecraft 控制面板页面。

## 依赖
- Go 1.16+
- Gin 