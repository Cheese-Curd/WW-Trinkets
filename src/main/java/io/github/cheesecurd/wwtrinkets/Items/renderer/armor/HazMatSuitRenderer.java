package io.github.cheesecurd.wwtrinkets.Items.renderer.armor;

import io.github.cheesecurd.wwtrinkets.Items.HazMatSuitItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class HazMatSuitRenderer extends GeoArmorRenderer<HazMatSuitItem>
{
	public HazMatSuitRenderer()
	{
		super(new HazMatSuitModel());

		this.headBone = "armorHead";
		this.bodyBone = "armorBody";
		this.rightArmBone = "armorRightArm";
		this.leftArmBone = "armorLeftArm";
		this.rightLegBone = "armorLeftLeg";
		this.leftLegBone = "armorRightLeg";
		this.rightBootBone = "armorLeftBoot";
		this.leftBootBone = "armorRightBoot";
	}
}
