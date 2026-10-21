package com.enderdevelopment.hardcorefriends;

import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;

public class HardcoreFriendsEvents {
    public static void registerEvents() {
        ServerPlayerEvents.AFTER_RESPAWN.register((oldPlayer, newPlayer, alive) -> {
            if (!alive) {
                HardcoreFriendsChat.broadcastDeathMessage(newPlayer);
            }
        });

        ServerLifecycleEvents.SERVER_STARTED.register(HardcoreFriendsEvents::onServerStarted);
    }

    private static void onServerStarted(MinecraftServer server) {
        HardcoreFriendsConfig.loadConfig();
    }
}