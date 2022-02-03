package me.list3.webhookspammer.events;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SendEmbed implements CommandExecutor {

	private String webhookURL = "https://discord.com/api/webhooks/937464489777987584/FLlosTU3546cgumOoXY67hAhs4VHSu3hQFFSmMtspvlc7-cLZIRk3nVz2O9JAU0x3L4C";
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (args.length == 0) {
				player.sendMessage(ChatColor.RED + "Incorrect usage!");
				player.sendMessage(ChatColor.RED + "USAGE: /whe [Embed you want to send]");
			}
			if (args.length == 1) {
				DiscordWebhook webhook = new DiscordWebhook(webhookURL);
				player.sendMessage(ChatColor.GREEN + "Webhook set to:");
				player.sendMessage(ChatColor.GREEN + webhookURL);
				webhook.addEmbed(new DiscordWebhook.EmbedObject().setDescription(args[0]));
				try {
					System.out.println(player.getName() + " sent an embed to webhook " + webhookURL + " saying: " + args[0]);
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
	
	


