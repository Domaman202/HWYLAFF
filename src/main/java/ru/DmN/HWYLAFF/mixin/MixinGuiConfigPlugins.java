package ru.DmN.HWYLAFF.mixin;

import mcp.mobius.waila.api.impl.config.PluginConfig;
import mcp.mobius.waila.gui.GuiConfigPlugins;
import mcp.mobius.waila.gui.GuiOptions;
import mcp.mobius.waila.gui.config.OptionsEntryButton;
import mcp.mobius.waila.gui.config.OptionsListWidget;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import ru.DmN.HWYLAFF.classes.Anon1GuiOptions;

import java.util.Objects;

@Mixin(GuiConfigPlugins.class)
public abstract class MixinGuiConfigPlugins extends GuiOptions {
    /** Not Used */
    public MixinGuiConfigPlugins() { super(null, null); }

    /**
     * @author DomamaN202
     * @reason Fix
     */
    @Overwrite(remap = false)
    public OptionsListWidget getOptions() {
        MinecraftClient var10003 = this.client;
        int var10004 = this.width + 45;
        int var10005 = this.height;
        int var10007 = this.height - 32;
        PluginConfig var10009 = PluginConfig.INSTANCE;
        Objects.requireNonNull(var10009);
        OptionsListWidget options = new OptionsListWidget(this, var10003, var10004, var10005, 32, var10007, 30, var10009::save);
        PluginConfig.INSTANCE.getNamespaces().forEach((namespace) -> {
            String translationKey = "config.waila.plugin_" + namespace;
            options.add(new OptionsEntryButton(translationKey, new ButtonWidget(0, 0, 100, 20, new LiteralText(""), (w) -> this.client.currentScreen = new Anon1GuiOptions(this, new TranslatableText(translationKey), PluginConfig.INSTANCE.getKeys(namespace), translationKey))));
        });
        return options;
    }
}
