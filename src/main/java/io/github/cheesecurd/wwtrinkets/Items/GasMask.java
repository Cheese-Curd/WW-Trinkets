package io.github.cheesecurd.wwtrinkets.Items;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import net.minecraft.client.MinecraftClient;
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

public class GasMask extends CosmeticTrinketItem
{
	private MinecraftClient client = MinecraftClient.getInstance();

	public GasMask(Settings settings) {
		super(settings);
	}

	@Override
	public void tick(ItemStack stack, SlotReference slot, LivingEntity entity)
	{
		entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 2, 255, true, false, false));
	}

	@Override
	public void onEquip(ItemStack stack, SlotReference slot, LivingEntity entity)
	{
		entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 600, 0, true, false, false));
		super.onEquip(stack, slot, entity);
	}

	public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid)
	{
		var modifiers = super.getModifiers(stack, slot, entity, uuid);
		// Upsides
		modifiers.put(EntityAttributes.GENERIC_MOVEMENT_SPEED, new EntityAttributeModifier(uuid, "wwtrinkets:extra_health", .15, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
		modifiers.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(uuid, "wwtrinkets:extra_health", .15, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
		return modifiers;
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context)
	{
		tooltip.add(Text.literal("§d§oDon't keep it on for too long! You might start to believe fresh air is §2§o§ka§a§l§otoxic§2§l§o§ka§d§o..."));
		tooltip.add(Text.literal("§k-------------------------------------------------------------------------------"));
		tooltip.add(Text.literal("§8§l•§c§l§o [-]§c Your breathing blocks your sight"));
		tooltip.add(Text.literal("§8§l•§a§l§o [+]§a You become faster in more way than one"));
		tooltip.add(Text.literal("§8§l•§a§l§o [+]§a You do not feel the need to eat for a short time"));
	}
}
