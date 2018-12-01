package de.saschat.autologin;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

import java.awt.*;

@Mod(modid = AutoLoginMod.MODID, version = AutoLoginMod.VERSION)
public class AutoLoginMod
{
    public static final String MODID = "sascha-autologin";
    public static final String VERSION = "1.0";
    public static de.saschat.autologin.EventHandler EVENT_HANDLER;
    @EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
		// some example code
        EVENT_HANDLER = new de.saschat.autologin.EventHandler(new Configuration(event.getSuggestedConfigurationFile()));;
        MinecraftForge.EVENT_BUS.register(EVENT_HANDLER);
    }
}
