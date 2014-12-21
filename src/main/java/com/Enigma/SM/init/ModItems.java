package com.Enigma.SM.init;

import com.Enigma.SM.item.*;

import com.Enigma.SM.reference.Names;
import com.Enigma.SM.reference.Reference;
import com.Enigma.SM.utility.LogHelper;
import cpw.mods.fml.common.registry.GameRegistry;


@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{
    public static final ItemSM ExampleItem = new ItemExample();
    public static final ItemSwordExcabular Excabular = new ItemSwordExcabular();
    public static final ItemIngotTest IngotTest = new ItemIngotTest();

    public static final ItemSwordTest  SwordTest = new ItemSwordTest();


    public static void init()
    {
        GameRegistry.registerItem(ExampleItem, Names.Items.EXAMPLE_ITEM);
        GameRegistry.registerItem(Excabular, Names.Items.Excalablar);

        GameRegistry.registerItem(IngotTest, Names.Items.INGOT_TEST);

        GameRegistry.registerItem(SwordTest, Names.Weapons.SWORD_TEST);

        LogHelper.info("loaded items");
    }
    

}
