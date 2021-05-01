package cl.bebt.staffbungee.PluginMessageChannel.StaffCore;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.Collection;
import java.util.Map;

public class sendSLMenuInfo {
    public sendSLMenuInfo( String sender , String server , int servers , String staffMembers , String staffMembersServer , String staffMembersPing , String staffMembersGamemode ){
        Collection < ProxiedPlayer > networkPlayers = ProxyServer.getInstance( ).getPlayers( );
        if ( networkPlayers == null || networkPlayers.isEmpty( ) ) {
            return;
        }
        ByteArrayDataOutput out = ByteStreams.newDataOutput( );
        out.writeUTF( "OpenMenu" );
        out.writeUTF( sender );
        out.writeUTF( server );
        out.writeInt( servers );
        out.writeUTF( staffMembers );
        out.writeUTF( staffMembersServer );
        out.writeUTF( staffMembersPing );
        out.writeUTF( staffMembersGamemode );
        
        for ( Map.Entry < String, ServerInfo > testPlayer : ProxyServer.getInstance( ).getServersCopy( ).entrySet( ) ) {
            try {
                ProxyServer.getInstance( ).getServerInfo( testPlayer.getKey( ) ).sendData( "sc:stafflist" , out.toByteArray( ) );
            } catch ( NullPointerException ignored ) {
            }
        }
    }
}
