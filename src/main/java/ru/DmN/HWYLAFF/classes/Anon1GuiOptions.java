package ru.DmN.HWYLAFF.classes;

import java.util.Set;
import mcp.mobius.waila.api.impl.config.ConfigEntry;
import mcp.mobius.waila.api.impl.config.PluginConfig;
import mcp.mobius.waila.gui.GuiOptions;
import mcp.mobius.waila.gui.config.OptionsListWidget;
import mcp.mobius.waila.gui.config.value.OptionsEntryValueBoolean;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class Anon1GuiOptions
        extends GuiOptions {
    private final Set<Identifier> keys;
    private final String translationKey;

    public Anon1GuiOptions(Screen parent, Text title, Set<Identifier> keys, String translationKey) {
        super(parent, title);
        this.keys = keys;
        this.translationKey = translationKey;
    }

    public OptionsListWidget getOptions() {
        OptionsListWidget options = new OptionsListWidget(this, this.client, this.width + 45, this.height, 32, this.height - 32, 30);
        this.keys.stream().sorted((o1, o2) -> o1.getPath().compareToIgnoreCase(o2.getPath())).forEach(i -> {
            ConfigEntry entry = PluginConfig.INSTANCE.getEntry(i);
            if (!entry.isSynced() || MinecraftClient.getInstance().getCurrentServerEntry() == null) {
                options.add(new OptionsEntryValueBoolean(this.translationKey + "." + i.getPath(), entry.getValue(), b -> PluginConfig.INSTANCE.set(i, b)));
            }
        });
        return options;
    }
}
