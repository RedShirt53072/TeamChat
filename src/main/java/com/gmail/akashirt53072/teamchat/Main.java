package com.gmail.akashirt53072.teamchat;

import org.bukkit.plugin.java.JavaPlugin;



public class Main extends JavaPlugin {
	@Override
	public void onEnable() {
		
		
		new PlayerAction(this);
		
		
	}
}
