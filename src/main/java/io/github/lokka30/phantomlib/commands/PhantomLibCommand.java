package io.github.lokka30.phantomlib.commands;

import io.github.lokka30.phantomlib.PhantomLib;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class PhantomLibCommand implements TabExecutor {

    private PhantomLib instance;

    public PhantomLibCommand(PhantomLib instance) {
        this.instance = instance;
    }

    @Override
    public boolean onCommand(@NotNull final CommandSender sender, @NotNull final Command cmd, @NotNull final String label, @NotNull final String[] args) {
        if (args.length == 0) {
            sender.sendMessage(" ");
            sender.sendMessage(instance.getMessageMethods().colorize("&7Server is running &bPhantomLib v" + instance.getDescription().getVersion() + "&7."));
            sender.sendMessage(instance.getMessageMethods().colorize("&7Developed by &blokka30&7. Resource available on &bSpigotMC.org&7."));
            sender.sendMessage(" ");
            sender.sendMessage(instance.getMessageMethods().prefix("&b&lPhantomLib: &7", "Available commands:"));
            sender.sendMessage(instance.getMessageMethods().prefix("&8 &m->&7 ", "&b/phantomlib reload &8| &7Reload the configuration."));
            sender.sendMessage(" ");
        } else if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
            if (sender.hasPermission("phantomlib.reload")) {
                sender.sendMessage(instance.getMessageMethods().prefix("&b&lPhantomLib: &7", "Reload started ..."));
                instance.reloadConfig();
                sender.sendMessage(instance.getMessageMethods().prefix("&b&lPhantomLib: &7", "... Reload complete."));
            } else {
                sender.sendMessage(instance.getMessageMethods().prefix("&b&lPhantomLib: &7", "You don't have access to that."));
            }
        } else {
            sender.sendMessage(instance.getMessageMethods().prefix("&b&lPhantomLib: &7", "Usage: &b/phantomlib [reload]"));
        }
        return true;
    }

    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull final CommandSender commandSender, @NotNull final Command command, @NotNull final String label, @NotNull final String[] args) {
        List<String> suggestions = new ArrayList<>();
        if (args.length == 0) {
            suggestions.add("reload");
        }
        return null;
    }
}
