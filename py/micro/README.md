# MCP Micro Control Protocol Demo

本示例模拟了两个微控制器之间通过自定义微控制协议（MCP）进行通信。

## 文件说明
- `mcp_protocol.py`：协议帧的打包与解包实现
- `sender.py`：发送端，发送协议帧
- `receiver.py`：接收端，接收并解析协议帧

## 运行方法

1. 打开终端，先运行接收端：
   ```bash
   python mcp_micro/receiver.py
   ```
2. 另开一个终端，运行发送端：
   ```bash
   python mcp_micro/sender.py
   ```

你会看到 sender 发送数据，receiver 解析并打印收到的帧内容。

## 依赖
仅需 Python 3，无需额外依赖。 