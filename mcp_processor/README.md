# MCP Multi-Channel Processor Demo

本示例模拟了多通道数据流的并发处理。

## 文件说明
- `processor.py`：多通道数据处理模拟脚本，使用线程池并发处理多个数据流

## 运行方法

```bash
python mcp_processor/processor.py
```

运行后可看到每个通道独立处理数据，并最终输出所有结果。

## 依赖
仅需 Python 3，无需额外依赖。 