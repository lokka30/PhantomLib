package io.github.lokka30.phantomlib.listeners;

import io.github.lokka30.phantomlib.PhantomLib;
import io.github.lokka30.phantomlib.events.PlayerMoveXYZEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener implements Listener {

    private PhantomLib instance;

    public PlayerMoveListener(final PhantomLib instance) {
        this.instance = instance;
    }

    @EventHandler
    public void onMove(final PlayerMoveEvent event) {
        final Location locationFrom = event.getFrom();
        final Location locationTo = event.getTo();

        // Make sure that the player moved a XYZ coordinate and not just their head.
        if (locationFrom.getX() != locationTo.getX() || locationFrom.getY() != locationTo.getY() || locationFrom.getZ() != locationTo.getZ()) {
            PlayerMoveXYZEvent playerMoveXYZEvent = new PlayerMoveXYZEvent(event.getPlayer(), locationFrom, locationTo);
            Bukkit.getPluginManager().callEvent(playerMoveXYZEvent);
            if (playerMoveXYZEvent.isCancelled()) {
                event.setCancelled(true);
            }
        }
    }
}
