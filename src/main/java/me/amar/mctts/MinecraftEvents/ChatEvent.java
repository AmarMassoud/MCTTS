package me.amar.mctts.MinecraftEvents;

import com.github.kilianB.apis.googleTextToSpeech.GLanguage;
import com.github.kilianB.apis.googleTextToSpeech.GoogleTextToSpeech;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import me.amar.mctts.LavaPlayer.PlayerManager;
import me.amar.mctts.LavaPlayer.TrackScheduler;
import me.amar.mctts.Listener.AcronymListener;
import me.amar.mctts.MCTTS;
import net.dv8tion.jda.api.entities.channel.concrete.VoiceChannel;
import net.dv8tion.jda.api.utils.WidgetUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.io.File;

public class ChatEvent implements Listener {
    AudioPlayerManager playerManager = new DefaultAudioPlayerManager();

    AudioPlayer player = playerManager.createPlayer();
    TrackScheduler trackScheduler = new TrackScheduler(player);
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        AudioSourceManagers.registerRemoteSources(playerManager);
        Player p = e.getPlayer();
        if (p.hasPermission("op")) {
            for (VoiceChannel voiceChannel : MCTTS.getInstance().getJda().getVoiceChannels()) {
                
            }
            String outputPath = "mpFiles/";
            File outputDirectory = new File(outputPath);
            String playPath = "mpFiles/CurrentChat.mp3";
            outputDirectory.mkdirs();
            GoogleTextToSpeech tts = new GoogleTextToSpeech(outputPath);

            File convertedTextMP3 = tts.convertText(AcronymListener.convertMessage(e.getMessage()), GLanguage.English_NZ, "CurrentChat");
            PlayerManager.getInstance().loadAndPlay(MCTTS.getInstance().getJda().getTextChannelById(1038162166404087818L), playPath);


        }

    }
}
