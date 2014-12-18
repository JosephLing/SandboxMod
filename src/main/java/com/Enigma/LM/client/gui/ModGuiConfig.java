package com.Enigma.LM.client.gui;

import com.Enigma.LM.handler.ConfiguartionHandler;
import com.Enigma.LM.reference.Reference;
import cpw.mods.fml.client.config.GuiConfig;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.Configuration;


public class ModGuiConfig extends GuiConfig
{

    public ModGuiConfig(GuiScreen guiScreen)
    {
        super(guiScreen,
                new ConfigElement(ConfiguartionHandler.configuration.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
                Reference.MOD_ID,
                false,
                false,
                GuiConfig.getAbridgedConfigPath(ConfiguartionHandler.configuration.toString()));
    }
}
