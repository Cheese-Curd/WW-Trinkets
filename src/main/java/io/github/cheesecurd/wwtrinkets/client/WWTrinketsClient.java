package io.github.cheesecurd.wwtrinkets.client;

import dev.emi.trinkets.api.client.TrinketRenderer;
import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import io.github.cheesecurd.wwtrinkets.Items.ModItems;
import io.github.cheesecurd.wwtrinkets.Items.renderer.GasMaskRenderer;
import io.github.cheesecurd.wwtrinkets.Items.renderer.GoldenGauntletRenderer;
import io.github.cheesecurd.wwtrinkets.Items.renderer.TopHatRenderer;
import io.github.cheesecurd.wwtrinkets.Items.renderer.ZumoRingRenderer;
import io.github.cheesecurd.wwtrinkets.Items.renderer.armor.ColdHazMatSuitRenderer;
import io.github.cheesecurd.wwtrinkets.Items.renderer.armor.HazMatSuitRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.util.math.Quaternion;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;
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
		// Geckolib Armor Rendering
		GeoArmorRenderer.registerArmorRenderer(new HazMatSuitRenderer(),
				ModItems.hazmat_hood,
				ModItems.hazmat_suit,
				ModItems.hazmat_pants,
				ModItems.hazmat_boots);
		GeoArmorRenderer.registerArmorRenderer(new ColdHazMatSuitRenderer(),
				ModItems.coldhazmat_hood,
				ModItems.coldhazmat_suit,
				ModItems.coldhazmat_pants,
				ModItems.coldhazmat_boots);

		// Create GeckoLib Item Render
		GeoItemRenderer.registerItemRenderer(ModItems.gas_mask, new GasMaskRenderer());
		GeoItemRenderer.registerItemRenderer(ModItems.zumo_ring, new ZumoRingRenderer());
		GeoItemRenderer.registerItemRenderer(ModItems.golden_gauntlet, new GoldenGauntletRenderer("golden"));
		GeoItemRenderer.registerItemRenderer(ModItems.sculk_gauntlet, new GoldenGauntletRenderer("golden"));
		GeoItemRenderer.registerItemRenderer(ModItems.amethyst_gauntlet, new GoldenGauntletRenderer("golden"));
		GeoItemRenderer.registerItemRenderer(ModItems.fnuuy_gauntlet, new GoldenGauntletRenderer("fnuuy"));
		// Cosmetics
		GeoItemRenderer.registerItemRenderer(ModItems.tophat, new TopHatRenderer());

		// Render Item
		TrinketRendererRegistry.registerRenderer(ModItems.gas_mask,
				(stack, slotReference, contextModel, matrices, vertexConsumers, light, entity, limbAngle, limbDistance, tickDelta, animationProgress, headYaw, headPitch) -> {
					if (entity instanceof AbstractClientPlayerEntity player) {
						TrinketRenderer.translateToFace(matrices,
								(PlayerEntityModel<AbstractClientPlayerEntity>) contextModel, player, headYaw, headPitch);
						matrices.scale(0.62F, 0.62F, 0.62F);
						matrices.translate(0, -0.02, 0.5F);
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
						MinecraftClient.getInstance().getItemRenderer()
								.renderItem(stack, ModelTransformation.Mode.THIRD_PERSON_LEFT_HAND, light, OverlayTexture.DEFAULT_UV, matrices,
										vertexConsumers, 0);
					}
				});
		TrinketRendererRegistry.registerRenderer(ModItems.golden_gauntlet,
				(stack, slotReference, contextModel, matrices, vertexConsumers, light, entity, limbAngle, limbDistance, tickDelta, animationProgress, headYaw, headPitch) -> {
					if (entity instanceof AbstractClientPlayerEntity player) {
						TrinketRenderer.translateToLeftArm(matrices,
								(PlayerEntityModel<AbstractClientPlayerEntity>) contextModel, player);
						matrices.scale(1F, 1F, 1F);
						matrices.translate(0, 0, -0.128);
						matrices.multiply(new Quaternion(-90, 180, 0, true));
						MinecraftClient.getInstance().getItemRenderer()
								.renderItem(stack, ModelTransformation.Mode.THIRD_PERSON_LEFT_HAND, light, OverlayTexture.DEFAULT_UV, matrices,
										vertexConsumers, 0);
					}
				});
		TrinketRendererRegistry.registerRenderer(ModItems.sculk_gauntlet,
				(stack, slotReference, contextModel, matrices, vertexConsumers, light, entity, limbAngle, limbDistance, tickDelta, animationProgress, headYaw, headPitch) -> {
					if (entity instanceof AbstractClientPlayerEntity player) {
						TrinketRenderer.translateToLeftArm(matrices,
								(PlayerEntityModel<AbstractClientPlayerEntity>) contextModel, player);
						matrices.scale(1F, 1F, 1F);
						matrices.translate(0, 0, -0.128);
						matrices.multiply(new Quaternion(-90, 180, 0, true));
						MinecraftClient.getInstance().getItemRenderer()
								.renderItem(stack, ModelTransformation.Mode.THIRD_PERSON_LEFT_HAND, light, OverlayTexture.DEFAULT_UV, matrices,
										vertexConsumers, 0);
					}
				});
		TrinketRendererRegistry.registerRenderer(ModItems.amethyst_gauntlet,
				(stack, slotReference, contextModel, matrices, vertexConsumers, light, entity, limbAngle, limbDistance, tickDelta, animationProgress, headYaw, headPitch) -> {
					if (entity instanceof AbstractClientPlayerEntity player) {
						TrinketRenderer.translateToLeftArm(matrices,
								(PlayerEntityModel<AbstractClientPlayerEntity>) contextModel, player);
						matrices.scale(1F, 1F, 1F);
						matrices.translate(0, 0, -0.128);
						matrices.multiply(new Quaternion(-90, 180, 0, true));
						MinecraftClient.getInstance().getItemRenderer()
								.renderItem(stack, ModelTransformation.Mode.THIRD_PERSON_LEFT_HAND, light, OverlayTexture.DEFAULT_UV, matrices,
										vertexConsumers, 0);
					}
				});
		TrinketRendererRegistry.registerRenderer(ModItems.fnuuy_gauntlet,
				(stack, slotReference, contextModel, matrices, vertexConsumers, light, entity, limbAngle, limbDistance, tickDelta, animationProgress, headYaw, headPitch) -> {
					if (entity instanceof AbstractClientPlayerEntity player) {
						TrinketRenderer.translateToLeftArm(matrices,
								(PlayerEntityModel<AbstractClientPlayerEntity>) contextModel, player);
						matrices.scale(1F, 1F, 1F);
						matrices.translate(0, 0, -0.128);
						matrices.multiply(new Quaternion(-90, 180, 0, true));
						MinecraftClient.getInstance().getItemRenderer()
								.renderItem(stack, ModelTransformation.Mode.THIRD_PERSON_LEFT_HAND, light, OverlayTexture.DEFAULT_UV, matrices,
										vertexConsumers, 0);
					}
				});

		// Cosmetics
		TrinketRendererRegistry.registerRenderer(ModItems.tophat,
				(stack, slotReference, contextModel, matrices, vertexConsumers, light, entity, limbAngle, limbDistance, tickDelta, animationProgress, headYaw, headPitch) -> {
					if (entity instanceof AbstractClientPlayerEntity player) {
						TrinketRenderer.translateToFace(matrices,
								(PlayerEntityModel<AbstractClientPlayerEntity>) contextModel, player, headYaw, headPitch);
						matrices.multiply(new Quaternion(0, 0, 180, true));
						matrices.scale(0.75F, 0.75F, 0.75F);
						matrices.translate(0, -0.05, 0.4);
						MinecraftClient.getInstance().getItemRenderer()
								.renderItem(stack, ModelTransformation.Mode.HEAD, light, OverlayTexture.DEFAULT_UV, matrices,
										vertexConsumers, 0);
					}
				});
	}
}
