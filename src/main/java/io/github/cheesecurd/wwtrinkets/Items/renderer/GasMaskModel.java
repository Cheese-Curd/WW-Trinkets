package io.github.cheesecurd.wwtrinkets.Items.renderer;

import io.github.cheesecurd.wwtrinkets.Items.GasMask;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class GasMaskModel extends AnimatedGeoModel<GasMask> {
	@Override
	public Identifier getModelResource(GasMask object) {
		return new Identifier("wwtrikets", "geckolib/gas_mask.geo.json");
	}

	@Override
	public Identifier getTextureResource(GasMask object) {
		return new Identifier("wwtrikets", "textures/item/gasmask.png");
	}

	@Override
	public Identifier getAnimationResource(GasMask animatable) {
		return new Identifier("wwtrikets", "animations/gas_mask.animation.json");
	}
}