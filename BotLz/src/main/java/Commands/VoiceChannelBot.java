package Commands;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.managers.AudioManager;

public class VoiceChannelBot extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if(event.getAuthor().isBot()) {
            return;
        }

        String messageSent = event.getMessage().getContentRaw();
        TextChannel channel = event.getChannel();

        if(messageSent.equals(".join")) {
            if(!event.getGuild().getSelfMember().hasPermission(channel, Permission.VOICE_CONNECT)) {
                channel.sendMessage("I do not have permissions to join a voice channel!").queue();
                return;
            }
            // Creates a variable equal to the channel that the user is in.
            VoiceChannel connectedChannel = event.getMember().getVoiceState().getChannel();
            // Checks if they are in a channel -- not being in a channel means that the variable = null.
            if(connectedChannel == null) {
                // Don't forget to .queue()!
                channel.sendMessage("You are not connected to a voice channel!").queue();
                return;
            }
            // Gets the audio manager.
            AudioManager audioManager = event.getGuild().getAudioManager();
            // When somebody really needs to chill.
            if(audioManager.isAttemptingToConnect()) {
                channel.sendMessage("The bot is already trying to connect! Enter the chill zone!").queue();
                return;
            }
            // Connects to the channel.
            audioManager.openAudioConnection(connectedChannel);
            // Obviously people do not notice someone/something connecting.
            channel.sendMessage("Đã kết nối tới phòng voice!").queue();
        }
        else if(messageSent.equals(".leave")) {
            // Gets the channel in which the bot is currently connected.
            VoiceChannel connectedChannel = event.getGuild().getSelfMember().getVoiceState().getChannel();
            // Checks if the bot is connected to a voice channel.
            if(connectedChannel == null) {
                // Get slightly fed up at the user.
                channel.sendMessage("I am not connected to a voice channel!").queue();
                return;
            }
            // Disconnect from the channel.
            event.getGuild().getAudioManager().closeAudioConnection();
            // Notify the user.
            channel.sendMessage("Disconnected from the voice channel!").queue();
        }
    }
}

