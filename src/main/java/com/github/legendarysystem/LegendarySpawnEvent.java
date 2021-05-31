package com.github.legendarysystem;

import com.pixelmonmod.pixelmon.api.events.spawning.SpawnEvent;
import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.IOException;

public class LegendarySpawnEvent {

    @SubscribeEvent
    public void LegendarySpawnEvent(SpawnEvent event) throws IOException {
        Entity spawnnpokemon = event.action.getOrCreateEntity();
        if (spawnnpokemon instanceof EntityPixelmon) {
            EntityPixelmon pokemon = (EntityPixelmon) spawnnpokemon;
            if (pokemon.getPokemonData().isLegendary() && !pokemon.isBossPokemon()) {
                DiscordWebhook discordWebhook = new DiscordWebhook(Config.getConfig().get("Discord", "Discord_Webhook_Url", "").getString());
                discordWebhook.setContent(Config.getConfig().get("Discord", "Discord_Webhook_Content", "").getString().replace("{pokename}", pokemon.getSpecies().getLocalizedName()).replace("{biome}", event.action.spawnLocation.biome.biomeName));
                discordWebhook.setUsername(Config.getConfig().get("Discord", "Discord_Webhook_NickName", "").getString().replace("{pokename}", pokemon.getSpecies().getLocalizedName()));
                discordWebhook.setAvatarUrl("https://gitlab.com/skyasa2256/test/-/raw/master/" + pokemon.getSpecies().getNationalPokedexNumber() + ".png");
                discordWebhook.execute();
            }
        }
    }
}
