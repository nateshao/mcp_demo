package main

import (
	"fmt"
	"net"
	"time"
)

func main() {
	conn, err := net.Dial("tcp", "127.0.0.1:9000")
	if err != nil {
		panic(err)
	}
	defer conn.Close()
	for i := 0; i < 5; i++ {
		cmd := byte(0x01)
		data := []byte(fmt.Sprintf("Hello %d", i))
		frame := PackFrame(cmd, data)
		conn.Write(frame)
		fmt.Printf("Sent: cmd=%d, data=%s\n", cmd, data)
		time.Sleep(time.Second)
	}
}
