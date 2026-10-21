package com.enderdevelopment.hardcorefriends;

import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

public class HardcoreFriendsChat {
    public static void broadcastDeathMessage(ServerPlayerEntity player) {
        Text message = Text.literal(player.getName().getString() + " has died and the world will reset.");
        player.getServer().getPlayerManager().broadcast(message, false);
    }
}