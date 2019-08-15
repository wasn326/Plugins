package de.k1ngmagmar.iteminv.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import de.k1ngmagmar.iteminv.main.Main;

public class HelpCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			FileConfiguration cfg = Main.getPlugin().getConfig();
			String help1 = cfg.getString("Help.1");
			String help2 = cfg.getString("Help.2");
			String help3 = cfg.getString("Help.3");
			String help4 = cfg.getString("Help.4");
			String help5 = cfg.getString("Help.5");
			String help6 = cfg.getString("Help.6");
			String help7 = cfg.getString("Help.7");
			String help8 = cfg.getString("Help.8");
			
			p.sendMessage(help1);
			p.sendMessage(help2);
			p.sendMessage(help3);
			p.sendMessage(help4);
			p.sendMessage(help5);
			p.sendMessage(help6);
			p.sendMessage(help7);
			p.sendMessage(help8);
			
		}
		return false;
	}

}
