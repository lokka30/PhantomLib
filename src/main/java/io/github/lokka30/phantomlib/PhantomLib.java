package io.github.lokka30.phantomlib;

import io.github.lokka30.phantomlib.classes.CommandRegister;
import io.github.lokka30.phantomlib.classes.MessageMethods;
import io.github.lokka30.phantomlib.classes.PhantomLogger;
import io.github.lokka30.phantomlib.classes.UpdateChecker;
import io.github.lokka30.phantomlib.commands.PhantomLibCommand;
import io.github.lokka30.phantomlib.enums.LogLevel;
import io.github.lokka30.phantomlib.listeners.PlayerMoveListener;
import org.bstats.bukkit.Metrics;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class PhantomLib extends JavaPlugin {

    private CommandRegister commandRegister;
    private MessageMethods messageMethods;
    private PhantomLogger phantomLogger;

    @Override
    public void onLoad() {
        this.commandRegister = new CommandRegister();
        this.messageMethods = new MessageMethods();
        this.phantomLogger = new PhantomLogger();
    }

    @Override
    public void onEnable() {
        phantomLogger.log(LogLevel.INFO, "&b&lPhantomLib: &8(&3Startup&8) &7", "&8+---+ &f(Enable Started) &8+---+");
        final long timeStart = System.currentTimeMillis();

        phantomLogger.log(LogLevel.INFO, "&b&lPhantomLib: &8(&3Startup &8- &31&8/&34&8) &7", "Loading '&bconfig.yml&7'...");
        saveDefaultConfig();

        phantomLogger.log(LogLevel.INFO, "&b&lPhantomLib: &8(&3Startup &8- &32&8/&34&8) &7", "Registering events...");
        registerEvents();

        phantomLogger.log(LogLevel.INFO, "&b&lPhantomLib: &8(&3Startup &8- &33&8/&34&8) &7", "Registering commands...");
        registerCommands();

        phantomLogger.log(LogLevel.INFO, "&b&lPhantomLib: &8(&3Startup &8- &34&8/&34&8) &7", "Registering metrics...");
        new Metrics(this, 12345);

        final long timeTaken = System.currentTimeMillis() - timeStart;
        phantomLogger.log(LogLevel.INFO, "&b&lPhantomLib: &8(&3Startup&8) &7", "&8+---+ &f(Enable Complete, took &b" + timeTaken + "ms&f) &8+---+");

        checkForUpdates();
    }

    private void registerEvents() {
        final PluginManager pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new PlayerMoveListener(this), this);
    }

    private void registerCommands() {
        if (!getCommandRegister().registerCommand(this, "phantomlib", new PhantomLibCommand(this))) {
            phantomLogger.log(LogLevel.SEVERE, "&b&lPhantomLib: &7", "Unable to register command '&b/phantomlib&7'.");
        }
    }

    private void checkForUpdates() {
        if (getConfig().contains("use-update-checker")) {
            if (getConfig().getBoolean("use-update-checker")) {
                phantomLogger.log(LogLevel.INFO, "&b&lPhantomLib: &8(&3Update Checker&8) &7", "Checking for updates...");
                //TODO CHANGE RESOURCE ID
                new UpdateChecker(this, 12345).getVersion(version -> {
                    final String currentVersion = getDescription().getVersion();

                    if (currentVersion.equals(version)) {
                        phantomLogger.log(LogLevel.INFO, "&b&lPhantomLib: &8(&3Update Checker&8) &7", "You're running the latest version '&b" + currentVersion + "&7'.");
                    } else {
                        phantomLogger.log(LogLevel.WARNING, "&b&lPhantomLib: &8(&3Update Checker&8) &7", "There's a new update available: '&b" + version + "&7'. You're running '&b" + currentVersion + "&7'.");
                    }
                });
            }
        } else {
            phantomLogger.log(LogLevel.WARNING, "&b&lPhantomLib: &8(&3Update Checker&8) &7", "Unable to access '&buse-update-checker&7' value in '&bconfig.yml&7', please repair the file.");
        }
    }

    @Override
    public void onDisable() {
        phantomLogger.log(LogLevel.INFO, "&b&lPhantomLib: &8(&3Shutdown&8) &7", "&8+---+ &f(Disable Started) &8+---+");
        final long startTime = System.currentTimeMillis();

        phantomLogger.log(LogLevel.INFO, "&b&lPhantomLib: &8(&3Shutdown &8- &31&8/&31&8) &7", "Unregistering listeners..");
        HandlerList.unregisterAll(this);

        final long totalTime = System.currentTimeMillis() - startTime;
        phantomLogger.log(LogLevel.INFO, "&b&lPhantomLib: &8(&3Shutdown&8) &7", "&8+---+ &f(Disable Complete, took &b" + totalTime + "ms&f) &8+---+");
    }

    public CommandRegister getCommandRegister() {
        return commandRegister;
    }

    public MessageMethods getMessageMethods() {
        return messageMethods;
    }

    @SuppressWarnings("unused")
    public PhantomLogger getPhantomLogger() {
        return phantomLogger;
    }
}
