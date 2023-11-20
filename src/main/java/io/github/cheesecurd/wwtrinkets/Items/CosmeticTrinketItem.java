package io.github.cheesecurd.wwtrinkets.Items;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import dev.emi.trinkets.api.client.TrinketRenderer;
import io.github.cheesecurd.wwtrinkets.WWTrinkets;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class CosmeticTrinketItem extends TrinketItem implements IAnimatable, TrinketRenderer
{
	public AnimationFactory factory = new AnimationFactory(this);

	public CosmeticTrinketItem(Settings settings) {
		super(settings);
	}

	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", true));

		return PlayState.CONTINUE;
	}

	@Override
	public void registerControllers(AnimationData animationData) {
		animationData.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));
	}

	@Override
	public AnimationFactory getFactory() {
		return factory;
	};

	@Override
	public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {

		if (entity.isOnGround()) {
			Vec3d vel = entity.getVelocity();
			entity.setVelocity(vel.x * 1.2, vel.y, vel.z * 1.2);
		} else if (entity.isInSwimmingPose()) {
			Vec3d vel = entity.getVelocity();
			entity.setVelocity(vel.x, vel.y, vel.z);
		} else if (entity.isTouchingWater()) {
			Vec3d vel = entity.getVelocity();
			entity.setVelocity(vel.x, vel.y, vel.z);
		}



		super.tick(stack, slot, entity);
	}

	@Override
	public void render(ItemStack stack, SlotReference slotReference, EntityModel<? extends LivingEntity> contextModel, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, LivingEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
		ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
		WWTrinkets.headTrinket(matrices,contextModel,entity,headYaw,headPitch);
	}
}