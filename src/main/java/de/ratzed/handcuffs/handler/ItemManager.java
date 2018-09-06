package de.ratzed.handcuffs.handler;

import de.ratzed.handcuffs.filemanager.ConfigManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ItemManager {


    public ItemStack HandCuffs() {
        ItemStack item = new ItemStack(Material.valueOf(ConfigManager.cfg_file.getString("item.material").toUpperCase()));
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ConfigManager.cfg_file.getString("item.displayName").replaceAll("&","§"));
        List<String> lore;
        lore = (List<String>) ConfigManager.cfg_file.getList("item.lore");

        for(int i =0; i < lore.size(); i++) {
            lore.set(i,ChatColor.translateAlternateColorCodes('&', lore.get(i)));
        }

        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
}
