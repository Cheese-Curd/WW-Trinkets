package io.github.cheesecurd.wwtrinkets.Items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class HazMatSuitItem extends ModArmorItem implements IAnimatable
{
	public HazMatSuitItem(ArmorMaterial material, EquipmentSlot slot, Item.Settings settings)
	{
		super(material, slot, settings);
	}

	@Override
	public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
		if(!world.isClient()) {
			if(entity instanceof PlayerEntity) {
				PlayerEntity player = (PlayerEntity)entity;

				if(hasFullSuitOfArmorOn(player))
					if(((PlayerEntity) entity).hasStatusEffect(StatusEffects.POISON))
						((PlayerEntity) entity).removeStatusEffect(StatusEffects.POISON);
			}
		}

		super.inventoryTick(stack, world, entity, slot, selected);
	}

	public AnimationFactory factory = new AnimationFactory(this);

	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", true));

		return PlayState.CONTINUE;
	}

	@Override
	public void registerControllers(AnimationData animationData)
	{
		animationData.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}
}
