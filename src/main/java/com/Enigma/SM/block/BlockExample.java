package com.Enigma.SM.block;


import com.Enigma.SM.reference.Names;

public class BlockExample extends BlockSM
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
