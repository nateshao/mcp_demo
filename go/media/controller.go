package main

import (
	"fmt"
	"net"
	"time"
)

func main() {
	conn, err := net.Dial("tcp", "127.0.0.1:9100")
	if err != nil {
		panic(err)
	}
	defer conn.Close()
	cmds := []string{"play", "pause", "play", "stop"}
	for _, cmd := range cmds {
		msg, _ := PackCommand(cmd, nil)
		conn.Write(msg)
		fmt.Println("Sent command:", cmd)
		time.Sleep(time.Second)
	}
}
