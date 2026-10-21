package com.enderdevelopment.hardcorefriends;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import static net.minecraft.server.command.CommandManager.literal;

public class HardcoreFriendsCommands {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(literal("hardcorefriends")
                .then(literal("reset").executes(HardcoreFriendsCommands::resetWorld))
                .then(literal("config").executes(HardcoreFriendsCommands::openConfig)));
    }

    private static int resetWorld(CommandContext<ServerCommandSource> context) {
        HardcoreFriendsWorld.resetWorld(context.getSource().getServer());
        context.getSource().sendFeedback(() -> Text.literal("World reset initiated."), false);
        return 1;
    }

    private static int openConfig(CommandContext<ServerCommandSource> context) {
        context.getSource().getPlayer().openHandledScreen(new HardcoreFriendsScreenHandlerFactory());
        return 1;
    }
}