package io.github.cheesecurd.wwtrinkets.Items;

import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;

public class ModArmorMaterials
{
	public static final ArmorMaterial HAZMAT = new ModArmorMaterial(45,
			new int[] {2, 4, 3, 2},
			new int[] {2, 3, 4, 2},
			0,
			"hazmat",
			SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
			0,
			0,
			Items.DRIED_KELP);
	public static final ArmorMaterial COLDHAZMAT = new FrostArmorMaterial(45,
			new int[] {2, 4, 3, 2},
			new int[] {2, 3, 4, 2},
			0,
			"coldhazmat",
			SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
			0,
			0,
			Items.DRIED_KELP,
			new double[] {.9, .9, .9, .9});
}
