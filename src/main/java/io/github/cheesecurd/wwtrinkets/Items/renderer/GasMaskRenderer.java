package io.github.cheesecurd.wwtrinkets.Items.renderer;

import io.github.cheesecurd.wwtrinkets.Items.GasMask;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class GasMaskRenderer extends GeoItemRenderer<GasMask> {
	public GasMaskRenderer() {
		super(new GasMaskModel());
	}
}