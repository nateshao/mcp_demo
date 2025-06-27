# MCP Managed Cloud Platform Java Demo

本示例实现了一个极简的托管云平台服务注册/查询API（Java版，Spring Boot）。

## 文件说明
- `McpCloudApplication.java`：Spring Boot主类
- `ServiceController.java`：REST API 控制器
- `ServiceRegistry.java`：内存服务注册表
- `pom.xml`：Maven依赖

## 运行方法

1. 构建：
   ```bash
   mvn clean package
   ```
2. 启动服务：
   ```bash
   mvn spring-boot:run
   # 或
   java -jar target/mcpcloud-1.0.0.jar
   ```
3. 测试API（可用curl或Postman）：
   - 注册服务：
     ```bash
     curl -X POST http://127.0.0.1:8080/register -H 'Content-Type: application/json' -d '{"name": "svc1", "address": "10.0.0.1:8080"}'
     ```
   - 查询服务：
     ```bash
     curl http://127.0.0.1:8080/services
     ```
   - 注销服务：
     ```bash
     curl -X POST http://127.0.0.1:8080/unregister -H 'Content-Type: application/json' -d '{"name": "svc1"}'
     ```

## 依赖
- JDK 8+
- Maven
- Spring Boot 2.x 