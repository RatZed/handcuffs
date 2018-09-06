package de.ratzed.handcuffs.listener;

import de.ratzed.handcuffs.filemanager.LocationManager;
import de.ratzed.handcuffs.handler.PlayerList;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class ChatListener implements Listener {

    private LocationManager locationManager = new LocationManager();


    Double x = locationManager.cfg_file.getDouble("spawn.x");
    Double y = locationManager.cfg_file.getDouble("spawn.y");
    Double z = locationManager.cfg_file.getDouble("spawn.z");
    Float yaw = (float) locationManager.cfg_file.getDouble("spawn.yaw");
    Float pitch = (float) locationManager.cfg_file.getDouble("spawn.pitch");
    String world = locationManager.cfg_file.getString("spawn.world");

    @EventHandler
    public void onChat(PlayerCommandPreprocessEvent event) {
        Bukkit.getConsoleSender().sendMessage("Test");
        Player p = event.getPlayer();
        if(PlayerList.getPlayerList().contains(p)) {
                event.setCancelled(true);
                Location loc = new Location(Bukkit.getWorld(world),x,y,z,yaw,pitch);
                p.teleport(loc);
            }
        }
    }
