package com.enderdevelopment.hardcorefriends;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;

public class HardcoreFriendsExperience {
    public static void resetAllExperience(MinecraftServer server) {
        for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
            player.totalExperience = 0;
            player.experienceLevel = 0;
            player.experienceProgress = 0;
        }
    }
}