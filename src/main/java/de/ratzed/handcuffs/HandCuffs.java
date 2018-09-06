package de.ratzed.handcuffs;

import de.ratzed.handcuffs.commands.CMD_handschellen;
import de.ratzed.handcuffs.filemanager.ConfigManager;
import de.ratzed.handcuffs.filemanager.LocationManager;
import de.ratzed.handcuffs.listener.ChatListener;
import de.ratzed.handcuffs.listener.ItemClick;
import de.ratzed.handcuffs.listener.JoinListener;
import de.ratzed.handcuffs.listener.MoveEvent;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class HandCuffs extends JavaPlugin {

    private LocationManager locationManager = new LocationManager();
    private ConfigManager configManager = new ConfigManager();
    private static String prefix = "§8[§cHandschellen§8] ";
    private static HandCuffs instance;

    public void onEnable() {
        instance = this;
        locationManager.createConfig();
        LocationManager.cfg_file = YamlConfiguration.loadConfiguration(LocationManager.config_file);
        ConfigManager.cfg_file = YamlConfiguration.loadConfiguration(ConfigManager.config_file);
        configManager.createConfig();
        Bukkit.getConsoleSender().sendMessage("§8--------------------------------------");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("        §eHandCuff Plugin enabled!");
        Bukkit.getConsoleSender().sendMessage("            §6Plugin by RatZed");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§8--------------------------------------");
        registerCommand();
        registerListener();
    }

    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§eHandCuff Plugin disabled!");
        instance = null;
    }

    public void registerListener() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new ChatListener(),this);
        pm.registerEvents(new ItemClick(),this);
        pm.registerEvents(new MoveEvent(),this);
        pm.registerEvents(new JoinListener(),this);
    }
    public void registerCommand() {
        this.getCommand("handschellen").setExecutor(new CMD_handschellen());
    }

    public static String getPrefix() {
        return prefix;
    }

    public static HandCuffs getInstance() {
        return instance;
    }


}
