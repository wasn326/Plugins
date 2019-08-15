package de.k1ngmagmar.iteminv.listener;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.k1ngmagmar.iteminv.main.Main;
import de.k1ngmagmar.iteminv.utils.Inventories;


public class Listener implements org.bukkit.event.Listener{

	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		
		FileConfiguration cfg = Main.getPlugin().getConfig();
		
		String compass =  cfg.getString("Utils.compass");
		String hidestick =  cfg.getString("Utils.hidestick");
		String SpielerA = cfg.getString("Utils.showplayers");
		String SpielerH = cfg.getString("Utils.Hideplayers");
		String SpielerT = cfg.getString("Utils.showteammember");
		
		Player p = e.getPlayer();
		
		
		p.setCanPickupItems(false);
		
		if(p.getInventory().equals(hidestick)) {
			
		}else {
			ItemStack item = new ItemStack(Material.BLAZE_ROD);
			ItemMeta itemm = item.getItemMeta();
			itemm.setDisplayName(hidestick);
			item.setItemMeta(itemm);
			p.getInventory().setItem(4, (ItemStack) item);
			
		}
		
		if(p.getInventory().equals(hub)) {
			
		}else {
			ItemStack item = new ItemStack(Material.NETHER_STAR);
			ItemMeta itemm = item.getItemMeta();
			itemm.setDisplayName(hub);
			item.setItemMeta(itemm);
			p.getInventory().setItem(8, (ItemStack) item);
			
		}
		
		
		if(p.getInventory().equals(compass)) {

		}else {
			ItemStack item = new ItemStack(Material.COMPASS);
			ItemMeta itemm = item.getItemMeta();
			itemm.setDisplayName(compass);
			item.setItemMeta(itemm);
			p.getInventory().setItem(0, (ItemStack) item);
		}
		
		
	}
	
	FileConfiguration cfg = Main.getPlugin().getConfig();
	String compass =  cfg.getString("Utils.compass");
	String hub =  cfg.getString("Utils.hubselector");
	String hidestick =  cfg.getString("Utils.hidestick");
	String SpielerA = cfg.getString("Utils.showplayers");
	String SpielerH = cfg.getString("Utils.Hideplayers");
	String SpielerT = cfg.getString("Utils.showteammember");
	
	@EventHandler
	
	
	
	public void ballFiring(PlayerInteractEvent e) {
	    Player p = e.getPlayer();
	    Action a = e.getAction();
	    
	    DyeColor color = DyeColor.GREEN;
	    DyeColor color2 = DyeColor.PURPLE;
	    DyeColor color3 = DyeColor.RED;
	    		byte data = (byte) (15 - color.getData());
	    		byte data2 = (byte) (15 - color2.getData());
	    		byte data3 = (byte) (15 - color3.getData());

	    		ItemStack itm = new ItemStack(Material.INK_SACK, 1, data);
	    		ItemStack itm2 = new ItemStack(Material.INK_SACK, 1, data2);
	    		ItemStack itm3 = new ItemStack(Material.INK_SACK, 1, data3);
	    		
	    		ItemMeta itemm = itm.getItemMeta();
	    		itemm.setDisplayName(SpielerA);
	    		itm.setItemMeta(itemm);
	    		ItemMeta itemm2 = itm2.getItemMeta();
	    		itemm2.setDisplayName(SpielerT);
	    		itm2.setItemMeta(itemm2);
	    		ItemMeta itemm3 = itm3.getItemMeta();
	    		itemm3.setDisplayName(SpielerH);
	    		itm3.setItemMeta(itemm3);
	    		
	    		
	    //Blaze Rod
	    		
	    		if(a == null)return;
	    		if(e.getItem() == null)return;
	    		
	     if ((a == Action.RIGHT_CLICK_BLOCK) && (e.getItem().getType() == Material.BLAZE_ROD) || (a == Action.RIGHT_CLICK_AIR) && (e.getItem().getType() == Material.BLAZE_ROD)){ // da ist der Fehler
	     if(p.getItemInHand().getItemMeta().getDisplayName().equals(hidestick)) {
	    	
		    	Inventory inv = Bukkit.createInventory(null, 9 * 1, hidestick);
		    	inv.setItem(0, itm);
		    	inv.setItem(4,itm2);
		    	inv.setItem(8, itm3);
		    	e.setCancelled(true);
		    	p.openInventory(inv);
		    	
		    	
	    	}else {
	    		return;
	    	}
	    	
	    	
	    	return;
	    }
	    
	    
	    //Compass
	    
	    if ((a == Action.RIGHT_CLICK_AIR) && (e.getItem().getType() == Material.COMPASS) || (a == Action.RIGHT_CLICK_BLOCK) && (e.getItem().getType() == Material.COMPASS)) {
	    	if(p.getItemInHand().getItemMeta().getDisplayName().equals(compass)) {
		    	Inventory inv = Bukkit.createInventory(null, 9 * 6, compass);
	    		ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE);
	    		ItemMeta meta = item.getItemMeta();
	    		meta.setDisplayName(" ");
		    	item.setItemMeta(meta);
		    	
		    	inv.setItem(1, item);
		    	inv.setItem(9, item);
		    	inv.setItem(0, item);
		    	p.openInventory(inv);
	    	}else {
	    		return;
	    	}
	    	
	    	return;
	    }
	    
	    //Hubselector
	    if ((a == Action.RIGHT_CLICK_AIR) && (e.getItem().getType() == Material.NETHER_STAR) || (a == Action.RIGHT_CLICK_BLOCK) && (e.getItem().getType() == Material.NETHER_STAR)) {
	    	if(p.getItemInHand().getItemMeta().getDisplayName().equals(hub)) {
		    	Inventories.setlobbychanger(p);
	    	}else {
	    		return;
	    	}
	    	
	    	return;
	    }
	    
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		if (!(e.getWhoClicked() instanceof Player)) {
            return;
        }
        Player player = (Player) e.getWhoClicked();
        if (e.getClickedInventory() == null) {
            return;
        }
        if (player.getOpenInventory().getTopInventory() == null) {
            return;
        }
        if (e.getClickedInventory() == null) {
            return;
        }
        if (e.getCurrentItem() == null) {
            return;
        }
        if (e.getCurrentItem().getItemMeta() == null) {
            return;
        }
		
		if(e.getInventory().getName().equals(compass) || e.getInventory().getName().equals(hidestick)) {
			
			e.setCancelled(true);
		}else {
			e.setCancelled(false);
			
		}
		
	}
	
	
	
}
