package com.example.mcpcloud;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ServiceController {
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> req) {
        String name = req.get("name");
        String address = req.get("address");
        if (name == null || address == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "name and address required"));
        }
        ServiceRegistry.register(name, address);
        return ResponseEntity.ok(Map.of("message", "service " + name + " registered"));
    }

    @PostMapping("/unregister")
    public ResponseEntity<?> unregister(@RequestBody Map<String, String> req) {
        String name = req.get("name");
        if (name == null || !ServiceRegistry.unregister(name)) {
            return ResponseEntity.status(404).body(Map.of("error", "service not found"));
        }
        return ResponseEntity.ok(Map.of("message", "service " + name + " unregistered"));
    }

    @GetMapping("/services")
    public Map<String, String> list() {
        return ServiceRegistry.list();
    }
} 