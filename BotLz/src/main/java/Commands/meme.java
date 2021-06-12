package Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class meme extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String messageSent = event.getMessage().getContentRaw();
        JSONParser parser = new JSONParser();

        String postLink = "";
        String title = "";
        String url = "";

        if (messageSent.contains(".meme")) {
            try {
                URL memeURL = new URL("https://meme-api.herokuapp.com/gimme");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(memeURL.openConnection().getInputStream()));

                String lines;
                while ((lines = bufferedReader.readLine()) != null) {
                    JSONArray array = new JSONArray();
                    array.add(parser.parse(lines));

                    for (Object o : array) {
                        JSONObject jsonObject = (JSONObject) o;

                        postLink = (String) jsonObject.get("postLink");
                        title = (String) jsonObject.get("title");
                        url = (String) jsonObject.get("url");
                    }
                }
                bufferedReader.close();
                
                EmbedBuilder embed = new EmbedBuilder();
                embed.setTitle(title, postLink);
                embed.setImage(url);
                embed.setColor(Color.RED);
                event.getChannel().sendMessage(embed.build()).queue();
            }
            catch (Exception e) {
                event.getChannel().sendMessage("Dm thằng Bằng Nguyễn code bot ngu vailon, thử lại đi bro").queue();
                e.printStackTrace();
            }
        }
    }
}
