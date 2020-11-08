package cl.bebt.staffbungee;

import cl.bebt.staffbungee.listeners.onPluginMessage;
import cl.bebt.staffbungee.utils.utils;
import net.md_5.bungee.api.plugin.Plugin;

public final class main extends Plugin {

    public static main plugin;

    public static main getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;
        utils.tell(getProxy().getConsole(), "&8[&a&lSTAFF CORE BUNGEE&r&8]&r " + "&1---------------------------------");
        utils.tell(getProxy().getConsole(), "&8[&a&lSTAFF CORE BUNGEE&r&8]&r " + "&a    Plugin &5StaffCore Bungee&a&l ACTIVATED");
        utils.tell(getProxy().getConsole(), "&8[&a&lSTAFF CORE BUNGEE&r&8]&r " + "&1----------------------------------");
        utils.tell(getProxy().getConsole(), "&8[&a&lSTAFF CORE BUNGEE&r&8]&r " + "&a         StaffCore Bungee: &5" + this.getDescription().getVersion());
        utils.tell(getProxy().getConsole(), "&8[&a&lSTAFF CORE BUNGEE&r&8]&r " + "&1---------------------------------");
        getProxy().getPluginManager().registerListener(this, new onPluginMessage());
        getProxy().registerChannel("sc:alerts");
        getProxy().registerChannel("sc:stafflist");
    }

    @Override
    public void onDisable() {
        utils.tell(getProxy().getConsole(), "&8[&a&lSTAFF CORE BUNGEE&r&8]&r " + "&1---------------------------------");
        utils.tell(getProxy().getConsole(), "&8[&a&lSTAFF CORE BUNGEE&r&8]&r " + "&a    Plugin &5StaffCore Bungee&c&l DEACTIVATED");
        utils.tell(getProxy().getConsole(), "&8[&a&lSTAFF CORE BUNGEE&r&8]&r " + "&1----------------------------------");

    }
}
