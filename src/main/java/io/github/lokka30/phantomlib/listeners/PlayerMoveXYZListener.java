package io.github.lokka30.phantomlib.listeners;

import io.github.lokka30.phantomlib.events.PlayerMoveFullXYZEvent;
import io.github.lokka30.phantomlib.events.PlayerMoveXYZEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerMoveXYZListener implements Listener {

    @EventHandler
    public void onMoveXYZ(final PlayerMoveXYZEvent event) {
        final Location to = event.getTo();
        final Location from = event.getFrom();

        if (from.getBlockX() != to.getBlockX() || from.getBlockY() != to.getBlockY() || from.getBlockZ() != to.getBlockZ()) {
            PlayerMoveFullXYZEvent playerMoveFullXYZEvent = new PlayerMoveFullXYZEvent(event.getPlayer(), from, to);
            Bukkit.getPluginManager().callEvent(playerMoveFullXYZEvent);
            if (playerMoveFullXYZEvent.isCancelled()) {
                event.setCancelled(true);
            }
        }
    }
}
