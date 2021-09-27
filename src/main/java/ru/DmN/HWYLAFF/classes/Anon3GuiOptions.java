package ru.DmN.HWYLAFF.classes;

import mcp.mobius.waila.Waila;
import mcp.mobius.waila.api.impl.config.WailaConfig;
import mcp.mobius.waila.gui.GuiConfigWaila;
import mcp.mobius.waila.gui.GuiOptions;
import mcp.mobius.waila.gui.config.OptionsEntryButton;
import mcp.mobius.waila.gui.config.OptionsListWidget;
import mcp.mobius.waila.gui.config.value.OptionsEntryValueCycle;
import mcp.mobius.waila.gui.config.value.OptionsEntryValueEnum;
import mcp.mobius.waila.gui.config.value.OptionsEntryValueInput;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

public class Anon3GuiOptions extends GuiOptions {
    public final GuiConfigWaila instance;

    public Anon3GuiOptions(Screen parent, Text title, GuiConfigWaila instance) {
        super(parent, title);
        this.instance = instance;
    }

    public OptionsListWidget getOptions() {
        OptionsListWidget options = new OptionsListWidget(this, this.client, this.width + 45, this.height, 32, this.height - 32, 30);
        options.add(new OptionsEntryValueInput(Util.createTranslationKey("config", new Identifier("waila", "overlay_pos_x")), Waila.CONFIG.get().getOverlay().getOverlayPosX(), val -> Waila.CONFIG.get().getOverlay().setOverlayPosX((float)Math.min(1.0, Math.max(0.0, (Double)val))), OptionsEntryValueInput.FLOAT));
        options.add(new OptionsEntryValueInput(Util.createTranslationKey("config", new Identifier("waila", "overlay_pos_y")), Waila.CONFIG.get().getOverlay().getOverlayPosY(), val -> Waila.CONFIG.get().getOverlay().setOverlayPosY((float)Math.min(1.0, Math.max(0.0, (Double)val))), OptionsEntryValueInput.FLOAT));
        options.add(new OptionsEntryValueEnum(Util.createTranslationKey("config", new Identifier("waila", "overlay_size")), WailaConfig.ConfigOverlay.SizeChoice.values(), Waila.CONFIG.get().getOverlay().getOverlaySize(), val -> Waila.CONFIG.get().getOverlay().setOverlaySize((WailaConfig.ConfigOverlay.SizeChoice) val)));
        options.add(new OptionsEntryButton(Util.createTranslationKey("config", new Identifier("waila", "overlay_color")), new ButtonWidget(0, 0, 100, 20, new LiteralText(""), w -> this.client.setScreen(new GuiOptions(this.instance, new TranslatableText(Util.createTranslationKey("config", new Identifier("waila", "overlay_color")))){

            public OptionsListWidget getOptions() {
                OptionsListWidget options = new OptionsListWidget(this, this.client, this.width + 45, this.height, 32, this.height - 32, 30);
                options.add(new OptionsEntryValueInput(Util.createTranslationKey("config", new Identifier("waila", "overlay_alpha")), Waila.CONFIG.get().getOverlay().getColor().getRawAlpha(), val -> ((WailaConfig)Waila.CONFIG.get()).getOverlay().getColor().setAlpha((int)Math.min(100.0, Math.max(0.0, (Double)val))), OptionsEntryValueInput.INTEGER));
                options.add(new OptionsEntryValueCycle(Util.createTranslationKey("config", new Identifier("waila", "overlay_theme")), Waila.CONFIG.get().getOverlay().getColor().getThemes().stream().map(t -> t.getId().toString()).sorted(String::compareToIgnoreCase).toArray(String[]::new), Waila.CONFIG.get().getOverlay().getColor().getTheme().getId().toString(), val -> Waila.CONFIG.get().getOverlay().getColor().applyTheme(new Identifier(val))));
                return options;
            }
        }))));
        return options;
    }

    public static class Anon3GuiOptions$1 extends GuiOptions {
        Anon3GuiOptions$1(Screen x0, Text x1) {
            super(x0, x1);
        }

        public OptionsListWidget getOptions() {
            OptionsListWidget options = new OptionsListWidget(this, this.client, this.width + 45, this.height, 32, this.height - 32, 30);
            options.add(new OptionsEntryValueInput(Util.createTranslationKey("config", new Identifier("waila", "overlay_alpha")), Waila.CONFIG.get().getOverlay().getColor().getRawAlpha(), val -> Waila.CONFIG.get().getOverlay().getColor().setAlpha((int)Math.min(100.0, Math.max(0.0, (Double)val))), OptionsEntryValueInput.INTEGER));
            options.add(new OptionsEntryValueCycle(Util.createTranslationKey("config", new Identifier("waila", "overlay_theme")), Waila.CONFIG.get().getOverlay().getColor().getThemes().stream().map(t -> t.getId().toString()).sorted(String::compareToIgnoreCase).toArray(String[]::new), Waila.CONFIG.get().getOverlay().getColor().getTheme().getId().toString(), val -> Waila.CONFIG.get().getOverlay().getColor().applyTheme(new Identifier(val))));
            return options;
        }
    }
}