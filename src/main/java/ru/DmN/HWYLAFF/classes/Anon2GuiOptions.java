package ru.DmN.HWYLAFF.classes;

import mcp.mobius.waila.Waila;
import mcp.mobius.waila.api.impl.config.WailaConfig;
import mcp.mobius.waila.gui.GuiOptions;
import mcp.mobius.waila.gui.config.OptionsListWidget;
import mcp.mobius.waila.gui.config.value.OptionsEntryValueBoolean;
import mcp.mobius.waila.gui.config.value.OptionsEntryValueEnum;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

public class Anon2GuiOptions extends GuiOptions {
    public Anon2GuiOptions(Screen parent, Text title) {
        super(parent, title);
    }

    public OptionsListWidget getOptions() {
        OptionsListWidget options = new OptionsListWidget(this, this.client, this.width + 45, this.height, 32, this.height - 32, 30);
        options.add(new OptionsEntryValueBoolean(Util.createTranslationKey("config", new Identifier("waila", "display_tooltip")), Waila.CONFIG.get().getGeneral().shouldDisplayTooltip(), val -> Waila.CONFIG.get().getGeneral().setDisplayTooltip(val)));
        options.add(new OptionsEntryValueBoolean(Util.createTranslationKey("config", new Identifier("waila", "display_fluids")), Waila.CONFIG.get().getGeneral().shouldDisplayFluids(), val -> Waila.CONFIG.get().getGeneral().setDisplayFluids(val)));
        options.add(new OptionsEntryValueBoolean(Util.createTranslationKey("config", new Identifier("waila", "sneaky_details")), Waila.CONFIG.get().getGeneral().shouldShiftForDetails(), val -> Waila.CONFIG.get().getGeneral().setShiftForDetails(val)));
        options.add(new OptionsEntryValueEnum(Util.createTranslationKey("config", new Identifier("waila", "display_mode")), WailaConfig.DisplayMode.values(), (Waila.CONFIG.get()).getGeneral().getDisplayMode(), val -> Waila.CONFIG.get().getGeneral().setDisplayMode((WailaConfig.DisplayMode) val)));
        options.add(new OptionsEntryValueBoolean(Util.createTranslationKey("config", new Identifier("waila", "hide_from_players")), Waila.CONFIG.get().getGeneral().shouldHideFromPlayerList(), val -> Waila.CONFIG.get().getGeneral().setHideFromPlayerList(val)));
        options.add(new OptionsEntryValueBoolean(Util.createTranslationKey("config", new Identifier("waila", "hide_from_debug")), Waila.CONFIG.get().getGeneral().shouldHideFromDebug(), val -> Waila.CONFIG.get().getGeneral().setHideFromDebug(val)));
        options.add(new OptionsEntryValueBoolean(Util.createTranslationKey("config", new Identifier("waila", "display_item")), Waila.CONFIG.get().getGeneral().shouldShowItem(), val -> Waila.CONFIG.get().getGeneral().setShowItem(val)));
        options.add(new OptionsEntryValueBoolean(Util.createTranslationKey("config", new Identifier("waila", "tts")), Waila.CONFIG.get().getGeneral().shouldEnableTextToSpeech(), val -> Waila.CONFIG.get().getGeneral().setEnableTextToSpeech(val)));
        return options;
    }
}
