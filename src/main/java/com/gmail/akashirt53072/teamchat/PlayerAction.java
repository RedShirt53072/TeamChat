package com.gmail.akashirt53072.teamchat;
//playerの行動をトリガーに様々な処理クラスへと取り次ぐクラス
import org.bukkit.event.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public final class PlayerAction implements Listener {
	Main plugin;
    public PlayerAction(Main plugin) {
    	this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    
    @EventHandler
    public void onPlayerChat(final AsyncPlayerChatEvent event) {
    	Player player = event.getPlayer();
    	ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getMainScoreboard();
		Team team = board.getEntryTeam(player.getName());
    	if(team == null) {
    		return;
    	}
    	String price = event.getMessage();
        //チャット処理
        char c = price.charAt(0);
        String ca = String.valueOf(c);
        if(ca.equals("!")) {
        	return;
        }
        event.setCancelled(true);
        Bukkit.getScheduler().runTask(plugin, new Runnable() {
            @Override
            public void run() {
            	//in minecraft
                
                
                for(Player p : player.getServer().getOnlinePlayers()) {
                	Team team1 = board.getEntryTeam(p.getName());
                	if(team1.equals(team)) {
                    	p.sendMessage("[TeamChat]<" + player.getName() + "> " + price);
                	}
                }
            }
    	});
    }
    
}