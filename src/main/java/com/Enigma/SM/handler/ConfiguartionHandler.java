package com.Enigma.SM.handler;


import com.Enigma.SM.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;
import java.io.File;

public class ConfiguartionHandler
{
    public static Configuration configuration;

    public static boolean DG_LOAD = true;
    public static int DG_XSIZE = 50;
    public static int DG_ZSIZE = 50;
    public static int DG_YValue = 30;
    public static int DG_nTRIES = 500;

    public static void init(File configFile)
    {

        if (configuration == null)
        {
            configuration = new Configuration(configFile);
            loadConfiguation();
        }


    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.modID.equalsIgnoreCase(Reference.MOD_ID))
        {
            // ReSync configs
            loadConfiguation();
        }
    }


    private static void loadConfiguation()
    {
        DG_LOAD = configuration.getBoolean("LoadDG", Configuration.CATEGORY_GENERAL, true, "example config value");

        DG_nTRIES = configuration.getInt("nDungeonRoomTries", Configuration.CATEGORY_GENERAL,100, 250 ,2500, "the number of attempts to create a room");
        DG_XSIZE = configuration.getInt("DungeonXsize", Configuration.CATEGORY_GENERAL,50, 30, 500, "how large the dungeon will be in the X direction");
        DG_ZSIZE = configuration.getInt("DungeonZsize", Configuration.CATEGORY_GENERAL,50, 30, 500, "how large the dungeon will be in the Z direction");
        DG_YValue = configuration.getInt("DungeonYvalue", Configuration.CATEGORY_GENERAL,50,3,100,"the value of y in which the dungeon will spawn");



        if (configuration.hasChanged())
        {
            configuration.save();
        }
    }


}
