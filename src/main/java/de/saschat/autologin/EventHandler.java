package de.saschat.autologin;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;


public class EventHandler {
    Boolean loggedIn = false;
    public static Configuration config;
    private Minecraft mc = Minecraft.getMinecraft();
    public EventHandler(Configuration con) {
        config = con;
    }
    private String getPassword() {
        String pw = "";
        try {
            config.load();
            Property passwordR = config.get(Configuration.CATEGORY_GENERAL,
                    "password",
                    "The Password to use");
            return passwordR.getString();

        } catch (Exception e) {
            // OOF
        }
        return null;
    }
    @SubscribeEvent
    public void onChatMessage(ClientChatReceivedEvent ev) {
        if(ev.message.getUnformattedText().toLowerCase().contains("/login") && !loggedIn) {
            String password = getPassword();
            if(password != null) {
                loggedIn = true;
                mc.thePlayer.sendChatMessage("/login " + password);
            }
        }
    }
    @SubscribeEvent
    public void onLeaveEvent(PlayerEvent.PlayerLoggedOutEvent ev) {
        if(ev.player == Minecraft.getMinecraft().thePlayer) {
            loggedIn = false;
        }
    }
}
