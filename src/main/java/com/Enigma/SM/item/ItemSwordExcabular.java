package com.Enigma.SM.item;

import com.Enigma.SM.creativetab.CreativeTabSM;
import com.Enigma.SM.reference.Names;

import com.Enigma.SM.reference.Textures;
import com.Enigma.SM.utility.LogHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemSwordExcabular extends ItemSword
{
    public ItemSwordExcabular()
    {
        super(ToolMaterial.IRON);

        this.setCreativeTab(CreativeTabSM.SM_TAB);
        this.maxStackSize = 1;
        this.setUnlocalizedName(Names.Items.Excalablar);
        LogHelper.info("sword item");
        LogHelper.info(this.getUnlocalizedName());
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
        itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

}
