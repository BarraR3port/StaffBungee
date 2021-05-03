package cl.bebt.staffbungee.PluginMessageChannel.StaffCore;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.Collection;
import java.util.Map;

public class sendStaffChatMSGAlert {
    public sendStaffChatMSGAlert( String sender , String msg , String server ){
        Collection < ProxiedPlayer > networkPlayers = ProxyServer.getInstance( ).getPlayers( );
        if ( networkPlayers == null || networkPlayers.isEmpty( ) ) {
            return;
        }
        ByteArrayDataOutput out = ByteStreams.newDataOutput( );
        out.writeUTF( "StaffChat" );
        out.writeUTF( sender );
        out.writeUTF( msg );
        out.writeUTF( server );
        
        for ( Map.Entry < String, ServerInfo > testPlayer : ProxyServer.getInstance( ).getServers( ).entrySet( ) ) {
            try {
                ProxyServer.getInstance( ).getServerInfo( testPlayer.getKey( ) ).sendData( "sc:alerts" , out.toByteArray( ) );
            } catch ( NullPointerException ignored ) {
            }
        }
    }
}
