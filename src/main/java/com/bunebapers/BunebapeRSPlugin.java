package com.bunebapers;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.api.GameState;
import net.runelite.api.events.ActorDeath;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


@Slf4j
@PluginDescriptor(
	name = "BunebapeRS"
)
public class BunebapeRSPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private BunebapeRSConfig config;

	@Override
	protected void startUp() throws Exception
	{
		log.debug("BunebapeRS started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.debug("BunebapeRS stopped!");
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (!config.deathSound()){
            return;
        }

        if (!config.levelupSound()){
            return;
        }

        if (!config.lootSound()){
            return;
        }
	}

    @Subscribe
    public void onActorDeath(ActorDeath event){
        if (!config.deathSound()){
            return;
        }
        if (!config.deathSound())
        {
            return;
        }

        if (!(event.getActor() instanceof Player))
        {
            return;
        }

        Player player = (Player) event.getActor();

        if (player != client.getLocalPlayer())
        {
            return;
        }

        playDeathSound();
    }

	@Provides
    BunebapeRSConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(BunebapeRSConfig.class);
	}

    private void playDeathSound(){
        try
        {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(
                    getClass().getResource("/death.wav")
            );

            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        }
        catch (Exception e)
        {
            log.error("Failed to play death sound", e);
        }
    }
}
