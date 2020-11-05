package cl.bebt.staffbungee.utils;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.Collection;
import java.util.Map;

public class sendBanChangeAlert {
    public sendBanChangeAlert(int id,String changer, String sender, String target, String reason, String ExpDate, String date, String status, String server){
        Collection<ProxiedPlayer> networkPlayers = ProxyServer.getInstance().getPlayers();
        if (networkPlayers == null || networkPlayers.isEmpty()){return;}
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("BanChange");
        out.writeInt(id);
        out.writeUTF(changer);
        out.writeUTF(sender);
        out.writeUTF(target);
        out.writeUTF(reason);
        out.writeUTF(ExpDate);
        out.writeUTF(date);
        out.writeUTF(status);
        out.writeUTF(server);
        for (Map.Entry<String, ServerInfo> servers : ProxyServer.getInstance().getServersCopy().entrySet()){
            try{
            ProxyServer.getInstance().getServerInfo(servers.getKey()).sendData("sc:alerts", out.toByteArray());
            } catch (NullPointerException ignored){}
        }
    }
}
