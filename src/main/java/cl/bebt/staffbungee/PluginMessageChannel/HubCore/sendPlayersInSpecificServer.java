package cl.bebt.staffbungee.PluginMessageChannel.HubCore;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.Collection;
import java.util.Map;

public class sendPlayersInSpecificServer {
    public sendPlayersInSpecificServer( String serverTarget , String server ){
        Collection < ProxiedPlayer > networkPlayers = ProxyServer.getInstance( ).getPlayers( );
        if ( networkPlayers == null || networkPlayers.isEmpty( ) ) {
            return;
        }
        ByteArrayDataOutput out = ByteStreams.newDataOutput( );
        out.writeUTF( "PPServer" );
        int amount = ProxyServer.getInstance( ).getServerInfo( serverTarget ).getPlayers( ).size( );
        out.writeInt( amount );
        out.writeUTF( serverTarget );
        out.writeUTF( server );
        for ( Map.Entry < String, ServerInfo > testPlayer : ProxyServer.getInstance( ).getServers( ).entrySet( ) ) {
            try {
                ProxyServer.getInstance( ).getServerInfo( testPlayer.getKey( ) ).sendData( "hc:msg" , out.toByteArray( ) );
            } catch ( NullPointerException ignored ) {
            }
        }
    }
}
