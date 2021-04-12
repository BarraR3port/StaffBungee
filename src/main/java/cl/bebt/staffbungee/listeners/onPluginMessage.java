package cl.bebt.staffbungee.listeners;

import cl.bebt.staffbungee.PluginMessageChannel.*;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import net.md_5.bungee.api.event.PluginMessageEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class onPluginMessage implements Listener {

    private int servers = 1;

    @EventHandler
    public void onPluginMessage(final PluginMessageEvent e) {
        if (e.isCancelled()) { return; }
        if (e.getTag().equalsIgnoreCase("sc:alerts")) {
            ByteArrayDataInput in = ByteStreams.newDataInput( e.getData() );
            String subChannel = in.readUTF();
            if ( subChannel.equalsIgnoreCase( "Report" )){
                int id = in.readInt();
                String sender = in.readUTF();
                String target = in.readUTF();
                String reason = in.readUTF();
                String date = in.readUTF();
                String server = in.readUTF();
                new sendReportAlert(id,sender,target,reason,date,server);
            } else if ( subChannel.equalsIgnoreCase( "ReportChange" )){
                int id = in.readInt();
                String changer = in.readUTF();
                String sender = in.readUTF();
                String target = in.readUTF();
                String reason = in.readUTF();
                String date = in.readUTF();
                String status = in.readUTF();
                String server = in.readUTF();
                new sendReportChangeAlert(id,changer,sender,target,reason,date,status,server);
            } else if ( subChannel.equalsIgnoreCase( "Ban" )){
                String sender = in.readUTF();
                String target = in.readUTF();
                String reason = in.readUTF();
                Boolean permanent = in.readBoolean();
                Boolean Ip = in.readBoolean();
                Long amount = in.readLong();
                String time = in.readUTF();
                String ExpDate = in.readUTF();
                String date = in.readUTF();
                String server = in.readUTF();
                new sendBanAlert(sender,target,reason,permanent,Ip,amount,time,ExpDate,date,server);
            } else if ( subChannel.equalsIgnoreCase( "Warn" )){
                String sender = in.readUTF();
                String target = in.readUTF();
                String reason = in.readUTF();
                Long amount = in.readLong();
                String time = in.readUTF();
                String ExpDate = in.readUTF();
                String date = in.readUTF();
                String server = in.readUTF();
                new sendWarnAlert(sender,target,reason,amount,time,ExpDate,date,server);
            } else if ( subChannel.equalsIgnoreCase( "BanChange" )){
                int Id = in.readInt();
                String changer = in.readUTF();
                String sender = in.readUTF();
                String target = in.readUTF();
                String reason = in.readUTF();
                String ExpDate = in.readUTF();
                String date = in.readUTF();
                String status = in.readUTF();
                String server = in.readUTF();
                new sendBanChangeAlert(Id,changer,sender,target,reason,ExpDate,date,status,server);
            } else if ( subChannel.equalsIgnoreCase( "WarnChange" )){
                int Id = in.readInt();
                String changer = in.readUTF();
                String sender = in.readUTF();
                String target = in.readUTF();
                String reason = in.readUTF();
                String ExpDate = in.readUTF();
                String date = in.readUTF();
                String status = in.readUTF();
                String server = in.readUTF();
                new sendWarnChangeAlert(Id,changer,sender,target,reason,ExpDate,date,status,server);
            } else if ( subChannel.equalsIgnoreCase( "Freeze" )){
                String sender = in.readUTF();
                String target = in.readUTF();
                Boolean bool = in.readBoolean();
                String server = in.readUTF();
                new sendFreezeAlert(sender,target,bool,server);
            } else if ( subChannel.equalsIgnoreCase( "Wipe" )){
                String sender = in.readUTF();
                String target = in.readUTF();
                int bans = in.readInt();
                int reports = in.readInt();
                int warns = in.readInt();
                String server = in.readUTF();
                new sendWipeAlert(sender,target,bans,reports,warns,server);
            } else if ( subChannel.equalsIgnoreCase( "StaffChat" )){
                String sender = in.readUTF();
                String message = in.readUTF();
                String server = in.readUTF();
                new sendStaffChatMSGAlert(sender,message,server);
            } else if ( subChannel.equalsIgnoreCase( "HelpOp" )){
                String sender = in.readUTF();
                String message = in.readUTF();
                String server = in.readUTF();
                new sendHelpopAlert(sender,message,server);
            }
        } else if (e.getTag().equalsIgnoreCase("sc:stafflist")) {
            ByteArrayDataInput in = ByteStreams.newDataInput( e.getData() );
            String subChannel = in.readUTF();
            if ( subChannel.equalsIgnoreCase( "SendSLRequest" )){
                String sender = in.readUTF();
                String server = in.readUTF();
                servers++;
                new sendSLRequest(sender,server);
            }
            if ( subChannel.equalsIgnoreCase( "SendData" )){
                String sender = in.readUTF();
                String server = in.readUTF();
                String staffMembers = in.readUTF();
                String staffMembersServer = in.readUTF();
                String staffMembersPing = in.readUTF();
                String staffMembersGamemode = in.readUTF();
                new sendSLMenuInfo(sender,server,servers,staffMembers,staffMembersServer,staffMembersPing,staffMembersGamemode);
                servers = 1;
                //new sendSLRequest(sender,server);
            }
        }
    }

}
