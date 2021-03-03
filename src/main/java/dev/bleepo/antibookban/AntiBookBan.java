package dev.bleepo.antibookban;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class AntiBookBan extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info(ChatColor.DARK_GREEN + "Loading Classes...");
        getServer().getPluginManager().registerEvents(new dev.bleepo.antibookban.events.AntiBookBan(), this);
        getLogger().info(ChatColor.DARK_GREEN + "AntiBookBan by Bleepo has been loaded and enabled!");

    }

    @Override
    public void onDisable() {
        getLogger().info(ChatColor.DARK_GREEN + "AntiBookBan by Bleepo has been unloaded and disabled!");

    }
}
