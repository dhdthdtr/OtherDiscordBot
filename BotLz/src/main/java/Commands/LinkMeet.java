package Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LinkMeet extends ListenerAdapter{
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        EmbedBuilder embed = new EmbedBuilder();
        String messageSent = event.getMessage().getContentRaw();
        SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();

        // Just for convenient when coding
        String K1 = "**K1: **";
        String K2 = "**K2: **";
        String K3 = "**K3: **";
        String K4 = "**K4: **";

        String Mon = "Monday";
        String Tue = "Tuesday";
        String Wed = "Wednesday";
        String Thu = "Thursday";
        String Fri = "Friday";

        if (messageSent.equalsIgnoreCase(".linkmeet")) {
            embed.setTitle("Link Google Meet: ");
            // Add schedule field
            embed.addField(Mon,K3 + "Introduction to Communication\nhttps://meet.google.com/yrc-sqpt-qgt" + "\n" + K4 + "English for Oral Communication\nhttps://meet.google.com/div-rhbh-etk",true);
            embed.addField(Tue,K4 + "Database\nhttps://meet.google.com/ice-rpnt-guw",true);
            embed.addField(Wed,K1 + "English For Workplace Communication\nhttps://meet.google.com/jns-jztt-xnc" + "\n" + K2 + "Object Oriented Programming\nhttps://meet.google.com/nyv-cvzt-hpp" + "\n" + K3 + "Introduction To Communication\nhttps://meet.google.com/yrc-sqpt-qgt",true);
            embed.addField(Thu,K3 + "English For Oral Communication\nhttps://meet.google.com/div-rhbh-etk" + "\n" + K4 + "Database\nhttps://meet.google.com/ice-rpnt-guw",true);
            embed.addField(Fri,K1 + "English For Workplace Communication\nhttps://meet.google.com/jns-jztt-xnc" + "\n" + K2 + "Object Oriented Programming\nhttps://meet.google.com/nyv-cvzt-hpp",true);
            event.getChannel().sendMessage(embed.build()).queue();
        }
    }
}