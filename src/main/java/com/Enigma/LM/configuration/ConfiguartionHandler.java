package com.Enigma.LM.configuration;


import com.Enigma.LM.reference.Reference;
import net.minecraftforge.common.config.Configuration;
import java.io.File;

public class ConfiguartionHandler
{

    public static void init(File configFile)
    {
        // create the configuation object from the given
        Configuration configuration = new Configuration(configFile);
        boolean ConfigValue = false; // test example
        try
        {
            // Load the configuartion file
            configuration.load();

            // read in properties from configuartion file

            // load in value from configuration file, gets it, then as it is a property .getBoolean is used to get the value from the property
            ConfigValue = configuration.get(Configuration.CATEGORY_GENERAL, "configValue", true, "example").getBoolean(true);
        }
        catch (Exception e)
        {
            // Log the exception
        }
        finally
        {
            configuration.save();
        }
        System.out.println("Configuartion: " + Reference.MOD_NAME + " : ConfigValue -> " + ConfigValue);



    }
}
