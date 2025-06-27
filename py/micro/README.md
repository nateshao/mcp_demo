# Python 微控制协议（Micro Control Protocol）Demo

## 简介
本示例模拟两个微控制器之间通过自定义微控制协议（MCP）进行通信，适合嵌入式、实时通信等场景。

## 依赖
- Python 3.x
- 无需第三方依赖

## 主要文件
- `mcp_protocol.py`：协议帧的打包与解包实现
- `sender.py`：发送端，发送协议帧
- `receiver.py`：接收端，接收并解析协议帧

## 运行方法
1. 启动接收端（终端1）：
   ```bash
   python receiver.py
   ```
2. 启动发送端（终端2）：
   ```bash
   python sender.py
   ```

## 典型输出
**Sender:**
```
Sent: cmd=1, data=b'Hello 0'
Sent: cmd=1, data=b'Hello 1'
...
```
**Receiver:**
```
Receiver listening on 127.0.0.1:9000
Received: cmd=1, data=b'Hello 0'
Received: cmd=1, data=b'Hello 1'
...
``` 