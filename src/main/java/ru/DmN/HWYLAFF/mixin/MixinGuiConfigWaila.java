package ru.DmN.HWYLAFF.mixin;

import mcp.mobius.waila.Waila;
import mcp.mobius.waila.gui.GuiConfigWaila;
import mcp.mobius.waila.gui.GuiOptions;
import mcp.mobius.waila.gui.config.OptionsEntryButton;
import mcp.mobius.waila.gui.config.OptionsListWidget;
import mcp.mobius.waila.utils.JsonConfig;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import ru.DmN.HWYLAFF.classes.Anon2GuiOptions;
import ru.DmN.HWYLAFF.classes.Anon3GuiOptions;
import ru.DmN.HWYLAFF.classes.Anon4GuiOptions;

import java.util.Objects;

@Mixin(GuiConfigWaila.class)
public abstract class MixinGuiConfigWaila extends GuiOptions {
    /** Not Used */
    public MixinGuiConfigWaila() { super(null, null); }

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
        JsonConfig var10009 = Waila.CONFIG;
        Objects.requireNonNull(var10009);
        OptionsListWidget options = new OptionsListWidget(this, var10003, var10004, var10005, 32, var10007, 30, var10009::save);
        options.add(new OptionsEntryButton(Util.createTranslationKey("config", new Identifier("waila", "general")), new ButtonWidget(0, 0, 100, 20, new LiteralText(""), (w) -> this.client.openScreen(new Anon2GuiOptions(this, new TranslatableText(Util.createTranslationKey("config", new Identifier("waila", "general"))))))));
        options.add(new OptionsEntryButton(Util.createTranslationKey("config", new Identifier("waila", "overlay")), new ButtonWidget(0, 0, 100, 20, new LiteralText(""), (w) -> this.client.openScreen(new Anon3GuiOptions(this, new TranslatableText(Util.createTranslationKey("config", new Identifier("waila", "overlay"))), (GuiConfigWaila) (Object) this)))));
        options.add(new OptionsEntryButton(Util.createTranslationKey("config", new Identifier("waila", "formatting")), new ButtonWidget(0, 0, 100, 20, new LiteralText(""), (w) -> this.client.openScreen(new Anon4GuiOptions(this, new TranslatableText(Util.createTranslationKey("config", new Identifier("waila", "overlay"))))))));
        return options;
    }
}
