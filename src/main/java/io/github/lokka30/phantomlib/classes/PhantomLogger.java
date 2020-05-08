package io.github.lokka30.phantomlib.classes;

import io.github.lokka30.phantomlib.enums.LogLevel;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.logging.Logger;

@SuppressWarnings("unused")
public class PhantomLogger {

    public PhantomLogger() {
    }

    /**
     * This method will log a message to the console.
     *
     * @param logLevel the LogLevel enum determining the severity of the logged message
     * @param msg      the message which should be sent in the log
     */
    public void log(final LogLevel logLevel, String msg) {
        msg = ChatColor.translateAlternateColorCodes('&', msg);
        Logger logger = Bukkit.getLogger();
        switch (logLevel) {
            case INFO:
                logger.info(msg);
                break;
            case WARNING:
                logger.warning(msg);
                break;
            case SEVERE:
                logger.severe(msg);
                break;
            default:
                throw new IllegalStateException("Undefined LogLevel: " + logLevel.toString());
        }
    }

    /**
     * This method will log a message to the console
     *
     * @param logLevel
     * @param prefix
     * @param msg
     */
    public void log(final LogLevel logLevel, final String prefix, final String msg) {
        log(logLevel, prefix + msg);
    }
}
