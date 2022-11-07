package me.amar.mctts.MinecraftCommands;

import me.amar.mctts.Listener.AcronymListener;
import me.amar.mctts.MCTTS;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class AddAcronym implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player) {
            Player  p = (Player) sender;
            if(p.hasPermission("addAcronym")) {
                if (AcronymListener.isAcronymInList(args[0])) {
                    p.sendMessage(MCTTS.colorize("&cThis Acroym already exists"));
                } else {
                    AcronymListener.addAcronymToList(args[0], args[1]);
                    p.sendMessage(MCTTS.colorize("&cAdded Acronym: &f" + args[0] + " &cas: &f" + args[1]));
               }
            }
        }





        return true;
    }
}
