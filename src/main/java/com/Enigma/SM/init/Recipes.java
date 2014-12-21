package com.Enigma.SM.init;


import com.Enigma.SM.reference.Names;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

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





        Item that you are getting

        items that required for the recipe


        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ExampleItem), new ItemStack(Items.diamond), new ItemStack(Items.diamond));

        // modded recipe

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.ExampleItem), " s ", "sss", " s ", 's',  "stickWood"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.ExampleItem), new ItemStack(Items.diamond), new ItemStack(Items.diamond)));
        */


        // shaped recipes
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.Excabular), " m ", " m ", " s ", 's', "stickWood", 'm', new ItemStack(ModItems.IngotTest)));
        GameRegistry.addRecipe(new ItemStack(ModItems.ExampleItem), " s ", "sss", " s ", 's',  new ItemStack(Items.stick));


        // furnace recipes
        GameRegistry.addSmelting(new ItemStack(ModBlocks.ExampleBlock), new ItemStack(ModItems.IngotTest), 0.1f);
    }
}
