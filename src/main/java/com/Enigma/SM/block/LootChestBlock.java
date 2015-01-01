package com.Enigma.SM.block;

import com.Enigma.SM.reference.Names;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;


import java.util.Random;

public class LootChestBlock extends BlockSM
{
    public LootChestBlock()
    {
        super(Material.wood);
        this.setBlockName(Names.Blocks.LOOTCHEST_BLOCK);
        this.setHardness(1.5F);
        this.setResistance(10.0F);
    }

    public Item getItemDropped(int p_149650_1_, Random random, int p_149650_3_)
    {
        /*
        should probably create a seperate class to deal with the loot specailly if other mods want to add items in.
        */

        int ItemType = random.nextInt(5);
        int Chance = random.nextInt(30);
        switch (ItemType) {
            case 0: // precious metals

                if (Chance <= 8)
                {
                    return Items.coal;
                }
                else if (Chance <= 14 )
                {
                    return Items.gold_nugget;
                }
                else if (Chance <= 22)
                {
                    return Items.gold_ingot;
                }
                else if (Chance <= 27)
                {
                    return Items.emerald;
                }
                else
                {
                    return Items.iron_ingot;
                }



            case 1: // armour

                if (Chance <= 5)
                {
                    return Items.leather;
                }
                else if (Chance <= 12 )
                {
                    return Items.feather;
                }
                else if (Chance <= 18 )
                {
                    return Items.flint;
                }
                else if (Chance <= 22 )
                {
                    return Items.coal;
                }
                else if (Chance <= 27)
                {
                    return Items.ender_pearl;
                }
                else
                {
                    return Items.quartz;
                }




            case 2: // food
                if (Chance <= 3 )
                {
                    return Items.string;
                }
                else if (Chance <= 15)
                {
                    return Items.wheat;
                }
                else if (Chance <= 27)
                {
                    return Items.apple;
                }
                else
                {
                    return Items.golden_apple;
                }


            // roughly +40% to give nothing
            case 3:
                return Items.stick;
            case 4:
                return Items.stick;

            default:
                return Items.stick;
        }



    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random random)
    {
        return 3 + random.nextInt(3);
    }

    /**
     * Returns the usual quantity dropped by the block plus a bonus of 1 to 'i' (inclusive).
     */
    public int quantityDroppedWithBonus(int chance, Random random)
    {
        if (chance > 0 && Item.getItemFromBlock(this) != this.getItemDropped(0, random, chance))
        {
            int prob = random.nextInt(chance + 2) - 1;

            if (prob < 0)
            {
                prob = 0;
            }

            return this.quantityDropped(random) * (prob + 1);
        }
        else
        {
            return this.quantityDropped(random);
        }
    }

}
