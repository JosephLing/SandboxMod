package com.Enigma.LM.item;

import com.Enigma.LM.creativetab.CreativeTabLM;
import com.Enigma.LM.reference.Reference;
import com.Enigma.LM.utility.LogHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemLM extends Item
{
    // common class that is a wrapper and is the base for all other items of this mod

    public ItemLM()
    {
        // construcuter
        /*
        An item stack being an instance of item or an item block

        multiple parts that make up an item stack

        nbt -> named binary tag
        can save all kinds of data to it

        an item stack stores all its nbt data in a COMPOUND

        tag compound not always initailized

        nbt applies to tile entities



         */
        super();
        this.setCreativeTab(CreativeTabLM.LM_TAB);

    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }



    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    @Override
    @SideOnly(Side.CLIENT) // sets it to only be client side code
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }
}
