package Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TKB extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        //Current date and time, used for footer on embededbuilder
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat formatDate = new SimpleDateFormat(("dd/MM/yyyy"));
        Date date = new Date();
        String messageSent = event.getMessage().getContentRaw();
        EmbedBuilder embed = new EmbedBuilder();

        if(messageSent.equalsIgnoreCase(".TKB")) {
            embed.setTitle("Thời khoá biểu kỳ 4: ");
            embed.setImage("https://i.imgur.com/OFY57Zq.png");
            event.getChannel().sendMessage(embed.build()).queue();
        }
    }
}
