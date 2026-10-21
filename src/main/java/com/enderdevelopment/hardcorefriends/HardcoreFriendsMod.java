package com.enderdevelopment.hardcorefriends;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HardcoreFriendsMod implements ModInitializer {
    public static final String MOD_ID = "hardcorefriends";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    private static MinecraftServer server;

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Hardcore Friends Mod");
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            HardcoreFriendsCommands.register(dispatcher);
        });
        ServerLifecycleEvents.SERVER_STARTING.register(this::setServer);
        ServerLifecycleEvents.SERVER_STOPPING.register(server -> HardcoreFriendsMod.server = null);
    }

    public static MinecraftServer getServer() {
        return server;
    }

    private void setServer(MinecraftServer server) {
        HardcoreFriendsMod.server = server;
    }
}