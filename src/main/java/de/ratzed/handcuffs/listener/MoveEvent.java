package de.ratzed.handcuffs.listener;

import de.ratzed.handcuffs.handler.PlayerList;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveEvent implements Listener {

    @EventHandler
    public void PlayerMove(PlayerMoveEvent event) {
        Player p = event.getPlayer();
        if (PlayerList.getPlayerList().contains(p)) {
            Location q = event.getFrom();
            Location w = event.getTo();
            if (p instanceof Player) {
                if (q.getX() != w.getX() || q.getY() != w.getY() || q.getZ() != w.getZ()) {
                    event.setTo(q);
                }
            }
        }
    }
}
