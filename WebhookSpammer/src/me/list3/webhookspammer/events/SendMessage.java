package me.list3.webhookspammer.events;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SendMessage implements CommandExecutor {
	
private String webhookURL = "https://discord.com/api/webhooks/938280589650448454/odOLoGWv-Y1HXJuE0_0keWESNh6JxI5r9YkwkZmZrqrts55pO_PEIyJO8MSY8wiQtWPF";
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (args.length == 0) {
				player.sendMessage(ChatColor.RED + "Incorrect usage!");
				player.sendMessage(ChatColor.RED + "USAGE: /whs [Message you want to send]");
			}
			if (args.length == 1) {
				DiscordWebhook webhook = new DiscordWebhook(webhookURL);
				player.sendMessage(ChatColor.GREEN + "Webhook set to:");
				player.sendMessage(ChatColor.GREEN + webhookURL);
				webhook.setContent(args[0]);
				try {
					System.out.println(player.getName() + " sent a message to webhook " + webhookURL + " saying: " + args[0]);
					webhook.execute();
				}
				catch(Exception e) {
					return false;
				}
			}
				
			
		}
		
		
		return false;
	}

}
