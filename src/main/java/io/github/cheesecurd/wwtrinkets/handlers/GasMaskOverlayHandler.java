package io.github.cheesecurd.wwtrinkets.handlers;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class GasMaskOverlayHandler implements HudRenderCallback
{
	private static final Identifier GASMASKOVERLAY = new Identifier("wwtrinkets", "textures/overlays/gasmask.png");

	@Override
	public void onHudRender(MatrixStack matrixStack, float tickDelta)
	{
		MinecraftClient client = MinecraftClient.getInstance();

		int width = 0;
		int height = 0;
		if (client != null)
		{
			width = client.getWindow().getScaledWidth();
			height = client.getWindow().getScaledHeight();
		}

		RenderSystem.setShader(GameRenderer::getPositionShader);
		RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
		RenderSystem.setShaderTexture(0, GASMASKOVERLAY);

		DrawableHelper.drawTexture(matrixStack, 0, 0, 0, 0, width, height, 256, 256);
	}


}


