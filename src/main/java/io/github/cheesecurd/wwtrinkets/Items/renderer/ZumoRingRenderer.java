package io.github.cheesecurd.wwtrinkets.Items.renderer;

import io.github.cheesecurd.wwtrinkets.Items.ZumoRing;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class ZumoRingRenderer extends GeoItemRenderer<ZumoRing> {
	public ZumoRingRenderer() {
		super(new ZumoRingModel());
	}
}