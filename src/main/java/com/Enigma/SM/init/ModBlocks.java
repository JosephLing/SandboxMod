package com.Enigma.SM.init;


import com.Enigma.SM.block.BlockExample;
import com.Enigma.SM.block.BlockSM;
import com.Enigma.SM.reference.Names;
import com.Enigma.SM.reference.Reference;
import com.Enigma.SM.utility.LogHelper;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{
    public static final BlockSM ExampleBlock = new BlockExample();

    public static void init()
    {
        GameRegistry.registerBlock(ExampleBlock, Names.Blocks.EXAMPLE_BLOCK);
        LogHelper.info("loaded blocks");
    }


}
