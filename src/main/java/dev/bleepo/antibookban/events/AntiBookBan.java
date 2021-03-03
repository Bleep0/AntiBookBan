package dev.bleepo.antibookban.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEditBookEvent;

import java.nio.charset.StandardCharsets;

public class AntiBookBan implements Listener {
    @EventHandler
    public void onBookEdit(PlayerEditBookEvent event) {
        for (String bookPage : event.getNewBookMeta().getPages()) {
            if (!StandardCharsets.ISO_8859_1.newEncoder().canEncode(bookPage)) {
                event.setCancelled(true);
            }
        }
    }
}
