package io.github.lokka30.phantomlib.objects;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.List;

@SuppressWarnings("unused")
public class CachedSound {

    private Sound sound;
    private float volume;
    private float pitch;

    /**
     * Store a complete object that contains a Sound, volume and pitch
     *
     * @param sound  the Sound object
     * @param volume the volume, from 0.0 to 1.0
     * @param pitch  the pitch, from 0.0 to 2.0
     */
    public CachedSound(Sound sound, float volume, float pitch) {
        this.sound = sound;
        this.volume = volume;
        this.pitch = pitch;
    }

    public Sound getSound() {
        return sound;
    }

    public float getVolume() {
        return volume;
    }

    public float getPitch() {
        return pitch;
    }

    /**
     * Plays the CachedSound to a single player
     *
     * @param player the player to play the sound to
     */
    public void playToPlayer(Player player) {
        player.playSound(player.getLocation(), getSound(), getVolume(), getPitch());
    }

    /**
     * Plays the CachedSound to multiple players
     *
     * @param players the array of players to play the sound to
     */
    public void playToPlayers(Player[] players) {
        for (Player player : players) {
            playToPlayer(player);
        }
    }

    /**
     * Plays the CachedSound to multiple players
     *
     * @param players the list of players to play the sound to
     */
    public void playToPlayers(List<Player> players) {
        for (Player player : players) {
            playToPlayer(player);
        }
    }
}