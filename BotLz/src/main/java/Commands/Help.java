package Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Help extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String messageSent = event.getMessage().getContentRaw();
        EmbedBuilder embed = new EmbedBuilder();

        if (messageSent.contains(".help")) {
            embed.setAuthor("\uD835\uDCD7\uD835\uDCEA \uD835\uDCE3\uD835\uDCFB\uD835\uDCEA\uD835\uDCF6\uD83D\uDC30",null,"https://imgur.com/CUaKhqG.png");
            // Description
            embed.addField("Commands",
                    """
                            **date**: get real-time date
                            **time**: get current time
                            **linkmeet**: get google meet link of all course
                            **doge**: get random shiba images
                            **vscode**: get all the vscode extension
                            **TKB**: get the schedule of current semester
                            **avatar**: get someone avatar (Usage: **avatar @user**)
                            **source**: get the source code (đ có cái lồn gì đâu)
                            **join**: connect the bot to voice room
                            **leave**: disconnect the bot from voice room
                            **prefix**: change the prefix (default: .)
                            """,
                    false);
            event.getChannel().sendMessage(embed.build()).queue();
        }
    }
}
