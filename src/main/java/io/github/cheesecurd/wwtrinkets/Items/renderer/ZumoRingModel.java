package io.github.cheesecurd.wwtrinkets.Items.renderer;

import io.github.cheesecurd.wwtrinkets.Items.ZumoRing;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ZumoRingModel extends AnimatedGeoModel<ZumoRing> {
	@Override
	public Identifier getModelResource(ZumoRing object) {
		return new Identifier("wwtrikets", "geo/zumo_ring.geo.json");
	}

	@Override
	public Identifier getTextureResource(ZumoRing object) {
		return new Identifier("wwtrikets", "textures/item/zumo_ring.png");
	}

	@Override
	public Identifier getAnimationResource(ZumoRing animatable) {
		return new Identifier("wwtrikets", "animations/dummy.json");
	}
}