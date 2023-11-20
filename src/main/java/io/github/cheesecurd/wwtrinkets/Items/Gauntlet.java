package io.github.cheesecurd.wwtrinkets.Items;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketEnums;
import dev.emi.trinkets.api.TrinketItem;
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
	public Gauntlet(Settings settings) {
		super(settings);
	}

	@Override
	public void tick(ItemStack stack, SlotReference slot, LivingEntity entity)
	{
		// Downsides
		entity.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 2, 2, true, false, false));
		// Upsides
		entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 2, 0, true, false, false));
		entity.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 2, 0, true, false, false));
	}

	public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid) {
		var modifiers = super.getModifiers(stack, slot, entity, uuid);
		// Downsides
		modifiers.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(uuid, "wwtrinkets:weakness", .75, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
		// Upsides
		modifiers.put(EntityAttributes.GENERIC_MAX_HEALTH, new EntityAttributeModifier(uuid, "wwtrinkets:extra_health", 20, EntityAttributeModifier.Operation.ADDITION));
		return modifiers;
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add(Text.literal("§5§oA powerless Gauntlet.... If only it had a gem."));
//		tooltip.add(Text.literal("§k-----------------------------------------------------------"));
//		tooltip.add(Text.literal("§aRemain undetected from §3§l§oSculk§f but also§c remain in constant §8§l§oDarkness"));
	}

	@Override // Stuck on ya forever!
	public boolean canUnequip(ItemStack stack, SlotReference slot, LivingEntity entity) {
		return false;
	}

	@Override // Really stuck on ya forever!
	public TrinketEnums.DropRule getDropRule(ItemStack stack, SlotReference slot, LivingEntity entity) {
		return TrinketEnums.DropRule.KEEP;
	}
}
