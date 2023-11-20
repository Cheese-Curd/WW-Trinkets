package io.github.cheesecurd.wwtrinkets.client;

import dev.emi.trinkets.api.client.TrinketRenderer;
import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import io.github.cheesecurd.wwtrinkets.Items.ModItems;
import io.github.cheesecurd.wwtrinkets.Items.renderer.GasMaskRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.render.model.json.ModelTransformation;
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

		// Render Item
		TrinketRendererRegistry.registerRenderer(ModItems.gas_mask,
				(stack, slotReference, contextModel, matrices, vertexConsumers, light, entity, limbAngle, limbDistance, tickDelta, animationProgress, headYaw, headPitch) -> {
					if (entity instanceof AbstractClientPlayerEntity player) {
						TrinketRenderer.translateToFace(matrices,
								(PlayerEntityModel<AbstractClientPlayerEntity>) contextModel, player, headYaw, headPitch);
						matrices.scale(0.5F, 0.5F, 0.5F);
						matrices.translate(1.0F, -0.85F, 0.0F);
						MinecraftClient.getInstance().getItemRenderer()
								.renderItem(stack, ModelTransformation.Mode.HEAD, light, OverlayTexture.DEFAULT_UV, matrices,
										vertexConsumers, 0);
					}
				});
	}
}
