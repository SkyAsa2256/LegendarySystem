package com.github.legendarysystem;

import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

import java.io.File;

public class Config {

    public static String Webhook_URL;
    public static String Webhook_NickName;
    public static String Webhook_Content;

    private static Configuration config = null;

    public static final String Config_Name = "Discord";

    private static void syncConfig(boolean loadFonfigFile, boolean readFieldsConfig) {
        if (loadFonfigFile)
            config.load();

        Property Basic = config.get(Config_Name, "Discord_Webhook_Url", "Discord Webhook URL");
        Basic.setComment("디스코드 웹후크 링크를 입력해주세요!");
        Property Basic1 = config.get(Config_Name, "Discord_Webhook_NickName", "전설의 포켓몬 알림 [ {pokename} ]");
        Basic1.setComment("디스코드 웹후크 이름을 정해주세요!");
        Property Basic2 = config.get(Config_Name, "Discord_Webhook_Content", "**{pokename}**(가) **{biome}** 바이옴에 스폰되었습니다!");
        Basic2.setComment("디스코드 웹후크 내용을 정해주세요!");

        if (readFieldsConfig) {
            Webhook_URL = Basic.getString();
            Webhook_NickName = Basic1.getString();
            Webhook_Content = Basic2.getString();
        }

        if (config.hasChanged())
            config.save();
    }


    public static void syncFiles() {
        syncConfig(true, true);
    }

    public static Configuration getConfig() {
        return config;
    }


    public static void preInit() {
        File configFile = new File(Loader.instance().getConfigDir(), "LegendaryConfig.cfg");
        config = new Configuration(configFile);
        syncFiles();
    }

}
