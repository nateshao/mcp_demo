# MCP Minecraft Control Panel Java Demo

本示例实现了一个极简的 Minecraft 服务器控制面板（Java版，Spring Boot + Thymeleaf，仅模拟数据）。

## 文件说明
- `McpPanelApplication.java`：Spring Boot主类
- `PanelController.java`：控制器，返回模拟数据
- `templates/index.html`：前端页面模板
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
   java -jar target/mcpmc-1.0.0.jar
   ```
3. 在浏览器访问：
   [http://127.0.0.1:8080/](http://127.0.0.1:8080/)

你会看到一个简洁的 Minecraft 控制面板页面。

## 依赖
- JDK 8+
- Maven
- Spring Boot 2.x 