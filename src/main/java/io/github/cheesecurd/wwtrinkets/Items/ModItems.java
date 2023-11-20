package io.github.cheesecurd.wwtrinkets.Items;

import dev.emi.trinkets.api.client.TrinketRenderer;
import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import io.github.cheesecurd.wwtrinkets.WWTrinkets;
import io.github.cheesecurd.wwtrinkets.effects.ModEffects;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.Item;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems
{
	public static Item createItem(String itemName, Item item)
	{
		return Registry.register(Registry.ITEM, new Identifier("wwtrinkets", itemName), item);
	}

	// Gas Mask Stuff
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
