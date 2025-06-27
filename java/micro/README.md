# MCP Micro Control Protocol Java Demo

本示例模拟了两个微控制器之间通过自定义微控制协议（MCP）进行通信（Java版）。

## 文件说明
- `MCPProtocol.java`：协议帧的打包与解包实现
- `Sender.java`：发送端，发送协议帧
- `Receiver.java`：接收端，接收并解析协议帧

## 运行方法

1. 编译：
   ```bash
   javac MCPProtocol.java Sender.java Receiver.java
   ```
2. 打开终端，先运行接收端：
   ```bash
   java Receiver
   ```
3. 另开一个终端，运行发送端：
   ```bash
   java Sender
   ```

你会看到 sender 发送数据，receiver 解析并打印收到的帧内容。

## 依赖
仅需 JDK 8+，无需第三方依赖。 