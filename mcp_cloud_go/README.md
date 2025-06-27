# MCP Managed Cloud Platform Go Demo

本示例实现了一个极简的托管云平台服务注册/查询API（Go语言版，基于Gin）。

## 文件说明
- `main.go`：Gin应用，提供服务注册、注销、查询API

## 运行方法

1. 安装依赖：
   ```bash
   go get github.com/gin-gonic/gin
   ```
2. 启动服务：
   ```bash
   go run main.go
   ```
3. 测试API（可用curl或Postman）：
   - 注册服务：
     ```bash
     curl -X POST http://127.0.0.1:5000/register -H 'Content-Type: application/json' -d '{"name": "svc1", "address": "10.0.0.1:8080"}'
     ```
   - 查询服务：
     ```bash
     curl http://127.0.0.1:5000/services
     ```
   - 注销服务：
     ```bash
     curl -X POST http://127.0.0.1:5000/unregister -H 'Content-Type: application/json' -d '{"name": "svc1"}'
     ```

## 依赖
- Go 1.16+
- Gin 