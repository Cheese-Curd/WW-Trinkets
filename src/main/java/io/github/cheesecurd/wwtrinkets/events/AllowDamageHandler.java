package io.github.cheesecurd.wwtrinkets.events;

import io.github.cheesecurd.wwtrinkets.effects.ModEffects;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;

import static net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents.ALLOW_DAMAGE;

public class AllowDamageHandler implements ServerLivingEntityEvents.AllowDamage
{
	@Override
	public boolean allowDamage(LivingEntity entity, DamageSource source, float amount) {
		return false;
	}
}


