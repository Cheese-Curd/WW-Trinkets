package io.github.cheesecurd.wwtrinkets.Items.renderer;

import io.github.cheesecurd.wwtrinkets.Items.TopHatItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class TopHatModel extends AnimatedGeoModel<TopHatItem> {
	@Override
	public Identifier getModelResource(TopHatItem object) {
		return new Identifier("wwtrikets", "geo/tophat.geo.json");
	}

	@Override
	public Identifier getTextureResource(TopHatItem object) {
		return new Identifier("wwtrikets", "textures/item/tophat.png");
	}

	@Override
	public Identifier getAnimationResource(TopHatItem animatable) {
		return new Identifier("wwtrikets", "animations/dummy.json");
	}
}