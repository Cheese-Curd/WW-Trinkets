package io.github.cheesecurd.wwtrinkets.effects;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class ScriptEffect extends StatusEffect
{
	/*
		This is for effects that do event or other script stuff.
		Ie: Removing fall damage
	 */

	public ScriptEffect(StatusEffectCategory statusEffectCategory, int color) {
		super(statusEffectCategory, color);
	}

	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier)
	{
		return true;
	}
}
