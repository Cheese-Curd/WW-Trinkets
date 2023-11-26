package io.github.cheesecurd.wwtrinkets.Items;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketEnums;
import dev.emi.trinkets.api.TrinketItem;
import io.github.cheesecurd.wwtrinkets.WWTrinkets;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class Gauntlet extends TrinketItem
{
	public Gauntlet(Settings settings)
	{
		super(settings);
	}

	@Override
	public void tick(ItemStack stack, SlotReference slot, LivingEntity entity)
	{
		if (stack.hasNbt())
		{
			var crystal = stack.getNbt().getString("crystal");
			switch (crystal)
			{
				case "sculk":
					entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 2, 0, true, false, false));
					entity.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 2, 0, true, false, false));
					entity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 2, 1, true, false, false));
					break;
			}
		}

	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		if (stack.hasNbt())
		{
			var crystal = stack.getNbt().getString("crystal");
			switch (crystal)
			{
				case "sculk":
					tooltip.add(Text.literal("§5§oPerfectly balanced."));
					tooltip.add(Text.literal("§k------------------"));
					tooltip.add(Text.literal("§8§l•§c§l§o [-]§c The Sculk begin to take over your sight"));
					tooltip.add(Text.literal("§8§l•§a§l§o [+]§a You gain the strength of The Warden"));
					break;
				default:
					tooltip.add(Text.literal("§5§oHow did you get this?"));
					tooltip.add(Text.literal("§k---------------------"));
					tooltip.add(Text.literal("§8§l•§r§l§o [=]§r How did you get this?"));
					tooltip.add(Text.literal("§8§l•§r§l§o [=]§r Why did you get this?"));
					tooltip.add(Text.literal("§8§l•§c§l§o [-]§c This does nothing."));
			}
		}
		else
			tooltip.add(Text.literal("§5§oA powerless Gauntlet.... If only it had a gem."));
//		tooltip.add(Text.literal("§k-----------------------------------------------------------"));
//		tooltip.add(Text.literal("§aRemain undetected from §3§l§oSculk§f but also§c remain in constant §8§l§oDarkness"));
	}
}
