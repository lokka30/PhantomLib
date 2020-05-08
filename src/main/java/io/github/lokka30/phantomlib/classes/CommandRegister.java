package io.github.lokka30.phantomlib.classes;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("unused")
public class CommandRegister {

    public CommandRegister() {
    }

    /**
     * Note: Access using PhantomLib.getCommandRegister();
     */

    /**
     * Registers a command, first ensuring that it exists before setting its executor
     *
     * @param plugin          the JavaPlugin class that will register the command
     * @param label           the name of the command (without the starting slash)
     * @param commandExecutor the command executor class which will handle the command
     * @return boolean - if the command executor was successfuly registered
     */
    public boolean registerCommand(final JavaPlugin plugin, final String label, final CommandExecutor commandExecutor) {
        PluginCommand command = plugin.getCommand(label);

        if (command == null) {
            // The command probably doesn't exist in the plugin.yml file.
            return false;
        } else {
            command.setExecutor(commandExecutor);
            return true;
        }
    }
}
