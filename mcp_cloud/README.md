# MCP Managed Cloud Platform Demo

本示例实现了一个极简的托管云平台服务注册/查询API。

## 文件说明
- `app.py`：Flask应用，提供服务注册、注销、查询API

## 运行方法

1. 安装依赖：
   ```bash
   pip install flask
   ```
2. 启动服务：
   ```bash
   python mcp_cloud/app.py
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