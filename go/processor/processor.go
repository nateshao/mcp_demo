package main

import (
	"fmt"
	"strings"
	"sync"
	"time"
)

func processChannel(id int, data string, wg *sync.WaitGroup, results chan<- string) {
	defer wg.Done()
	fmt.Printf("Channel %d start processing %s\n", id, data)
	time.Sleep(time.Duration(500+id*200) * time.Millisecond) // 模拟耗时
	result := fmt.Sprintf("Channel %d processed %s", id, strings.ToUpper(data))
	fmt.Printf("Channel %d done\n", id)
	results <- result
}

func main() {
	channelData := map[int]string{
		1: "alpha",
		2: "bravo",
		3: "charlie",
		4: "delta",
	}
	var wg sync.WaitGroup
	results := make(chan string, len(channelData))
	for id, data := range channelData {
		wg.Add(1)
		go processChannel(id, data, &wg, results)
	}
	wg.Wait()
	close(results)
	fmt.Println("\nAll results:")
	for r := range results {
		fmt.Println(r)
	}
}
