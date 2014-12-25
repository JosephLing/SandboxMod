package com.Enigma.SM.init;


import com.Enigma.SM.worldgen.structures.*;
import com.sun.javafx.tools.packager.Log;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModWorldGen
{
    public static void init()
    {

        // ores


        // structures


        GameRegistry.registerWorldGenerator(new Dungeon(), 0);
        //GameRegistry.registerWorldGenerator(new ChunkBoundaries(), 0);


        Log.info("world gen done :)");
    }
}
