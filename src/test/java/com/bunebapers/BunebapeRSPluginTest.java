package com.bunebapers;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class BunebapeRSPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(BunebapeRSPlugin.class);
		RuneLite.main(args);
	}
}