package io.github.cheesecurd.wwtrinkets.handlers;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import io.github.cheesecurd.wwtrinkets.Items.ModItems;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class GasMaskOverlay implements HudRenderCallback
{
	private static final Identifier GASMASK = new Identifier("wwtrinkets", "textures/overlays/gasmask.png");

	// This goes over the hud, but this is as close to finished as this has been so far
	@Override
	public void onHudRender(MatrixStack matrixStack, float tickDelta) {
		MinecraftClient client = MinecraftClient.getInstance();

		if (client != null)
		{
			var width = client.getWindow().getScaledWidth();
			var height = client.getWindow().getScaledHeight();

			if (client.options.getPerspective().isFirstPerson()) {
				if (!client.player.isUsingSpyglass())
				{
					TrinketComponent comp = TrinketsApi.getTrinketComponent(client.player).get();
					if (comp.isEquipped(ModItems.gas_mask))
					{
						// Rending overlays are goofy
						RenderSystem.setShader(GameRenderer::getPositionTexShader);
						RenderSystem.setShaderColor(1,1, 1, 1);
						RenderSystem.setShaderTexture(0, GASMASK);
						DrawableHelper.drawTexture(matrixStack, 0, 0, 0, 0, width, height, width, height);
					}
				}
			}
		}
	}
}
