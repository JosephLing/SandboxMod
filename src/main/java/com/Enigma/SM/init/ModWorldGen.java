package com.Enigma.SM.init;


import com.Enigma.SM.worldgen.structures.ChunkBoundaries;
import com.Enigma.SM.worldgen.structures.ExampleFlag;
import com.Enigma.SM.worldgen.structures.genRooms;
import com.Enigma.SM.worldgen.structures.generateStructures;
import com.sun.javafx.tools.packager.Log;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModWorldGen
{
    public static void init()
    {

        // ores


        // structures
        GameRegistry.registerWorldGenerator(new ChunkBoundaries(), 0);
        //GameRegistry.registerWorldGenerator(new ExampleFlag(), 0);
        GameRegistry.registerWorldGenerator(new generateStructures(), 0);


        Log.info("world gen done :)");
    }
}
