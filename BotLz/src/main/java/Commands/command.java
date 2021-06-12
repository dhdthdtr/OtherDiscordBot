package Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Date;
import java.text.SimpleDateFormat;

public class command extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String messageSent = event.getMessage().getContentRaw();
//        String name = event.getMember().getUser().getName();
        SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();

        if(messageSent.equalsIgnoreCase("hello")) {
            if(!event.getMember().getUser().isBot()) {
                event.getChannel().sendMessage("Hello! " + event.getMember().getAsMention()).queue();
            }
        }
        else if(messageSent.contains("alo")) {
            if(event.getMember().getUser().isBot()) {
                event.getChannel().sendMessage("lô lô cc").queue();
            }
        }

        else if(messageSent.contains(".date")) {
            if(!event.getMember().getUser().isBot()) {
                event.getChannel().sendMessage("Ngày: " + formatDate.format(date)).queue();
            }
        }

        else if(messageSent.equalsIgnoreCase(".time")) {
            if (!event.getMember().getUser().isBot()) {
                event.getChannel().sendMessage("Thời gian: " + formatTime.format(date)).queue();
            }
        }

        else if(messageSent.contains("Minh Anh")) {
            if(!event.getMember().getUser().isBot()) {
                event.getChannel().sendMessage("của Bằng Nguyễn , hỏi hỏi cái lồn địt mẹ mày " + event.getMember().getAsMention()).queue();
            }
        }

        else if(messageSent.equalsIgnoreCase("bye")) {
            event.getChannel().sendMessage("bye bye" + event.getMember().getAsMention()).queue();
            System.exit(0);
        }
    }
}

