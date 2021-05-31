package com.github.legendarysystem;

import com.pixelmonmod.pixelmon.Pixelmon;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(
        modid = Legendarysystem.MOD_ID,
        name = Legendarysystem.MOD_NAME,
        version = Legendarysystem.VERSION,
        dependencies = "required-after:pixelmon",
        acceptableRemoteVersions = "*"

)
public class Legendarysystem {

    public static final String MOD_ID = "legendarysystem";
    public static final String MOD_NAME = "Legendarysystem";
    public static final String VERSION = "0.2";

    /**
     * This is the instance of your mod as created by Forge. It will never be null.
     */
    @Mod.Instance(MOD_ID)
    public static Legendarysystem INSTANCE;

    /**
     * This is the first initialization event. Register tile entities here.
     * The registry events below will have fired prior to entry to this method.
     */
    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        Config.preInit();
        Pixelmon.EVENT_BUS.register(new LegendarySpawnEvent());
    }

    /**
     * This is the second initialization event. Register custom recipes
     */
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        System.out.println();
        System.out.println("이 서버는 한국 픽셀몬 커뮤니티에서 배포중인 전설 알리미 시스템을 사용중입니다! Version : " + Legendarysystem.VERSION);
        System.out.println();
    }

    /**
     * This is the final initialization event. Register actions from other mods here
     */
    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {

    }

    @Mod.EventHandler
    public void ServerStarting(FMLServerStartingEvent event) {
        event.registerServerCommand(new ReloadCommands());
    }
}
