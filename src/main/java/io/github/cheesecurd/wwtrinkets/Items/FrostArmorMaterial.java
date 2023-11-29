package io.github.cheesecurd.wwtrinkets.Items;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;

public class FrostArmorMaterial implements ArmorMaterial
{
	private final int[] BASE_DURABILITY;
	private final int[] PROTECTION_VALUES;
	private final String name;
	private final int durabilityMult;
	private final int enchantability;
	private final SoundEvent equipSound;
	private final float toughness;
	private final float knockbackResistance;
	private final Item repairIngredient;
	private final double[] frostResistance;

	public FrostArmorMaterial(int durabilityMult, int[] BASE_DURABILITY, int[] PROTECTION_VALUES, int enchantability, String name, SoundEvent equipSound, float toughness, float knockbackResistance, Item repairIngredient, double[] frostResistance)
	{
		this.BASE_DURABILITY = BASE_DURABILITY;
		this.PROTECTION_VALUES = PROTECTION_VALUES;
		this.durabilityMult = durabilityMult;
		this.name = name;
		this.enchantability = enchantability;
		this.equipSound = equipSound;
		this.toughness = toughness;
		this.knockbackResistance = knockbackResistance;
		this.repairIngredient = repairIngredient;
		this.frostResistance = frostResistance;
	}

	@Override
	public int getDurability(EquipmentSlot slot) {
		return BASE_DURABILITY[slot.getEntitySlotId()] * durabilityMult;
	}

	@Override
	public int getProtectionAmount(EquipmentSlot slot) {
		return PROTECTION_VALUES[slot.getEntitySlotId()];
	}

	@Override
	public int getEnchantability() {
		return enchantability;
	}

	@Override
	public SoundEvent getEquipSound() {
		return equipSound;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(repairIngredient);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public float getToughness() {
		return toughness;
	}

	@Override
	public float getKnockbackResistance() {
		return knockbackResistance;
	}

	public double getFrostResistance(EquipmentSlot slot)
	{
		return frostResistance[slot.getEntitySlotId()];
	}
}
