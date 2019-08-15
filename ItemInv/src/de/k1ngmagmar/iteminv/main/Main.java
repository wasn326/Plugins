package de.k1ngmagmar.iteminv.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.k1ngmagmar.iteminv.command.HelpCommand;
import de.k1ngmagmar.iteminv.listener.Listener;
import de.k1ngmagmar.iteminv.listener.Scoreboard;

public class Main extends JavaPlugin{
	
	
	
	private static Main plugin; //exportieren?? jetzt
	
	public void onEnable() {
		plugin = this;
		
		/*
		 * Config
		 */
		getConfig().options().copyDefaults(true);
		getConfig().options().header("Lobby System by K1ngMagmar aka Fade");
		getConfig().options().copyHeader(true);
		saveConfig();
		
		
		/*
		 * Events
		 */
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new Listener(), this);
		pm.registerEvents(new Scoreboard(), this);
		
		/*
		 * Commands
		 */
		
		getCommand("help").setExecutor(new HelpCommand());
		
		
		Bukkit.getConsoleSender().sendMessage("§3LobbySystem made by K1ngMagmar");
		
	}
	
	public static Main getPlugin() {
		return plugin;
	}

}
