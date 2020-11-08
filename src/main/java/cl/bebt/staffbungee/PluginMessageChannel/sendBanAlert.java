package cl.bebt.staffbungee.PluginMessageChannel;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.Collection;
import java.util.Map;

public class sendBanAlert {
    public sendBanAlert(String sender, String target, String reason, Boolean permanent, Boolean Ip, Long amount, String time, String ExpDate, String date, String server){
        Collection<ProxiedPlayer> networkPlayers = ProxyServer.getInstance().getPlayers();
        if (networkPlayers == null || networkPlayers.isEmpty()){return;}
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Ban");
        out.writeUTF(sender);
        out.writeUTF(target);
        out.writeUTF(reason);
        out.writeBoolean(permanent);
        out.writeBoolean(Ip);
        out.writeLong(amount);
        out.writeUTF(time);
        out.writeUTF(ExpDate);
        out.writeUTF(date);
        out.writeUTF(server);
        for (Map.Entry<String, ServerInfo> servers : ProxyServer.getInstance().getServersCopy().entrySet()){
            try{
            ProxyServer.getInstance().getServerInfo(servers.getKey()).sendData("sc:alerts", out.toByteArray());
            } catch (NullPointerException ignored){}
        }
    }
}
