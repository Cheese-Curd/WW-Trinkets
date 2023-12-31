package io.github.cheesecurd.wwtrinkets.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import io.github.cheesecurd.wwtrinkets.Items.ModItems;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class InGameHudMixin
{
	private static final Identifier GASMASK = new Identifier("wwtrinkets", "textures/overlays/gasmask.png");

	@Shadow
	private void renderOverlay(Identifier texture, float opacity) {};

	@Shadow @Final private MinecraftClient client;

	@Inject(method = "render", at = @At("HEAD"))
	void beforeHudRender(MatrixStack matrices, float tickDelta, CallbackInfo ci)
	{
		RenderSystem.enableBlend();
		var width = client.getWindow().getScaledWidth();
		var height = client.getWindow().getScaledHeight();

		if (this.client.options.getPerspective().isFirstPerson()) {
			if (!this.client.player.isUsingSpyglass())
			{
				TrinketComponent comp = TrinketsApi.getTrinketComponent(client.player).get();
				if (comp.isEquipped(ModItems.gas_mask))
				{
					// Rending overlays are goofy
					RenderSystem.setShader(GameRenderer::getPositionTexShader);
					RenderSystem.setShaderColor(1,1, 1, 1);
					RenderSystem.setShaderTexture(0, GASMASK);
					DrawableHelper.drawTexture(matrices, 0, 0, 0, 0, width, height, width, height);
				}
			}
		}
	}
}
