package io.github.cheesecurd.wwtrinkets.Items.renderer.armor;

import io.github.cheesecurd.wwtrinkets.Items.HazMatSuitItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class HazMatSuitModel extends AnimatedGeoModel<HazMatSuitItem>
{
	@Override
	public Identifier getModelResource(HazMatSuitItem object) {
		return new Identifier("wwtrinkets", "geckolib/hazmat_suit.geo.json");
	}

	@Override
	public Identifier getTextureResource(HazMatSuitItem object) {
		return new Identifier("wwtrinkets", "textures/armor/hazMatSuit.png");
	}

	@Override
	public Identifier getAnimationResource(HazMatSuitItem animatable) {
		return new Identifier("wwtrinkets", "animations/dummy.json");
	}
}
