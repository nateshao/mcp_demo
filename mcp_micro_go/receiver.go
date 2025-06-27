package main

import (
	"fmt"
	"net"
)

func main() {
	ln, err := net.Listen("tcp", ":9000")
	if err != nil {
		panic(err)
	}
	defer ln.Close()
	fmt.Println("Receiver listening on 127.0.0.1:9000")
	conn, err := ln.Accept()
	if err != nil {
		panic(err)
	}
	defer conn.Close()
	buffer := make([]byte, 0)
	tmp := make([]byte, 1024)
	for {
		n, err := conn.Read(tmp)
		if err != nil {
			break
		}
		buffer = append(buffer, tmp[:n]...)
		// 尝试解析完整帧
		for len(buffer) >= 5 {
			if buffer[0] != StartByte {
				buffer = buffer[1:]
				continue
			}
			length := buffer[2]
			frameLen := int(4 + length)
			if len(buffer) < frameLen {
				break
			}
			frame := buffer[:frameLen]
			cmd, data, err := UnpackFrame(frame)
			if err != nil {
				fmt.Println("Frame error:", err)
				buffer = buffer[1:]
				continue
			}
			fmt.Printf("Received: cmd=%d, data=%s\n", cmd, string(data))
			buffer = buffer[frameLen:]
		}
	}
}
