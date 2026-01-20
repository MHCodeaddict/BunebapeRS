package com.bunebapers;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("example")
public interface BunebapeRSConfig extends Config
{
    //1
	@ConfigItem(
		keyName = "deathSound",
		name = "Death Sound",
		description = "Play sound effect upon death"
	) default boolean deathSound() {return true;}
    //2
    @ConfigItem(
            keyName = "levelupSound",
            name = "Level up",
            description = "Play sound effect upon level up"
    ) default boolean levelupSound(){return true;}
    //3
    @ConfigItem(
            keyName = "lootSound",
            name = "Rare Loot sound",
            description = "Play sound when player receives rare loot"
    ) default boolean lootSound(){return true;}
}
