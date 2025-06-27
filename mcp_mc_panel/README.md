# MCP Minecraft Control Panel Demo

本示例实现了一个极简的 Minecraft 服务器控制面板（仅模拟数据）。

## 文件说明
- `app.py`：Flask应用，提供前端页面和API，展示服务器状态、插件、备份等

## 运行方法

1. 安装依赖：
   ```bash
   pip install flask
   ```
2. 启动服务：
   ```bash
   python mcp_mc_panel/app.py
   ```
3. 在浏览器访问：
   [http://127.0.0.1:5001/](http://127.0.0.1:5001/)

你会看到一个简洁的 Minecraft 控制面板页面。

## 依赖
仅需 Python 3 和 Flask。 