package ru.DmN.HWYLAFF.classes;

import mcp.mobius.waila.Waila;
import mcp.mobius.waila.gui.GuiOptions;
import mcp.mobius.waila.gui.config.OptionsListWidget;
import mcp.mobius.waila.gui.config.value.OptionsEntryValueInput;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import org.apache.commons.lang3.StringEscapeUtils;

public class Anon4GuiOptions extends GuiOptions {
    public Anon4GuiOptions(Screen parent, Text title) {
        super(parent, title);
    }

    public OptionsListWidget getOptions() {
        OptionsListWidget options = new OptionsListWidget(this, this.client, this.width + 45, this.height, 32, this.height - 32, 30);
        options.add(new OptionsEntryValueInput(Util.createTranslationKey("config", new Identifier("waila", "format_mod_name")), StringEscapeUtils.escapeJava(Waila.CONFIG.get().getFormatting().getModName()), val -> Waila.CONFIG.get().getFormatting().setModName(!((String) val).isEmpty() && ((String) val).contains("%s") ? ((String) val) : Waila.CONFIG.get().getFormatting().getModName())));
        options.add(new OptionsEntryValueInput(Util.createTranslationKey("config", new Identifier("waila", "format_block_name")), StringEscapeUtils.escapeJava(Waila.CONFIG.get().getFormatting().getBlockName()), val -> Waila.CONFIG.get().getFormatting().setBlockName(!((String) val).isEmpty() && ((String) val).contains("%s") ? ((String) val) : Waila.CONFIG.get().getFormatting().getBlockName())));
        options.add(new OptionsEntryValueInput(Util.createTranslationKey("config", new Identifier("waila", "format_fluid_name")), StringEscapeUtils.escapeJava(Waila.CONFIG.get().getFormatting().getFluidName()), val -> Waila.CONFIG.get().getFormatting().setFluidName(!((String) val).isEmpty() && ((String) val).contains("%s") ? ((String) val) : Waila.CONFIG.get().getFormatting().getFluidName())));
        options.add(new OptionsEntryValueInput(Util.createTranslationKey("config", new Identifier("waila", "format_entity_name")), StringEscapeUtils.escapeJava(Waila.CONFIG.get().getFormatting().getEntityName()), val -> Waila.CONFIG.get().getFormatting().setEntityName(!((String) val).isEmpty() && ((String) val).contains("%s") ? ((String) val) : Waila.CONFIG.get().getFormatting().getEntityName())));
        options.add(new OptionsEntryValueInput(Util.createTranslationKey("config", new Identifier("waila", "format_registry_name")), StringEscapeUtils.escapeJava(Waila.CONFIG.get().getFormatting().getRegistryName()), val -> Waila.CONFIG.get().getFormatting().setRegistryName(!((String) val).isEmpty() && ((String) val).contains("%s") ? ((String) val) : Waila.CONFIG.get().getFormatting().getRegistryName())));
        return options;
    }
}