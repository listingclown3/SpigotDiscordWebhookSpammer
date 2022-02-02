package me.list3.webhookspammer;

import org.bukkit.plugin.java.JavaPlugin;

import me.list3.webhookspammer.events.SendEmbed;


public class Main extends JavaPlugin {
	
	
	@Override
	public void onEnable() {
		this.getCommand("whe").setExecutor(new SendEmbed());
		
	}
	
	@Override
	public void onDisable() {
		
		
	}

}
