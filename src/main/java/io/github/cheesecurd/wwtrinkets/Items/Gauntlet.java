package io.github.cheesecurd.wwtrinkets.Items;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;

import java.util.List;
import java.util.UUID;

public class Gauntlet extends CosmeticTrinketItem {
	private final String crystal;

	public Gauntlet(String crystal, Settings settings)
	{
		super(settings);
		this.crystal = crystal;
	}

	@Override
	public void tick(ItemStack stack, SlotReference slot, LivingEntity entity)
	{
		switch (crystal)
		{
			case "sculk":
				entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 2, 0, true, false, false));
				entity.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 2, 0, true, false, false));
				entity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 2, 1, true, false, false));
				break;
			case "amethyst":
				entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 2, 1, true, false, false));
				break;
		}
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		switch (crystal)
		{
			case "sculk":
				tooltip.add(Text.literal("§5§oPerfectly balanced."));
				tooltip.add(Text.literal("§k------------------"));
				tooltip.add(Text.literal("§8§l•§c§l§o [-]§c The Sculk begin to take over your sight"));
				tooltip.add(Text.literal("§8§l•§a§l§o [+]§a You gain the strength of The Warden"));
				break;
			case "amethyst":
				tooltip.add(Text.literal("§5§o???"));
				tooltip.add(Text.literal("§k---"));
				tooltip.add(Text.literal("You are not strong enough to use this gem yet..."));
				tooltip.add(Text.literal("§8§l•§c§l§o [-]§c You feel slower than usual... It's probably nothing.. Right?"));
				break;
			case "fnuuy":
				tooltip.add(Text.literal("§5§oHow did you get this?"));
				tooltip.add(Text.literal("§k---------------------"));
				tooltip.add(Text.literal("§8§l•§r§l§o [=]§r How did you get this?"));
				tooltip.add(Text.literal("§8§l•§r§l§o [=]§r Why did you get this?"));
				tooltip.add(Text.literal("§8§l•§c§l§o [-]§c This does nothing."));
				break;
			default:
				tooltip.add(Text.literal("§5§oA powerless Gauntlet.... If only it had a gem."));
		}
	}
}
