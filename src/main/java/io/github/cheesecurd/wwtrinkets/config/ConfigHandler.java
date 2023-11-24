package io.github.cheesecurd.wwtrinkets.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = "wwtrinkets")
public class ConfigHandler implements ConfigData
{
	@Comment("Gas Mask Overlay")
	public boolean gasMaskOverlay = true;
}
