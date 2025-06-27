# MCP Multi-Channel Processor Java Demo

本示例模拟了多通道数据流的并发处理（Java版，使用线程池）。

## 文件说明
- `Processor.java`：多通道数据处理模拟脚本

## 运行方法

1. 编译：
   ```bash
   javac Processor.java
   ```
2. 运行：
   ```bash
   java Processor
   ```

运行后可看到每个通道独立处理数据，并最终输出所有结果。

## 依赖
仅需 JDK 8+，无需第三方依赖。 