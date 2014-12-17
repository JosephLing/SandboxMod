package com.Enigma.LM;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid="LearnModdingTest", name="Learn Modding Test", version="1.7.2-1.0" )
public class LearnModdingTest
{
    @Mod.Instance("LearnModdingTest")
    public static LearnModdingTest instance;


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        // mod config files, networking handling, initialize items and blocks
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
