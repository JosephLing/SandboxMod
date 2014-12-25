package com.Enigma.SM;

import com.Enigma.SM.client.handler.KeyInputEventHandler;
import com.Enigma.SM.handler.ConfiguartionHandler;
import com.Enigma.SM.init.ModBlocks;
import com.Enigma.SM.init.ModItems;
import com.Enigma.SM.init.ModWorldGen;
import com.Enigma.SM.init.Recipes;
import com.Enigma.SM.proxy.IProxy;
import com.Enigma.SM.reference.Reference;
import com.Enigma.SM.utility.LogHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid= Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.MOD_VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class SandboxMod
{
    @Mod.Instance(Reference.MOD_ID)
    public static SandboxMod instance;

    @SidedProxy(clientSide = Reference.ClIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        // mod config files, networking handling, initialize items and blocks
        ConfiguartionHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfiguartionHandler());

        proxy.registerKeyBindings();

        ModItems.init();
        ModBlocks.init();

        // has to be called after blocks and items are initialized
        ModWorldGen.init();

        LogHelper.info(ConfiguartionHandler.DG_LOAD);
        LogHelper.info(ConfiguartionHandler.DG_XSIZE);

        LogHelper.info("Pre initalisation complete :)");

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        // tile enitities, crafting recipes
        FMLCommonHandler.instance().bus().register(new KeyInputEventHandler());


        Recipes.init();
        ModWorldGen.init();

        LogHelper.info("initalisation complete :)");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        // wrapping things up
        LogHelper.info("Post initalisation complete :)");

        /*
        LogHelper.info("Registered Ores: ");
        for (String Ore : OreDictionary.getOreNames())
        {
            LogHelper.info(Ore);
        }
        */
    }


}
