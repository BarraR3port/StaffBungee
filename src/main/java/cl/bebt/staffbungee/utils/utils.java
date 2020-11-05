package cl.bebt.staffbungee.utils;

import cl.bebt.staffbungee.main;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class utils {

    private static main plugin = main.getPlugin();

    public static String chat(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static void tell(CommandSender sender, String message) {
        if (sender instanceof ProxiedPlayer) {
            ProxiedPlayer player = (ProxiedPlayer) sender;
            player.sendMessage(tc(message));
        } else {
            ProxyServer.getInstance().getConsole().sendMessage(tc(message));
        }
    }
    public static TextComponent tc(String s){return new TextComponent(chat(s));}
}
