package io.github.lokka30.phantomlib.classes;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

@SuppressWarnings("unused")
public class MessageMethods {

    public MessageMethods() {
    }

    /**
     * This method will translate colour codes (e.g. &a) in the specified message.
     *
     * @param msg the message which should have colour codes translated
     * @return the translated string
     */
    public String colorize(final String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    /**
     * This method will join a prefix and message together and return a chat color translated string.
     *
     * @param prefix the prefix string
     * @param msg    the message string
     * @return the colorized string of the prefix and msg joined together
     */
    public String prefix(final String prefix, final String msg) {
        return colorize(prefix + msg);
    }

    /**
     * Send an action bar message to the player
     *
     * @param player the player to send the action bar message to
     * @param msg    the message to send in the action bar
     */
    public void sendActionBarMessage(final Player player, final String msg) {
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(colorize(msg)));
    }

    /**
     * Send an action bar message to the player
     *
     * @param player the player to send the action bar message to
     * @param prefix the String which should prefix the msg
     * @param msg    the String which should suffix the prefix
     */
    public void sendActionBarMessage(final Player player, final String prefix, final String msg) {
        sendActionBarMessage(player, prefix + msg);
    }
}
