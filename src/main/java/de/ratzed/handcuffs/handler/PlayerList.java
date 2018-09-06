package de.ratzed.handcuffs.handler;

import org.bukkit.entity.Player;

import java.util.ArrayList;

public class PlayerList {

    private static ArrayList<Player> playerList = new ArrayList<>();

    public static ArrayList getPlayerList() {
        return playerList;
    }
}
