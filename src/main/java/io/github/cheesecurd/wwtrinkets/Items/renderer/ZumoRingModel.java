package io.github.cheesecurd.wwtrinkets.Items.renderer;

import io.github.cheesecurd.wwtrinkets.Items.GasMask;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ZumoRingModel extends AnimatedGeoModel<GasMask> {
	@Override
	public Identifier getModelResource(GasMask object) {
		return new Identifier("wwtrikets", "geckolib/zumo_ring.geo.json");
	}

	@Override
	public Identifier getTextureResource(GasMask object) {
		return new Identifier("wwtrikets", "textures/item/zumo_ring.png");
	}

	@Override
	public Identifier getAnimationResource(GasMask animatable) {
		return new Identifier("wwtrikets", "animations/zumo_ring.animation.json");
	}
}