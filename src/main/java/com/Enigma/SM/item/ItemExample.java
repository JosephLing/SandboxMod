package com.Enigma.SM.item;


import com.Enigma.SM.reference.Names;
import com.Enigma.SM.utility.LogHelper;

public class ItemExample extends ItemSM
{
    public ItemExample()
    {
        super();
        this.setUnlocalizedName(Names.Items.EXAMPLE_ITEM);

        LogHelper.info("example item");
        LogHelper.info(this.getUnlocalizedName());
    }
}
