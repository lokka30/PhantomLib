package io.github.lokka30.phantomlib.classes;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static net.md_5.bungee.api.ChatColor.COLOR_CHAR;

@SuppressWarnings("unused")
public class MessageMethods {

    public MessageMethods() {
    }

    /**
     * This method will translate color codes (e.g. &a) in the specified message. It will also translate hex color codes (e.g. &#123456).
     *
     * @param message the message which should have colour codes translated
     * @return the translated string
     */
    public String colorize(final String message) {
        return ChatColor.translateAlternateColorCodes('&', translateHexColorCodes("&#", "", message));
    }

    /**
     * This method will translate HEX colour codes (e.g. 123456) in the specified message.
     * Full credit to Sullivan_Bognar and imDaniX on SpigotMC for creating this method.
     *
     * @param startTag what the tag should begin with - '&#' is recommended
     * @param endTag   what the tag should end with - '' (nothing) is recommended
     * @param message  the message that should be translated
     * @return the translated string
     */
    public String translateHexColorCodes(String startTag, String endTag, String message) {
        final Pattern hexPattern = Pattern.compile(startTag + "([A-Fa-f0-9]{6})" + endTag);
        Matcher matcher = hexPattern.matcher(message);
        StringBuffer buffer = new StringBuffer(message.length() + 4 * 8);
        while (matcher.find()) {
            String group = matcher.group(1);
            matcher.appendReplacement(buffer, COLOR_CHAR + "x"
                    + COLOR_CHAR + group.charAt(0) + COLOR_CHAR + group.charAt(1)
                    + COLOR_CHAR + group.charAt(2) + COLOR_CHAR + group.charAt(3)
                    + COLOR_CHAR + group.charAt(4) + COLOR_CHAR + group.charAt(5)
            );
        }
        return matcher.appendTail(buffer).toString();
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
