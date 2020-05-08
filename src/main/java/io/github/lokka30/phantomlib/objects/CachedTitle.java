package io.github.lokka30.phantomlib.objects;

import org.bukkit.entity.Player;

import java.util.List;

@SuppressWarnings("unused")
public class CachedTitle {

    private String mainTitle;
    private String subTitle;
    private int fadeIn;
    private int stay;
    private int fadeOut;

    /**
     * Store a complete Title (main title, sub title, fade in, stay, fade out) in a single object
     *
     * @param mainTitle the uppermost text
     * @param subTitle  the bottom text
     * @param fadeIn    the amount in ticks to fade in the title
     * @param stay      the amount in ticks to keep the title displayed
     * @param fadeOut   the amount in ticks to fade out the title
     */
    public CachedTitle(String mainTitle, String subTitle, int fadeIn, int stay, int fadeOut) {
        this.mainTitle = mainTitle;
        this.subTitle = subTitle;
        this.fadeIn = fadeIn;
        this.stay = stay;
        this.fadeOut = fadeOut;
    }

    public String getMainTitle() {
        return mainTitle;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public int getFadeIn() {
        return fadeIn;
    }

    public int getStay() {
        return stay;
    }

    public int getFadeOut() {
        return fadeOut;
    }

    /**
     * Send the title to a single player.
     *
     * @param player the player to send the title to
     */
    public void sendToPlayer(Player player) {
        player.sendTitle(mainTitle, subTitle, fadeIn, stay, fadeOut);
    }

    /**
     * Send the title to an array of players.
     *
     * @param players the array of players to send the title to
     */
    public void sendToPlayers(Player[] players) {
        for (Player player : players) {
            sendToPlayer(player);
        }
    }

    /**
     * Send the title to a list of players.
     *
     * @param players the list of players to send the title to
     */
    public void sendToPlayers(List<Player> players) {
        for (Player player : players) {
            sendToPlayer(player);
        }
    }
}