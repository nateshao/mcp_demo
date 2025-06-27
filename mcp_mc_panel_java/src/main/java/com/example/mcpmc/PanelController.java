package com.example.mcpmc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
public class PanelController {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("status", "running");
        model.addAttribute("players", 5);
        model.addAttribute("maxPlayers", 20);
        model.addAttribute("motd", "Welcome to MCP Minecraft Server!");
        model.addAttribute("plugins", Arrays.asList("Essentials", "WorldEdit", "Dynmap"));
        model.addAttribute("backups", Arrays.asList("backup_2024-06-01.zip", "backup_2024-06-02.zip"));
        return "index";
    }
} 