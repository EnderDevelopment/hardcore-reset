package com.enderdevelopment.hardcorefriends;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class HardcoreFriendsModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(HardcoreFriendsScreenHandler.HARDCORE_FRIENDS_SCREEN_HANDLER_TYPE, HardcoreFriendsScreen::new);
    }
}