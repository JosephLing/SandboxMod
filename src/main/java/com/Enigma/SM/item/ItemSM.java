package com.Enigma.SM.item;

import com.Enigma.SM.creativetab.CreativeTabSM;

import com.Enigma.SM.reference.Textures;
import com.Enigma.SM.utility.LogHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemSM extends Item
{
    // common class that is a wrapper and is the base for all other items of this mod

    public ItemSM()
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
        this.setCreativeTab(CreativeTabSM.SM_TAB);

    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("item.%s%s", Textures.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return String.format("item.%s%s", Textures.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        LogHelper.info(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
        itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

}
