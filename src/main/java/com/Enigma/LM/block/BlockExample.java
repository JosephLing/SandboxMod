package com.Enigma.LM.block;


import com.Enigma.LM.reference.Names;

public class BlockExample extends BlockLM
{
    public BlockExample()
    {
        super();
        this.setBlockName(Names.Blocks.EXAMPLE_BLOCK);
        this.setHardness(1.5F);
        this.setResistance(10.0F);
        this.setStepSound(soundTypeLadder);

        // .setHardness(1.5F).setResistance(10.0F).setStepSound(soundTypePiston).
    }
}
