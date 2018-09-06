package de.ratzed.handcuffs.listener;

import de.ratzed.handcuffs.HandCuffs;
import de.ratzed.handcuffs.filemanager.ConfigManager;
import de.ratzed.handcuffs.handler.PlayerList;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

public class ItemClick implements Listener {

    private ItemStack helmet() {
        ItemStack item = new ItemStack(Material.RECORD_11);
        return item;
    }
    @EventHandler
    public void onClick(PlayerInteractEntityEvent event) {
        if(event.getRightClicked() instanceof Player) {
            Player p = event.getPlayer();
            Player clickedPlayer = (Player) event.getRightClicked();
            if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ConfigManager.cfg_file.getString("item.displayName"))) {
                if(!PlayerList.getPlayerList().contains(clickedPlayer)) {
                    Bukkit.getScheduler().scheduleSyncDelayedTask(HandCuffs.getInstance(), new Runnable() {
                        @Override
                        public void run() {
                            PlayerList.getPlayerList().add(clickedPlayer);
                            p.sendMessage(HandCuffs.getPrefix()+"§7Du hast §6 "+clickedPlayer.getName()+" §7gefesselt!");
                            clickedPlayer.sendMessage(HandCuffs.getPrefix()+"§7Du wurdest gefesselt!");
                            clickedPlayer.getInventory().setHelmet(helmet());
                        }
                    },10L);
                } else {
                    Bukkit.getScheduler().scheduleSyncDelayedTask(HandCuffs.getInstance(), new Runnable() {
                        @Override
                        public void run() {
                            PlayerList.getPlayerList().remove(clickedPlayer);
                            p.sendMessage(HandCuffs.getPrefix()+"§7Du hast §6 "+clickedPlayer.getName()+" §7frei gelassen!");
                            clickedPlayer.sendMessage(HandCuffs.getPrefix()+"§7Du wurdest freigelassen!");
                        }
                    },10L);
                }
            }
        }
    }
}
