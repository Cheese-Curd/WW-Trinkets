package io.github.cheesecurd.wwtrinkets.mixin;

import io.github.cheesecurd.wwtrinkets.effects.ModEffects;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity
{
	protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world, boolean hasStatusEffect) {
		super(entityType, world);
	}

	@Inject(method = "damage", at = @At(value = "HEAD"), cancellable = true)
	public void damage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir)
	{
		if (this.hasStatusEffect(ModEffects.FALL_DAMAGE))
			if (source == DamageSource.FALL)
				cir.setReturnValue(false);
		if (this.hasStatusEffect(ModEffects.SUFFOCATION))
			if (source == DamageSource.IN_WALL)
				cir.setReturnValue(false);
		if (this.hasStatusEffect(ModEffects.STARVATION))
			if (source == DamageSource.STARVE)
				cir.setReturnValue(false);
	}
}