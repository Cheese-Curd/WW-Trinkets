package io.github.cheesecurd.wwtrinkets.effects;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEffects extends StatusEffects
{
	public static final StatusEffect FALL_DAMAGE = registerEffect("fall",
			new ScriptEffect(StatusEffectCategory.BENEFICIAL, 0));
	public static final StatusEffect SUFFOCATION = registerEffect("suffocate",
			new ScriptEffect(StatusEffectCategory.BENEFICIAL, 0));
	public static final StatusEffect STARVATION = registerEffect("starvation",
			new ScriptEffect(StatusEffectCategory.BENEFICIAL, 0));

	public static void registerEffects() {}
	private static StatusEffect registerEffect(String name, StatusEffect effect)
	{
		return Registry.register(Registry.STATUS_EFFECT, new Identifier("wwtrinkets", name), effect);
	}
}