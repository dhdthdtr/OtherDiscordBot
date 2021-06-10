package Commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Privacy extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String messageSent = event.getMessage().getContentRaw();

        if(messageSent.equalsIgnoreCase(".vscode")) {
            event.getChannel().sendMessage("code --install-extension austin.code-gnu-global\n" +
                    "code --install-extension clarkyu.vscode-sql-beautify\n" +
                    "code --install-extension CoenraadS.bracket-pair-colorizer\n" +
                    "code --install-extension dracula-theme.theme-dracula\n" +
                    "code --install-extension esbenp.prettier-vscode\n" +
                    "code --install-extension formulahendry.code-runner\n" +
                    "code --install-extension GrapeCity.gc-excelviewer\n" +
                    "code --install-extension icrawl.discord-vscode\n" +
                    "code --install-extension ms-mssql.mssql\n" +
                    "code --install-extension ms-vscode.cpptools\n" +
                    "code --install-extension ms-vsliveshare.vsliveshare\n" +
                    "code --install-extension mtxr.sqltools\n" +
                    "code --install-extension redhat.fabric8-analytics\n" +
                    "code --install-extension redhat.java\n" +
                    "code --install-extension redhat.vscode-commons\n" +
                    "code --install-extension redhat.vscode-xml\n" +
                    "code --install-extension ritwickdey.LiveServer\n" +
                    "code --install-extension Shan.code-settings-sync\n" +
                    "code --install-extension tobiasalthoff.atom-material-theme\n" +
                    "code --install-extension VisualStudioExptTeam.vscodeintellicode\n" +
                    "code --install-extension vscjava.vscode-java-debug\n" +
                    "code --install-extension vscjava.vscode-java-dependency\n" +
                    "code --install-extension vscjava.vscode-java-pack\n" +
                    "code --install-extension vscjava.vscode-java-test\n" +
                    "code --install-extension vscjava.vscode-maven")
            .queue();
        }
    }
}
