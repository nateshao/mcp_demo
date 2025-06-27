package main

import (
	"bytes"
	"errors"
)

const StartByte = 0xAA

// PackFrame 打包协议帧: [START][CMD][LEN][DATA][CHK]
func PackFrame(cmd byte, data []byte) []byte {
	length := byte(len(data))
	chk := cmd + length
	for _, b := range data {
		chk += b
	}
	chk = chk & 0xFF
	buf := bytes.NewBuffer([]byte{})
	buf.WriteByte(StartByte)
	buf.WriteByte(cmd)
	buf.WriteByte(length)
	buf.Write(data)
	buf.WriteByte(chk)
	return buf.Bytes()
}

// UnpackFrame 解包协议帧，返回(cmd, data, error)
func UnpackFrame(frame []byte) (byte, []byte, error) {
	if len(frame) < 5 {
		return 0, nil, errors.New("frame too short")
	}
	if frame[0] != StartByte {
		return 0, nil, errors.New("invalid start byte")
	}
	cmd := frame[1]
	length := frame[2]
	if len(frame) != int(4+length) {
		return 0, nil, errors.New("length mismatch")
	}
	data := frame[3 : 3+length]
	chk := frame[3+length]
	sum := cmd + length
	for _, b := range data {
		sum += b
	}
	if (sum & 0xFF) != chk {
		return 0, nil, errors.New("checksum error")
	}
	return cmd, data, nil
}
