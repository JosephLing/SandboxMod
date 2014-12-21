package com.Enigma.SM.handler;


import com.Enigma.SM.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;
import java.io.File;

public class ConfiguartionHandler
{
    public static Configuration configuration;

    public static boolean testValue = false;

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
        testValue = configuration.getBoolean("configValue", Configuration.CATEGORY_GENERAL, false, "example config value");


        if (configuration.hasChanged())
        {
            configuration.save();
        }
    }


}
