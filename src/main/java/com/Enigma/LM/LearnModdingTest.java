package com.Enigma.LM;

import com.Enigma.LM.configuration.ConfiguartionHandler;
import com.Enigma.LM.proxy.IProxy;
import com.Enigma.LM.reference.Reference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid= Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.MOD_VERSION )
public class LearnModdingTest
{
    @Mod.Instance(Reference.MOD_ID)
    public static LearnModdingTest instance;

    @SidedProxy(clientSide = Reference.ClIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        // mod config files, networking handling, initialize items and blocks
        ConfiguartionHandler.init(event.getSuggestedConfigurationFile());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        // tile enitities, crafting recipes
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        // wrapping things up
    }


}
