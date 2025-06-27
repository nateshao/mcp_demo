# MCP Media Control Protocol Java Demo

本示例模拟了媒体控制协议，支持 play/pause/stop 命令（Java版）。

## 文件说明
- `MediaProtocol.java`：协议打包与解析（依赖 Jackson）
- `Player.java`：播放器端，接收并执行命令
- `Controller.java`：控制器端，发送命令
- `pom.xml`：Maven依赖

## 运行方法

1. 构建：
   ```bash
   mvn clean package
   ```
2. 打开终端，先运行播放器端：
   ```bash
   java -cp target/mcpmedia-1.0.0.jar:. Player
   ```
3. 另开一个终端，运行控制器端：
   ```bash
   java -cp target/mcpmedia-1.0.0.jar:. Controller
   ```

你会看到控制器发送命令，播放器端收到并切换状态。

## 依赖
- JDK 8+
- Maven
- Jackson 