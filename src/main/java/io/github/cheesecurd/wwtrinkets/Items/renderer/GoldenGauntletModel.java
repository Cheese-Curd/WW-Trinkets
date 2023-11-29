package io.github.cheesecurd.wwtrinkets.Items.renderer;

import io.github.cheesecurd.wwtrinkets.Items.Gauntlet;
import io.github.cheesecurd.wwtrinkets.Items.HazMatSuitItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GoldenGauntletModel extends AnimatedGeoModel<Gauntlet>
{
	private String texture;
	public GoldenGauntletModel(String texture)
	{
		this.texture = texture;
	}

	@Override
	public Identifier getModelResource(Gauntlet object) {
		return new Identifier("wwtrinkets", String.format("geo/%s_gauntlet.png", texture));
	}

	@Override
	public Identifier getTextureResource(Gauntlet object) {
		return new Identifier("wwtrinkets", String.format("textures/%s_gauntlet.png", texture));
	}

	@Override
	public Identifier getAnimationResource(Gauntlet animatable) {
		return new Identifier("wwtrinkets", "animations/dummy.json");
	}
}
