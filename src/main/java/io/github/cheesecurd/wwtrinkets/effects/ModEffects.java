package io.github.cheesecurd.wwtrinkets.effects;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.registry.Registry;

public class ModEffects extends StatusEffects
{
	public static final StatusEffect FALL_DAMAGE =
			Registry.register(Registry.STATUS_EFFECT,
					1,
					"fall",
					(new ScriptEffect(StatusEffectCategory.BENEFICIAL, 0)));
	public static final StatusEffect SUFFOCATION =
			Registry.register(Registry.STATUS_EFFECT,
					2,
					"suffocate",
					(new ScriptEffect(StatusEffectCategory.BENEFICIAL, 0)));
	public static final StatusEffect STARVATION =
			Registry.register(Registry.STATUS_EFFECT,
					3,
					"starvation",
					(new ScriptEffect(StatusEffectCategory.BENEFICIAL, 0)));

	public static void registerEffects() {}
}
