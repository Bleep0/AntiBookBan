package dev.bleepo.antibookban.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEditBookEvent;

import java.nio.charset.StandardCharsets;

public class AntiBookBan implements Listener {
    private final dev.bleepo.antibookban.AntiBookBan plugin;

    public AntiBookBan(dev.bleepo.antibookban.AntiBookBan plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBookEdit(PlayerEditBookEvent e) {
        Player player = e.getPlayer();
        for (String bookPage : e.getNewBookMeta().getPages()) {
            if (!StandardCharsets.US_ASCII.newEncoder().canEncode(bookPage)) {
                e.setCancelled(true);
                String antiBookBan = plugin.getConfig().getString("message");
                assert antiBookBan != null;
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', antiBookBan));
            }
        }
    }
}
