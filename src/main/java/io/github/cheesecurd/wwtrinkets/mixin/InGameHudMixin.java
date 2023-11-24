package io.github.cheesecurd.wwtrinkets.mixin;

import io.github.cheesecurd.wwtrinkets.Items.GasMask;
import io.github.cheesecurd.wwtrinkets.Items.ModItems;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
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
	@Shadow
	private void renderOverlay(Identifier texture, float opacity) {};

	@Shadow @Final private MinecraftClient client;
	private static final Identifier GASMASK = new Identifier("wwtrinkets", "textures/overlays/gasmask.png");

	@Inject(method = "render", at = @At("TAIL"))
	public void render(MatrixStack matrices, float tickDelta, CallbackInfo ci)
	{
		// Is the Gas Mask on the Player's face?
		if (client.options.getPerspective().isFirstPerson())
		{
			// TODO: Check if Gas Mask is equipped
//			if (GasMask.isEquipped())
//				renderOverlay(GASMASK, 1.0F);
		}
	}
}
