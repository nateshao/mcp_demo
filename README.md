# MCP Demos (Python & Go)

本项目包含5种典型场景下的 MCP（Micro Control Protocol）相关 Demo，分别用 Python 和 Go 实现，便于对比和学习。

---

## Python 版

- **1. mcp_micro/**  
  微控制协议（嵌入式通信）
  - `sender.py` / `receiver.py` / `mcp_protocol.py`
- **2. mcp_cloud/**  
  托管云平台（服务注册/查询）
  - `app.py`
- **3. mcp_processor/**  
  多通道处理器（并发数据流处理）
  - `processor.py`
- **4. mcp_mc_panel/**  
  Minecraft 控制面板（Web界面）
  - `app.py`
- **5. mcp_media/**  
  媒体控制协议（媒体流控制）
  - `controller.py` / `player.py` / `media_protocol.py`

---

## Go 版

- **1. mcp_micro_go/**  
  微控制协议（嵌入式通信）
  - `sender.go` / `receiver.go` / `mcp_protocol.go`
- **2. mcp_cloud_go/**  
  托管云平台（服务注册/查询）
  - `main.go`
- **3. mcp_processor_go/**  
  多通道处理器（并发数据流处理）
  - `processor.go`
- **4. mcp_mc_panel_go/**  
  Minecraft 控制面板（Web界面）
  - `main.go` / `templates/index.tmpl`
- **5. mcp_media_go/**  
  媒体控制协议（媒体流控制）
  - `controller.go` / `player.go` / `media_protocol.go`

---

每个子目录下均有详细 README，包含运行方法和依赖说明。

---

如需扩展或有其他需求，欢迎联系作者！ 