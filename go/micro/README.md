# Go 微控制协议（Micro Control Protocol）Demo

## 简介
本示例模拟两个微控制器之间通过自定义微控制协议（MCP）进行通信，适合嵌入式、实时通信等场景。

## 依赖
- Go 1.16 及以上
- 无需第三方依赖

## 主要文件
- `mcp_protocol.go`：协议帧的打包与解包实现
- `sender.go`：发送端，发送协议帧
- `receiver.go`：接收端，接收并解析协议帧

## 编译与运行
1. 启动接收端（终端1）：
   ```bash
   go run receiver.go mcp_protocol.go
   ```
2. 启动发送端（终端2）：
   ```bash
   go run sender.go mcp_protocol.go
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