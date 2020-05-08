package io.github.lokka30.phantomlib.classes;

import org.bukkit.ChatColor;

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
}
