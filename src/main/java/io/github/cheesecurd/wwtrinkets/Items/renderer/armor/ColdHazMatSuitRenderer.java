package io.github.cheesecurd.wwtrinkets.Items.renderer.armor;

import io.github.cheesecurd.wwtrinkets.Items.ColdHazMatSuitItem;
import io.github.cheesecurd.wwtrinkets.Items.HazMatSuitItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class ColdHazMatSuitRenderer extends GeoArmorRenderer<ColdHazMatSuitItem>
{
	public ColdHazMatSuitRenderer()
	{
		super(new ColdHazMatSuitModel());

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
