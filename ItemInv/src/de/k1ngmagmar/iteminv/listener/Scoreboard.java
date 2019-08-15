package de.k1ngmagmar.iteminv.listener;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Team;

import de.k1ngmagmar.iteminv.main.Main;

public class Scoreboard implements Listener{

	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		
		FileConfiguration cfg = Main.getPlugin().getConfig();
		
		//überschrift
		String Rank = cfg.getString("Permission.topic");
		//Ränge
		String Spieler = cfg.getString("Permission.Player");
		String Premium = cfg.getString("Permission.Premium");
		String Premiump = cfg.getString("Permission.Premium+");
		String YouTuber = cfg.getString("Permission.YouTuber");
		String Builder = cfg.getString("Permission.Builder");
		String Supporter = cfg.getString("Permission.Supporter");
		String Developer = cfg.getString("Permission.Developer");
		String Moderator = cfg.getString("Permission.Moderator");
		String Admin = cfg.getString("Permission.Admin");
		String Owner = cfg.getString("Permission.Owner");
		
		//RangNamen
		String Spieler1 = cfg.getString("Permission.Player.name0");
		String Premium1 = cfg.getString("Permission.Premium.name1");
		String Premiump1 = cfg.getString("Permission.Premium+.name2");
		String YouTuber1 = cfg.getString("Permission.YouTuber.name3");
		String Builder1 = cfg.getString("Permission.Builder.name4");
		String Supporter1 = cfg.getString("Permission.Supporter.name5");
		String Developer1 = cfg.getString("Permission.Developer.name6");
		String Moderator1 = cfg.getString("Permission.Moderator.name7");
		String Admin1 = cfg.getString("Permission.Admin.name8");
		String Owner1 = cfg.getString("Permission.Owner.name9");
		
		
		Player p = e.getPlayer();
		
		
		String name = cfg.getString("scoreboard.name");
		String ts = cfg.getString("scoreboard.ts");
		String players = cfg.getString("scoreboard.online").replace("%online%", Bukkit.getOnlinePlayers().size()+"").replace("%max%", Bukkit.getServer().getMaxPlayers()+"");
		
		org.bukkit.scoreboard.Scoreboard board =  (org.bukkit.scoreboard.Scoreboard) Bukkit.getScoreboardManager().getNewScoreboard();
		Objective obj = ((org.bukkit.scoreboard.Scoreboard) board).registerNewObjective("aaa", "bbb");
		
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		obj.setDisplayName(name);
		
		if(p.hasPermission(Spieler)) {
			obj.getScore(Spieler1).setScore(6); //Illegal Argument? Evtl. Spieler1 = null
			obj.getScore(" ").setScore(6);
		}else 	if(p.hasPermission(Premium)) {
			obj.getScore(Premium1).setScore(6);
			obj.getScore(" ").setScore(6);
		}else 	if(p.hasPermission(Premiump)) {
			obj.getScore(Premiump1).setScore(6);
			obj.getScore(" ").setScore(6);
		}else 	if(p.hasPermission(YouTuber)) {
			obj.getScore(YouTuber1).setScore(6);
			obj.getScore(" ").setScore(6);
		}else 	if(p.hasPermission(Builder)) {
			obj.getScore(Builder1).setScore(6);
			obj.getScore(" ").setScore(6);
		}else 	if(p.hasPermission(Supporter)) {
			obj.getScore(Supporter1).setScore(6);
			obj.getScore(" ").setScore(6);
		}else 	if(p.hasPermission(Developer)) {
			obj.getScore(Developer1).setScore(6);
			obj.getScore(" ").setScore(6);
		}else 	if(p.hasPermission(Moderator)) {
			obj.getScore(Moderator1).setScore(6);
			obj.getScore(" ").setScore(6);
		}else 	if(p.hasPermission(Admin)) {
			obj.getScore(Admin1).setScore(6);
			obj.getScore(" ").setScore(6);
		}else 	if(p.hasPermission(Owner)) {
			obj.getScore(Owner1).setScore(6);
			obj.getScore(" ").setScore(6);
		}
		
		
		obj.getScore(Rank).setScore(7);
		obj.getScore(" ").setScore(6);
		obj.getScore("§6Teamspeak :").setScore(5);
		obj.getScore(ts).setScore(4);
		obj.getScore(" ").setScore(3);
		obj.getScore("§6Online Spieler :" ).setScore(2); 
		
		
		Team po = board.registerNewTeam("playersonline");
		po.setPrefix("");
		po.setSuffix(players);
		po.addEntry("");
		
		obj.getScore("").setScore(1);
		p.setScoreboard((org.bukkit.scoreboard.Scoreboard) board);
		
		for(Player player : Bukkit.getOnlinePlayers()) {
			player.getScoreboard().getTeam("playersonline").setSuffix(players);
		}
		 
	}
}
