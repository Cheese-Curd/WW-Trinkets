package io.github.cheesecurd.wwtrinkets.Items;

import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;

public class ModArmorMaterials
{
	public static final ModArmorMaterial HAZMAT = new ModArmorMaterial(20,
			new int[] {1, 3, 2, 1},
			new int[] {1, 1, 1, 1},
			0,
			"hazmat",
			SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
			0,
			0,
			Items.DRIED_KELP);
}
