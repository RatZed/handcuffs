package de.ratzed.handcuffs.listener;

import de.ratzed.handcuffs.handler.ItemManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    private ItemManager itemManager = new ItemManager();

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        if(p.hasPermission("handcuffs.item")) {
            p.getInventory().setItem(1, itemManager.HandCuffs());
        }
    }
}
