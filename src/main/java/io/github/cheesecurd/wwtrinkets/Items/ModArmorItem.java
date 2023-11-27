package io.github.cheesecurd.wwtrinkets.Items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ModArmorItem extends ArmorItem
{
	public ModArmorItem(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
		super(material, slot, settings);
	}

	@Override
	public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected)
	{
		super.inventoryTick(stack, world, entity, slot, selected);
	}

	public boolean hasFullSuitOfArmorOn(PlayerEntity player) {
		ItemStack boots = player.getInventory().getArmorStack(0);
		ItemStack leggings = player.getInventory().getArmorStack(1);
		ItemStack chestplate = player.getInventory().getArmorStack(2);
		ItemStack helmet = player.getInventory().getArmorStack(3);

		return !helmet.isEmpty() && !chestplate.isEmpty()
				&& !leggings.isEmpty() && !boots.isEmpty();
	}

	private boolean hasCorrectArmorOn(ArmorMaterial material, PlayerEntity player) {
		for (ItemStack armorStack: player.getInventory().armor) {
			if(!(armorStack.getItem() instanceof ArmorItem)) {
				return false;
			}
		}

		ArmorItem boots = ((ArmorItem)player.getInventory().getArmorStack(0).getItem());
		ArmorItem leggings = ((ArmorItem)player.getInventory().getArmorStack(1).getItem());
		ArmorItem breastplate = ((ArmorItem)player.getInventory().getArmorStack(2).getItem());
		ArmorItem helmet = ((ArmorItem)player.getInventory().getArmorStack(3).getItem());

		return helmet.getMaterial() == material && breastplate.getMaterial() == material &&
				leggings.getMaterial() == material && boots.getMaterial() == material;
	}
}