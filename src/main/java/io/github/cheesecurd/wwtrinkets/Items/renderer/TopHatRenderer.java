package io.github.cheesecurd.wwtrinkets.Items.renderer;

import io.github.cheesecurd.wwtrinkets.Items.TopHatItem;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class TopHatRenderer extends GeoItemRenderer<TopHatItem> {
	public TopHatRenderer() {
		super(new TopHatModel());
	}
}