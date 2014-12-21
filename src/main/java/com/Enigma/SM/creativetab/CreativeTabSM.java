package com.Enigma.SM.creativetab;


import com.Enigma.SM.init.ModItems;
import com.Enigma.SM.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabSM
{
    public static final CreativeTabs SM_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase())
    {
        @Override
        public Item getTabIconItem()
        {
            return ModItems.ExampleItem;
        }
    };
}
