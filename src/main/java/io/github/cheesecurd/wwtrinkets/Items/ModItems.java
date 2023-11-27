package io.github.cheesecurd.wwtrinkets.Items;

import io.github.cheesecurd.wwtrinkets.WWTrinkets;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems
{
	public static Item createItem(String itemName, Item item)
	{
		return Registry.register(Registry.ITEM, new Identifier("wwtrinkets", itemName), item);
	}

	// Gas Mask
	public static final Item gas_mask = createItem("gas_mask",
			new GasMask(new FabricItemSettings()
					.group(WWTrinkets.TAB)
					.maxCount(1)));

	public static final Item air_filter = createItem("air_filter",
			new Item(new FabricItemSettings()
					.group(WWTrinkets.TAB)));

	public static final Item amethyst_ingot = createItem("amethyst_ingot",
			new Item(new FabricItemSettings()
					.group(WWTrinkets.TAB)));

	public static final Item lens = createItem("lens",
			new Item(new FabricItemSettings()
					.group(WWTrinkets.TAB)));

	public static final Item side_filter = createItem("side_filter",
			new Item(new FabricItemSettings()
					.group(WWTrinkets.TAB)));

	// Hazmat Suit
	// Looks like shit
	public static final Item hazmat_hood = createItem("hazmat_hood",
			new HazMatSuitItem(ModArmorMaterials.HAZMAT, EquipmentSlot.HEAD,
					new FabricItemSettings()
							.group(WWTrinkets.TAB)
							.maxCount(1)));
	public static final Item hazmat_suit = createItem("hazmat_suit",
			new HazMatSuitItem(ModArmorMaterials.HAZMAT, EquipmentSlot.CHEST,
					new FabricItemSettings()
							.group(WWTrinkets.TAB)
							.maxCount(1)));
	public static final Item hazmat_pants = createItem("hazmat_pants",
			new HazMatSuitItem(ModArmorMaterials.HAZMAT, EquipmentSlot.LEGS,
					new FabricItemSettings()
							.group(WWTrinkets.TAB)
							.maxCount(1)));
	public static final Item hazmat_boots = createItem("hazmat_boots",
			new HazMatSuitItem(ModArmorMaterials.HAZMAT, EquipmentSlot.FEET,
					new FabricItemSettings()
							.group(WWTrinkets.TAB)
							.maxCount(1)));

	// Cursed Ring of The Aesir
	public static final Item zumo_ring = createItem("zumo_ring",
			new ZumoRing(new FabricItemSettings()
					.group(WWTrinkets.TAB)
					.maxCount(1)));

	public static final Item cursed_gem = createItem("cursed_gem",
			new Item(new FabricItemSettings()
					.group(WWTrinkets.TAB)));

	// Golden Gauntlet
	public static final Item golden_gauntlet = createItem("golden_gauntlet",
			new Gauntlet(new FabricItemSettings()
					.group(WWTrinkets.TAB)
					.maxCount(1)));

	public static final Item amethyst_gem = createItem("amethyst_gem",
			new Item(new FabricItemSettings()
					.group(WWTrinkets.TAB)));

	public static final Item sculk_gem = createItem("sculk_gem",
			new Item(new FabricItemSettings()
					.group(WWTrinkets.TAB)));

	// Cosmetics
	// Fuck off, why are you giving me a speed boost
	public static final Item tophat = createItem("tophat",
			new TopHatItem(new FabricItemSettings()
					.group(WWTrinkets.TAB)
					.maxCount(1)));

	public static void registerItems() {}
}
