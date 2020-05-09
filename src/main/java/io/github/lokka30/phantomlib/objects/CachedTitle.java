package io.github.lokka30.phantomlib.objects;

import org.bukkit.entity.Player;

import java.util.List;

@SuppressWarnings("unused")
public class CachedTitle {

    private String mainTitle;
    private String subTitle;
    private int fadeIn = 5;
    private int stay = 40;
    private int fadeOut = 5;

    /**
     * Store a complete Title (main title, sub title, fade in, stay, fade out) in a single object
     *
     * @param mainTitle the top text
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

    /**
     * Store part of a Title (main title and sub title, not fade in, stay or fade out) in a single object
     * @param mainTitle the top text
     * @param subTitle the bottom text
     */
    public CachedTitle(String mainTitle, String subTitle) {
        this.mainTitle = mainTitle;
        this.subTitle = subTitle;
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
     * 1.11+ ONLY!
     *
     * @param player the player to send the title to
     */
    public void sendToPlayer(Player player) {
        player.sendTitle(mainTitle, subTitle, fadeIn, stay, fadeOut);
    }

    /**
     * Send the title to an array of players.
     * 1.11+ ONLY!
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
     * 1.11+ ONLY!
     *
     * @param players the list of players to send the title to
     */
    public void sendToPlayers(List<Player> players) {
        for (Player player : players) {
            sendToPlayer(player);
        }
    }

    /**
     * Send the title to a player.
     * 1.8+ ONLY!
     * This method *may* be removed in the future as it is has been considered deprecated for multiple versions now.
     * If you are running server version 1.11 or newer, please use the other methods instead.
     * @param player the player to send the title to
     */
    @Deprecated
    public void sendToPlayerOld(Player player) {
        player.sendTitle(mainTitle, subTitle);
    }
}