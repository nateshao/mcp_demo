# MCP Multi-Channel Processor Go Demo

本示例模拟了多通道数据流的并发处理（Go语言版，使用goroutine和channel）。

## 文件说明
- `processor.go`：多通道数据处理模拟脚本

## 运行方法

```bash
go run processor.go
```

运行后可看到每个通道独立处理数据，并最终输出所有结果。

## 依赖
仅需 Go 1.16+，无第三方依赖。 