package io.github.lokka30.phantomlib.events;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@SuppressWarnings("unused")
public class PlayerMoveXYZEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();
    private Player player;
    private Location from;
    private Location to;
    private boolean isCancelled;

    public PlayerMoveXYZEvent(Player player, Location from, Location to) {
        this.player = player;
        this.from = from;
        this.to = to;
        this.isCancelled = false;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean state) {
        isCancelled = true;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Location getFrom() {
        return from;
    }

    public void setFrom(Location from) {
        this.from = from;
    }

    public Location getTo() {
        return to;
    }

    public void setTo(Location to) {
        this.to = to;
    }
}
