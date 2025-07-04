# Java 微控制协议（Micro Control Protocol）Demo

## 简介
本示例模拟两个微控制器之间通过自定义微控制协议（MCP）进行通信，适合嵌入式、实时通信等场景。

## 依赖
- JDK 8 及以上
- 无需第三方依赖

## 主要文件
- `MCPProtocol.java`：协议帧的打包与解包实现
- `Sender.java`：发送端，发送协议帧
- `Receiver.java`：接收端，接收并解析协议帧

## 编译与运行
1. 编译：
   ```bash
   javac MCPProtocol.java Sender.java Receiver.java
   ```
2. 启动接收端（终端1）：
   ```bash
   java Receiver
   ```
3. 启动发送端（终端2）：
   ```bash
   java Sender
   ```

## 典型输出
**Sender:**
```
Sent: cmd=1, data=Hello 0
Sent: cmd=1, data=Hello 1
...
```
**Receiver:**
```
Receiver listening on 127.0.0.1:9000
Received: cmd=1, data=Hello 0
Received: cmd=1, data=Hello 1
...
``` 