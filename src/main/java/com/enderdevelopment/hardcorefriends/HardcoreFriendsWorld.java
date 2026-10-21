package com.enderdevelopment.hardcorefriends;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.gen.chunk.ChunkGenerator;

public class HardcoreFriendsWorld {
    public static void resetWorld(MinecraftServer server) {
        ServerWorld world = server.getOverworld();
        ChunkGenerator chunkGenerator = world.getChunkManager().getChunkGenerator();
        long newSeed = world.getSeed() + 1;
        world.setSeed(newSeed);
        world.getGameRules().get(GameRules.SPAWN_RADIUS).set(0, server);
        HardcoreFriendsTeleport.teleportAllPlayersToSpawn(server);
        HardcoreFriendsInventory.clearAllInventories(server);
        HardcoreFriendsExperience.resetAllExperience(server);
        HardcoreFriendsHealth.resetAllHealth(server);
    }
}