package hiros15.sakuraranks.Events;

import hiros15.sakuraranks.Config.RanksConfig;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class PlayerJoin implements Listener {
	private Plugin plugin;
	public PlayerJoin(Plugin plugin) {
		this.plugin = plugin;
	}
	
	RanksConfig ranksconfig;
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		ranksconfig = new RanksConfig(plugin);
		Player player = event.getPlayer();
		
		if(!(ranksconfig.getConfig().getBoolean("ranks."+player.getName()+".setup"))) {
			setupRankedPlayer(player);
		}
	}
	
	public void setupRankedPlayer(Player player) {
		ranksconfig.getConfig().set("ranks."+player.getName()+".setup", true);
		ranksconfig.getConfig().set("ranks."+player.getName()+".rank", "normal");
		ranksconfig.saveConfig();
	}
}
