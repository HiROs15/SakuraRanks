package hiros15.sakuraranks.Commands;

import hiros15.sakuraranks.Api.Api;
import hiros15.sakuraranks.Api.Api.Ranks;
import hiros15.sakuraranks.Config.RanksConfig;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Commands implements CommandExecutor {
	private Plugin plugin;
	public Commands(Plugin plugin) {
		this.plugin = plugin;
	}
	
	@SuppressWarnings("unused")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			plugin.getLogger().warning("Please do not use these commands through the console.");
			return false;
		}
		
		Player player = (Player) sender;
		Api rankapi = new Api(plugin);
		
		if(cmd.getName().equalsIgnoreCase("sakuraranks")) {
			if(args.length == 0) {
				//Do the help menu.
			}
			
			if(args[0].equalsIgnoreCase("setrank")) {
				RanksConfig ranksconfig = new RanksConfig(plugin);
				
				if(!(args.length == 3)) {
					player.sendMessage(ChatColor.DARK_RED+"Please give a player name and a rank name.");
					return false;
				}
				if(rankapi.getRank(player) == Ranks.ADMIN || rankapi.getRank(player) == Ranks.SAKURAMEMBER) { 
				rankapi.setRank(Bukkit.getServer().getPlayer(args[1]), args[2]);
				player.sendMessage(ChatColor.YELLOW+"You have updated "+args[1]+"'s Sakura Network rank.");
				return false;
				} else {
					player.sendMessage(ChatColor.DARK_RED+"You do not have permission to do this.");
					return false;
				}
			}
		}
		
		return false;
	}
}
