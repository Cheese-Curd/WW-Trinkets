package io.github.cheesecurd.wwtrinkets.Items.renderer.armor;

import io.github.cheesecurd.wwtrinkets.Items.ColdHazMatSuitItem;
import io.github.cheesecurd.wwtrinkets.Items.HazMatSuitItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ColdHazMatSuitModel extends AnimatedGeoModel<ColdHazMatSuitItem>
{
	@Override
	public Identifier getModelResource(ColdHazMatSuitItem object) {
		return new Identifier("wwtrinkets", "geo/coldhazmat_suit.geo.json");
	}

	@Override
	public Identifier getTextureResource(ColdHazMatSuitItem object) {
		return new Identifier("wwtrinkets", "textures/armor/coldhazmat_suit.png");
	}

	@Override
	public Identifier getAnimationResource(ColdHazMatSuitItem animatable) {
		return new Identifier("wwtrinkets", "animations/dummy.json");
	}
}
