package com.enderdevelopment.hardcorefriends;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HardcoreFriendsConfig {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final File CONFIG_FILE = new File("./config/hardcorefriends.json");
    private static Config config;

    public static class Config {
        public boolean autoReset = true;
        public int resetDelay = 30;
        public boolean notifyDeaths = true;
    }

    public static void loadConfig() {
        if (!CONFIG_FILE.exists()) {
            config = new Config();
            saveConfig();
        } else {
            try (FileReader reader = new FileReader(CONFIG_FILE)) {
                config = GSON.fromJson(reader, Config.class);
            } catch (IOException e) {
                HardcoreFriendsMod.LOGGER.error("Failed to load config", e);
                config = new Config();
            }
        }
    }

    public static void saveConfig() {
        try (FileWriter writer = new FileWriter(CONFIG_FILE)) {
            GSON.toJson(config, writer);
        } catch (IOException e) {
            HardcoreFriendsMod.LOGGER.error("Failed to save config", e);
        }
    }

    public static Config getConfig() {
        if (config == null) {
            loadConfig();
        }
        return config;
    }
}