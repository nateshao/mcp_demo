# MCP Demos (Java, Go, Python)

本项目包含 5 种典型场景下的 MCP（Micro Control Protocol）相关 Demo，分别用 Java、Go、Python 实现，便于对比和学习。

---

## 目录结构

| 语言目录 | Demo 1 (micro) | Demo 2 (cloud) | Demo 3 (processor) | Demo 4 (mc_panel) | Demo 5 (media) |
|----------|----------------|---------------|--------------------|-------------------|---------------|
| `java/`  | 微控制协议      | 托管云平台    | 多通道处理器       | MC控制面板        | 媒体控制协议  |
| `go/`    | 微控制协议      | 托管云平台    | 多通道处理器       | MC控制面板        | 媒体控制协议  |
| `py/`    | 微控制协议      | 托管云平台    | 多通道处理器       | MC控制面板        | 媒体控制协议  |

- 每个语言目录下均有 5 个子目录，对应 5 个 MCP 场景：
  1. `micro`      —— 微控制协议（嵌入式通信）
  2. `cloud`      —— 托管云平台（服务注册/查询）
  3. `processor`  —— 多通道处理器（并发数据流处理）
  4. `mc_panel`   —— Minecraft 控制面板（Web界面）
  5. `media`      —— 媒体控制协议（媒体流控制）

---

## 快速开始

每个 demo 子目录下均有详细 README，包含运行方法和依赖说明。

例如：
- Java 版微控制协议：`java/micro/README.md`
- Go 版多通道处理器：`go/processor/README.md`
- Python 版媒体控制协议：`py/media/README.md`

---

如需扩展或有其他需求，欢迎联系作者！ 