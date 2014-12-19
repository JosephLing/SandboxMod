package com.Enigma.LM.init;


import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class Recipes
{
    public static void init()
    {
        /*
        Item that you are getting from the recipe

        crafting slots:
        top row [ ][s][ ]
        mid row [s][s][s]
        fin row [ ][s][ ]

        character 's'
        Item that it refers to


        GameRegistry.addRecipe(new ItemStack(ModItems.ExampleItem), " s ", "sss", " s ", 's',  new ItemStack(Items.stick));


        Item that you are getting

        items that required for the recipe


        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ExampleItem), new ItemStack(Items.diamond), new ItemStack(Items.diamond));

        // modded recipe

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.ExampleItem), " s ", "sss", " s ", 's',  "stickWood"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.ExampleItem), new ItemStack(Items.diamond), new ItemStack(Items.diamond)));
        */
    }
}
