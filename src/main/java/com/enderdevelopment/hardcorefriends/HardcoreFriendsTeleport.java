package com.enderdevelopment.hardcorefriends;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class HardcoreFriendsTeleport {
    public static void teleportAllPlayersToSpawn(MinecraftServer server) {
        World world = server.getOverworld();
        BlockPos spawnPos = world.getSpawnPos();
        for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
            player.teleport(world, spawnPos.getX(), spawnPos.getY(), spawnPos.getZ(), player.getYaw(), player.getPitch());
        }
    }
}