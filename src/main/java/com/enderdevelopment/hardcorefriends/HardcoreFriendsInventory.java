package com.enderdevelopment.hardcorefriends;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;

public class HardcoreFriendsInventory {
    public static void clearAllInventories(MinecraftServer server) {
        for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
            player.getInventory().clear();
            player.getEnderChestInventory().clear();
        }
    }
}