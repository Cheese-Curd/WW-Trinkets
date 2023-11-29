package io.github.cheesecurd.wwtrinkets.Items.renderer;

import io.github.cheesecurd.wwtrinkets.Items.GasMask;
import io.github.cheesecurd.wwtrinkets.Items.Gauntlet;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class GoldenGauntletRenderer extends GeoItemRenderer<Gauntlet> {
	public GoldenGauntletRenderer(String texture)
	{
		super(new GoldenGauntletModel(texture));
	}
}