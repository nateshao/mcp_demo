# MCP Media Control Protocol Demo

本示例模拟了媒体控制协议，支持 play/pause/stop 命令。

## 文件说明
- `media_protocol.py`：协议打包与解析
- `player.py`：播放器端，接收并执行命令
- `controller.py`：控制器端，发送命令

## 运行方法

1. 打开终端，先运行播放器端：
   ```bash
   python mcp_media/player.py
   ```
2. 另开一个终端，运行控制器端：
   ```bash
   python mcp_media/controller.py
   ```

你会看到控制器发送命令，播放器端收到并切换状态。

## 依赖
仅需 Python 3，无需额外依赖。 