package c4.conarm.lib.utils;

import c4.conarm.armor.ArmorHelper;
import c4.conarm.lib.materials.CoreMaterialStats;
import c4.conarm.lib.materials.PlatesMaterialStats;
import c4.conarm.lib.modifiers.AccessoryModifier;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.Util;
import slimeknights.tconstruct.library.client.CustomFontColor;
import slimeknights.tconstruct.library.materials.AbstractMaterialStats;
import slimeknights.tconstruct.library.modifiers.IModifier;
import slimeknights.tconstruct.library.modifiers.ModifierNBT;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TooltipBuilder;

import java.util.ArrayList;
import java.util.List;

public class ArmorTooltipBuilder {

    public static TooltipBuilder addDefense(TooltipBuilder info, ItemStack stack) {

        info.add(CoreMaterialStats.formatDefense(ArmorHelper.getDefense(stack)));

        return info;
    }

    public static TooltipBuilder addToughness(TooltipBuilder info, ItemStack stack) {

        info.add(PlatesMaterialStats.formatToughness(ArmorHelper.getToughness(stack)));

        return info;
    }

    public static void addModifierTooltips(ItemStack stack, List<String> tooltips) {
        NBTTagList tagList = TagUtil.getModifiersTagList(stack);
        List<String> toAdd = new ArrayList<>();
        for(int i = 0; i < tagList.tagCount(); i++) {
            NBTTagCompound tag = tagList.getCompoundTagAt(i);
            ModifierNBT data = ModifierNBT.readTag(tag);
            IModifier modifier = TinkerRegistry.getModifier(data.identifier);
            if(modifier == null || modifier.isHidden()) {
                continue;
            }
            if(modifier instanceof AccessoryModifier) {
                tooltips.add(data.getColorString() + String.format(Util.translate("accessory.tooltip"), modifier.getTooltip(tag, false)));
                continue;
            }
            toAdd.add(data.getColorString() + modifier.getTooltip(tag, false));
        }
        tooltips.addAll(toAdd);
    }
}
