package com.Enigma.LM.init;


import com.Enigma.LM.block.BlockExample;
import com.Enigma.LM.block.BlockLM;
import com.Enigma.LM.reference.Names;
import com.Enigma.LM.reference.Reference;
import com.Enigma.LM.utility.LogHelper;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{
    public static final BlockLM ExampleBlock = new BlockExample();

    public static void init()
    {
        GameRegistry.registerBlock(ExampleBlock, Names.Blocks.EXAMPLE_BLOCK);
        LogHelper.info("loaded blocks");
    }


}
