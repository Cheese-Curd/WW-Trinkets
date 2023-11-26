package io.github.cheesecurd.wwtrinkets.client;

import dev.emi.trinkets.api.client.TrinketRenderer;
import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import io.github.cheesecurd.wwtrinkets.Items.ModItems;
import io.github.cheesecurd.wwtrinkets.Items.renderer.GasMaskRenderer;
import io.github.cheesecurd.wwtrinkets.Items.renderer.ZumoRingRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.util.math.Quaternion;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class WWTrinketsClient implements ClientModInitializer
{
	/*
		https://www.reddit.com/r/fabricmc/comments/10ityw6/comment/k9ykt6k/?context=3
		https://github.com/Mlodziak00/Familiars_Trinkets/blob/master/src/main/java/net/lightglow/eldmythfam/EldritchMythicFamiliarsModClient.java
	 	I love you oh my god
	 */

	@Override
	public void onInitializeClient()
	{
		// Create GeckoLib Item Render
		GeoItemRenderer.registerItemRenderer(ModItems.gas_mask, new GasMaskRenderer());
//		GeoItemRenderer.registerItemRenderer(ModItems.golden_gauntlet, new GoldenGauntletRenderer());
		GeoItemRenderer.registerItemRenderer(ModItems.zumo_ring, new ZumoRingRenderer());

		// Render Item
		TrinketRendererRegistry.registerRenderer(ModItems.gas_mask,
				(stack, slotReference, contextModel, matrices, vertexConsumers, light, entity, limbAngle, limbDistance, tickDelta, animationProgress, headYaw, headPitch) -> {
					if (entity instanceof AbstractClientPlayerEntity player) {
						TrinketRenderer.translateToFace(matrices,
								(PlayerEntityModel<AbstractClientPlayerEntity>) contextModel, player, headYaw, headPitch);
						matrices.scale(0.65F, 0.65F, 0.65F);
						matrices.translate(0, 0, 0.25F);
						matrices.multiply(new Quaternion(0, 0, 180, true));
						MinecraftClient.getInstance().getItemRenderer()
								.renderItem(stack, ModelTransformation.Mode.HEAD, light, OverlayTexture.DEFAULT_UV, matrices,
										vertexConsumers, 0);
					}
				});
		TrinketRendererRegistry.registerRenderer(ModItems.zumo_ring,
				(stack, slotReference, contextModel, matrices, vertexConsumers, light, entity, limbAngle, limbDistance, tickDelta, animationProgress, headYaw, headPitch) -> {
					if (entity instanceof AbstractClientPlayerEntity player) {
						TrinketRenderer.translateToLeftArm(matrices,
								(PlayerEntityModel<AbstractClientPlayerEntity>) contextModel, player);
						matrices.scale(1.25F, 1.25F, 1.25F);
						matrices.translate(0, -0.1, -0.05);
						matrices.multiply(new Quaternion(0, 0, 180, true));
						MinecraftClient.getInstance().getItemRenderer()
								.renderItem(stack, ModelTransformation.Mode.THIRD_PERSON_LEFT_HAND, light, OverlayTexture.DEFAULT_UV, matrices,
										vertexConsumers, 0);
					}
				});
	}
}
