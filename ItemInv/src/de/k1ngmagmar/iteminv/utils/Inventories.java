package de.k1ngmagmar.iteminv.utils;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Inventories {

	public static void setlobbychanger(Player p) {
		
		ArrayList<String> lobbyies = new ArrayList<String>(); //Nur als test wofür sind ArrayListen da?? zB. Werte speichern ohne eine Datei
		lobbyies.add("Lobby-1");
		lobbyies.add("Lobby-2");
		lobbyies.add("Lobby-3");
		
		Inventory changer = Bukkit.createInventory(null, 27, "§6Lobbyswitcher");
		
		fillInventory(changer, getPlaceholderItem());
		
		for(int i = 0; i < lobbyies.size();i++) {
			changer.setItem(i+10, new ItemManager(Material.GOLD_BLOCK).setDisplayName(lobbyies.get(i)).build());
		}
		
		p.openInventory(changer);
	}
	
	public static ItemStack getPlaceholderItem() {
        ItemStack stack = new ItemStack(new ItemManager(Material.STAINED_GLASS_PANE, (short) 7).setNoName().build());
        return stack;
    }

    public static void fillInventory(Inventory inv, ItemStack stack) {
        for (int i = 0; i < inv.getSize(); i++) {
            inv.setItem(i, stack);
        }
    }
	
}
