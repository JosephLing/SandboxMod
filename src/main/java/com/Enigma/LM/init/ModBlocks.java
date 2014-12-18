package com.Enigma.LM.init;


import com.Enigma.LM.block.BlockExample;
import com.Enigma.LM.block.BlockLM;
import com.Enigma.LM.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{
    public static final BlockLM Example = new BlockExample();

    public static void init()
    {
        GameRegistry.registerBlock(Example, "ExampleBlock");
    }


}
