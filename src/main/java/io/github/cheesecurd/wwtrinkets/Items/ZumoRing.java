package io.github.cheesecurd.wwtrinkets.Items;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotAttributes;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketEnums;
import dev.emi.trinkets.api.TrinketItem;
import io.github.cheesecurd.wwtrinkets.effects.ModEffects;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class ZumoRing extends TrinketItem
{
	public ZumoRing(Settings settings) {
		super(settings);
	}

	@Override
	public void tick(ItemStack stack, SlotReference slot, LivingEntity entity)
	{
		// Downsides
		entity.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 2, 2, true, false, false));
		// Upsides
		entity.addStatusEffect(new StatusEffectInstance(ModEffects.FALL_DAMAGE, 2, 0, true, false, false));
		entity.addStatusEffect(new StatusEffectInstance(ModEffects.SUFFOCATION, 2, 0, true, false, false));
		entity.addStatusEffect(new StatusEffectInstance(ModEffects.STARVATION, 2, 0, true, false, false));
		entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 2, 0, true, false, false));
		entity.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 2, 0, true, false, false));
	}

	public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid) {
		var modifiers = super.getModifiers(stack, slot, entity, uuid);
		// Downsides
		modifiers.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(uuid, "wwtrinkets:weakness", -0.25, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));

		// Upsides
		modifiers.put(EntityAttributes.GENERIC_MAX_HEALTH, new EntityAttributeModifier(uuid, "wwtrinkets:extra_health", 20, EntityAttributeModifier.Operation.ADDITION));
		return modifiers;
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add(Text.literal("§d§oThe ancient ring of the Aesir Gods. It radiates with cursed energy..."));
		tooltip.add(Text.literal("§k-----------------------------------------------------------"));
		tooltip.add(Text.literal("§8§l•§c§l§o [-]§c The ring cannot be taken off§l It will persist with you forever"));
		tooltip.add(Text.literal("§8§l•§c§l§o [-]§c Monsters will receive decreased damage from the wearer"));
		tooltip.add(Text.literal("§8§l•§c§l§o [-]§c The wearer will find themselves more hungry than usual"));
		tooltip.add(Text.literal("§8§l•§a§l§o [+]§a 20 Extra Hit Points"));
		tooltip.add(Text.literal("§8§l•§a§l§o [+]§a Immunity to Suffocation"));
		tooltip.add(Text.literal("§8§l•§a§l§o [+]§a Immunity to Drowning"));
		tooltip.add(Text.literal("§8§l•§a§l§o [+]§a Immunity to Fire & Lava"));
		tooltip.add(Text.literal("§8§l•§a§l§o [+]§a Immunity to Starvation"));
		tooltip.add(Text.literal("§8§l•§a§l§o [+]§a Immunity to Fall Damage"));
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
