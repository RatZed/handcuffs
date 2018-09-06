package de.ratzed.handcuffs.commands;

import de.ratzed.handcuffs.HandCuffs;
import de.ratzed.handcuffs.filemanager.ConfigManager;
import de.ratzed.handcuffs.filemanager.LocationManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_handschellen implements CommandExecutor {
    private LocationManager locationManager = new LocationManager();
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("handschellen")) {
            if(sender instanceof Player) {
                Player p = (Player)sender;
                if(p.hasPermission("handschellen.admin")) {
                    if(args.length == 1) {
                        if(args[0].equalsIgnoreCase("spawn")) {
                            Location loc = p.getLocation();


                            locationManager.cfg_file.set("spawn.x", loc.getX());
                            locationManager.cfg_file.set("spawn.y", loc.getY());
                            locationManager.cfg_file.set("spawn.z", loc.getZ());
                            locationManager.cfg_file.set("spawn.yaw", loc.getYaw());
                            locationManager.cfg_file.set("spawn.pitch", loc.getPitch());
                            locationManager.cfg_file.set("spawn.world",loc.getWorld().getName());
                            locationManager.save();

                            p.sendMessage(HandCuffs.getPrefix()+"§7Du hast die Spawn Location gesetzt");
                        } if(args[0].equalsIgnoreCase("reload")) {
                            p.sendMessage(HandCuffs.getPrefix()+"§aReloaded Config successfully!");
                        }
                    } else {
                        p.sendMessage(HandCuffs.getPrefix()+"§cHier fehlt etwas");
                    }
                } else {
                    p.sendMessage(HandCuffs.getPrefix()+"§cDu hast nicht genug Rechte");
                }
            } else {
                Bukkit.getConsoleSender().sendMessage(HandCuffs.getPrefix()+"§7Command just for Players");
            }
        }
        return false;
    }
}
