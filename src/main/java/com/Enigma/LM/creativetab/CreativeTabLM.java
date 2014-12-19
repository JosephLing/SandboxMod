package com.Enigma.LM.creativetab;


import com.Enigma.LM.init.ModItems;
import com.Enigma.LM.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabLM
{
    public static final CreativeTabs LM_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase())
    {
        @Override
        public Item getTabIconItem()
        {
            return ModItems.ExampleItem;
        }
    };
}
