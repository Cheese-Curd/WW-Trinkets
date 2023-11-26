package io.github.cheesecurd.wwtrinkets.Items;

import io.github.cheesecurd.wwtrinkets.WWTrinkets;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
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

	public static void registerItems() {}
}
