package me.list3.webhookspammer;

import org.bukkit.plugin.java.JavaPlugin;

import me.list3.webhookspammer.events.SendEmbed;
import me.list3.webhookspammer.events.SendMessage;


public class Main extends JavaPlugin {
	
	
	@Override
	public void onEnable() {
		this.getCommand("whe").setExecutor(new SendEmbed());
		this.getCommand("whs").setExecutor(new SendMessage());
		
	}
	
	@Override
	public void onDisable() {
		
		
	}

}
