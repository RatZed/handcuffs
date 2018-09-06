package de.ratzed.handcuffs.filemanager;

import de.ratzed.handcuffs.HandCuffs;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConfigManager {

    public static FileConfiguration cfg_file;
    public static File config_file = new File("plugins/HandCuffs/","config.yml");



    public void createConfig() {
        try {
            if (!config_file.exists()) {
                cfg_file.addDefault("prefix","§8[§cHandschellen§8] §7");
                cfg_file.addDefault("item.material","RECORD_11");
                cfg_file.addDefault("item.subID","0");
                cfg_file.addDefault("item.displayName","§cHandschellen");
                cfg_file.options().copyDefaults(true);
                List<String> configList = new ArrayList<>();
                configList.add(" ");
                configList.add("[Rechtsklick] um einen Spieler zu fesseln");
                cfg_file.set("item.lore",configList);
                save();
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void save() {
        try {
            cfg_file.save(config_file);
        } catch (Exception ex) {
            Bukkit.getServer().getLogger().severe(ChatColor.RED+"Could not save location.yml!");
        }
    }

}

