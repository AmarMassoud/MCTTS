package me.amar.mctts;

import me.amar.mctts.Discord.JoinVCCommand;
import me.amar.mctts.Files.DataYml;
import me.amar.mctts.MinecraftCommands.AddAcronym;
import me.amar.mctts.MinecraftEvents.ChatEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.List;

public final class MCTTS extends JavaPlugin {
    JDA jda;
    public static MCTTS getInstance() {
        return instance;
    }

    private static MCTTS instance;

    public JDA getJda() {
        return jda;
    }

    @Override
    public void onEnable() {
        instance = this;
        jda = JDABuilder.createDefault("MTAzODE1OTg2OTIwMDU4MDYxOA.GoDg5G.rWfagMoMtP3nNkt_F5Js2cunFBORA0VnedQQyY").enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_PRESENCES, GatewayIntent.MESSAGE_CONTENT).setMemberCachePolicy(MemberCachePolicy.ALL).enableCache(CacheFlag.ACTIVITY).build();
        jda.addEventListener(new JoinVCCommand());
        getLogger().info("Plugin enabled");
        Bukkit.getPluginManager().registerEvents(new ChatEvent(), this);
        getCommand("ac").setExecutor(new AddAcronym());
        loadConfigManager();

    }

    @Override
    public void onDisable() {
        getLogger().info("Logger disabled.");
    }
    public static String colorize(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public void loadConfigManager() {
        DataYml.setUpDataYml();
        DataYml.reloadDataYml();
        DataYml.getDataYml().createSection("Acronyms");
        DataYml.getDataYml().options().copyDefaults(true);
        DataYml.saveDataYml();
    }
}
