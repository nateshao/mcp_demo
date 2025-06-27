package com.example.mcpcloud;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ServiceRegistry {
    private static final Map<String, String> services = new ConcurrentHashMap<>();

    public static void register(String name, String address) {
        services.put(name, address);
    }

    public static boolean unregister(String name) {
        return services.remove(name) != null;
    }

    public static Map<String, String> list() {
        return services;
    }
} 