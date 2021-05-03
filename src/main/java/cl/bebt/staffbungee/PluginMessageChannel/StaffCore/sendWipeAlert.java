package cl.bebt.staffbungee.PluginMessageChannel.StaffCore;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.Collection;
import java.util.Map;

public class sendWipeAlert {
    public sendWipeAlert( String sender , String target , int bans , int reports , int warns , String server ){
        Collection < ProxiedPlayer > networkPlayers = ProxyServer.getInstance( ).getPlayers( );
        if ( networkPlayers == null || networkPlayers.isEmpty( ) ) {
            return;
        }
        ByteArrayDataOutput out = ByteStreams.newDataOutput( );
        out.writeUTF( "Wipe" );
        out.writeUTF( sender );
        out.writeUTF( target );
        out.writeInt( bans );
        out.writeInt( reports );
        out.writeInt( warns );
        out.writeUTF( server );
        for ( Map.Entry < String, ServerInfo > testPlayer : ProxyServer.getInstance( ).getServers( ).entrySet( ) ) {
            try {
                ProxyServer.getInstance( ).getServerInfo( testPlayer.getKey( ) ).sendData( "sc:alerts" , out.toByteArray( ) );
            } catch ( NullPointerException ignored ) {
            }
        }
    }
}
