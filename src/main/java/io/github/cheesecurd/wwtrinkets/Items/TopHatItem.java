package io.github.cheesecurd.wwtrinkets.Items;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class TopHatItem extends CosmeticTrinketItem
{
	public TopHatItem(Settings settings)
	{
		super(settings);
	}

	@Override // STOP GIVING ME A FUCKING SPEEDBOOST WTF
	public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid)
	{
		var modifiers = super.getModifiers(stack, slot, entity, uuid); // bro FUCK OFF
		return modifiers;
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context)
	{
		tooltip.add(Text.literal("...it's a top hat"));
	}
}
