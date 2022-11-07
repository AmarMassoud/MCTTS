package me.amar.mctts.Discord;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class JoinVCCommand extends ListenerAdapter {


    public void onMessageReceived(MessageReceivedEvent e) {
        String[] args = e.getMessage().getContentRaw().split("\\s+");
        if (!e.getMember().getUser().equals(e.getJDA().getSelfUser())) {
            if (args[0].equalsIgnoreCase("!!!join")) {
                if (e.getMember().getVoiceState().inAudioChannel()) {
                    e.getGuild().getAudioManager().openAudioConnection(e.getMember().getVoiceState().getChannel());
                    e.getChannel().sendMessage("Joined your voice channel!").queue();
                }

            }
        }
    }
}