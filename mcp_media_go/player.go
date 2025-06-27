package main

import (
	"fmt"
	"net"
)

var playerState = "stopped"

func handleCommand(cmd string, params map[string]interface{}) {
	switch cmd {
	case "play":
		playerState = "playing"
		fmt.Println("Player: 播放")
	case "pause":
		playerState = "paused"
		fmt.Println("Player: 暂停")
	case "stop":
		playerState = "stopped"
		fmt.Println("Player: 停止")
	default:
		fmt.Println("Player: 未知命令", cmd)
	}
	fmt.Println("当前状态:", playerState)
}

func main() {
	ln, err := net.Listen("tcp", ":9100")
	if err != nil {
		panic(err)
	}
	defer ln.Close()
	fmt.Println("Player listening on 127.0.0.1:9100")
	conn, err := ln.Accept()
	if err != nil {
		panic(err)
	}
	defer conn.Close()
	buf := make([]byte, 1024)
	for {
		n, err := conn.Read(buf)
		if err != nil {
			break
		}
		cmd, params, err := UnpackCommand(buf[:n])
		if err != nil {
			fmt.Println("Unpack error:", err)
			continue
		}
		handleCommand(cmd, params)
	}
}
