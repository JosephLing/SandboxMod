package com.Enigma.LM.init;

import com.Enigma.LM.item.ItemExample;
import com.Enigma.LM.item.ItemLM;
import com.Enigma.LM.reference.Names;
import com.Enigma.LM.reference.Reference;
import com.Enigma.LM.utility.LogHelper;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{
    public static final ItemLM ExampleItem = new ItemExample();

    public static void init()
    {
        GameRegistry.registerItem(ExampleItem, Names.Items.EXAMPLE_ITEM);
        LogHelper.info("loaded items");
    }
    

}
