package hiros15.sakuraranks;

import hiros15.sakuraranks.Commands.Commands;
import hiros15.sakuraranks.Config.RanksConfig;
import hiros15.sakuraranks.Events.PlayerJoin;

import org.bukkit.plugin.java.JavaPlugin;


//API GET RANK IS NOT WORKING MUST FIX!!!

public class SakuraRanks extends JavaPlugin {
	@Override
	public void onEnable() {
		setupEvents();
		setupConfig();
		setupCommands();
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public void setupEvents() {
		getServer().getPluginManager().registerEvents(new PlayerJoin(this), this);
	}
	
	public void setupConfig() {
		RanksConfig ranksconfig = new RanksConfig(this);
		if(!(ranksconfig.getConfig().getBoolean("setup"))) {
			ranksconfig.getConfig().set("setup", true);
			ranksconfig.saveConfig();
		}
	}
	
	public void setupCommands() {
		this.getCommand("sakuraranks").setExecutor(new Commands(this));
	}
}
