package com.Enigma.SM.Dungeon;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import java.util.Random;

public class LootChestRand
{
    public Random rand;
    // Item.getItemFromBlock(Blocks.torch)
    public static randItem[] LootChest_DUNGEON = {};


    public LootChestRand(Random random)
    {
        this.rand = random;
    }

    public Item getCrate()
    {
        Item.getItemFromBlock(Blocks.torch);

        return Items.apple;
    }
}
