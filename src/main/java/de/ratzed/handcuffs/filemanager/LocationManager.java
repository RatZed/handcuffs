package de.ratzed.handcuffs.filemanager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class LocationManager {

    public static FileConfiguration cfg_file;
    public static File config_file = new File("plugins/HandCuffs/","location.yml");

    public void createConfig() {
        try {
            if (!config_file.exists()) {
                File dir = config_file.getParentFile();
                dir.mkdirs();
                cfg_file = YamlConfiguration.loadConfiguration(config_file);
                config_file.createNewFile();
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
