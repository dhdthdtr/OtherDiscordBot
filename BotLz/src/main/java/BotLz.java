import Commands.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class BotLz {
    public static void main(String[] args) throws Exception {
        JDA jda = JDABuilder.createDefault("ODM4NjgxMTk3NTUwODk1MTY0.YI-ouw.PnlnXC6NgN7kNUfyADo17KDbro0").build();

        ListenerAdapter[] listenerAdapters = new ListenerAdapter[]{new command(), new TKB(), new avatar(), new VoiceChannelBot(),new LinkMeet()};
        jda.addEventListener(listenerAdapters);
        jda.addEventListener(new Doge());
    }
}
