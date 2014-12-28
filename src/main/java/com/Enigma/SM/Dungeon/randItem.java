package com.Enigma.SM.Dungeon;

import net.minecraft.item.Item;

/**
 * Created on 27/12/2014 part of com.Enigma.SM.Dungeon.
 */
public class randItem
{
    public int Weight;
    public Item ItemName;

    public void randItem(Item ItemName, int Weight)
    {
        /*
        The higher the weight the more likely it is to spawn

         */
        if (Weight >= 100 || Weight < 0)
        {
            throw new IllegalArgumentException("Weight is not inside the bounds of 0 to 100 ");
        }
        else
        {
            this.Weight = Weight;
            this.ItemName = ItemName;
        }
    }

}
