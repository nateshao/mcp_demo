package main

import (
	"encoding/json"
)

type MediaCommand struct {
	Cmd    string                 `json:"cmd"`
	Params map[string]interface{} `json:"params,omitempty"`
}

func PackCommand(cmd string, params map[string]interface{}) ([]byte, error) {
	obj := MediaCommand{Cmd: cmd, Params: params}
	return json.Marshal(obj)
}

func UnpackCommand(data []byte) (string, map[string]interface{}, error) {
	var obj MediaCommand
	err := json.Unmarshal(data, &obj)
	return obj.Cmd, obj.Params, err
}
