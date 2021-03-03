package dev.bleepo.antibookban.events;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEditBookEvent;

import java.nio.charset.StandardCharsets;

public class AntiBookBan implements Listener {
    public void onBookEdit(PlayerEditBookEvent event) {
        for (String bookPage : event.getNewBookMeta().getPages()) {
            if (!StandardCharsets.US_ASCII.newEncoder().canEncode(bookPage)) {
                event.setCancelled(true);
            }
        }
    }
}