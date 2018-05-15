/*
 * Copyright (c) 2018 <C4>
 *
 * This Java class is distributed as a part of the Construct's Armory mod.
 * Construct's Armory is open source and distributed under the GNU General Public License v3.
 * View the source code and license file on github: https://github.com/TheIllusiveC4/ConstructsArmory
 */

package c4.conarm.common.armor.modifiers;

import c4.conarm.common.ConstructsRegistry;
import c4.conarm.lib.ArmoryRegistry;
import c4.conarm.lib.armor.ArmorCore;
import c4.conarm.lib.materials.ArmorMaterialType;
import c4.conarm.lib.modifiers.AccessoryModifier;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import net.minecraft.item.Item;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.library.tools.IToolPart;
import slimeknights.tconstruct.library.traits.ITrait;
import slimeknights.tconstruct.tools.TinkerModifiers;
import slimeknights.tconstruct.tools.modifiers.ModExtraTrait;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArmorModifiers {

//    public static Modifier modSilkstep = new ModSilkstep();
    public static Modifier modSpeedy = new ModSpeedy();
    public static Modifier modParasitic = new ModParasitic();
    public static Modifier modEmerald = new ModEmerald();
    public static Modifier modDiamond = new ModDiamond();
//    public static Modifier modSticky = new ModSticky();
    public static Modifier modShulkerweight = new ModShulkerweight();
    public static Modifier modMending = new ModMending();
    public static Modifier modFireResist = new ModFireResistant();
    public static Modifier modProjResist = new ModProjectileResistant();
    public static Modifier modBlastResist = new ModBlastResistant();
    public static Modifier modResist = new ModResistant();
    public static Modifier modReinforced = new ModReinforced();
    public static Modifier modSoulbound = new ModSoulbound();
    public static Modifier modPolished = new ModPolishedDisplay();
    public static Modifier modExtraTrait = new ModExtraArmorTraitDisplay();

    public static AccessoryModifier modTravelBelt = new ModTravelBelt();
    public static AccessoryModifier modTravelSack = new ModTravelSack();
    public static AccessoryModifier modTravelGoggles = new ModTravelGoggles();
//    public static Modifier modFrostStep = new ModFrostStep();
//    public static Modifier modMagmaStep = new ModMagmaStep();
//    public static Modifier modArthopodWard = new ModAntiMonsterResistance("arthopod_ward", 0x61ba49, 5, 24, EnumCreatureAttribute.ARTHROPOD);
//    public static Modifier modHolyWard = new ModAntiMonsterResistance("holy_ward", 0xe8d500, 5, 24, EnumCreatureAttribute.UNDEAD);

    static List<Modifier> polishedMods;
    static List<Modifier> extraTraitMods;

    public static void setupModifiers() {

//        ArmoryRegistry.registerModifier(modSilkstep);
//        modSilkstep.addItem(TinkerCommons.matSilkyJewel, 2, 1);

//        ArmoryRegistry.registerModifier(modSticky);
//        modSticky.addItem(Blocks.WEB, 1);

        ArmoryRegistry.registerModifier(modSpeedy);
        modSpeedy.addItem(ConstructsRegistry.speedyKit);

        ArmoryRegistry.registerModifier(modParasitic);
        modParasitic.addItem(ConstructsRegistry.parasiticKit);

        ArmoryRegistry.registerModifier(modDiamond);
        modDiamond.addItem(ConstructsRegistry.diamondKit);

        ArmoryRegistry.registerModifier(modEmerald);
        modEmerald.addItem(ConstructsRegistry.emeraldKit);

        ArmoryRegistry.registerModifier(modSoulbound);
        modSoulbound.addItem(ConstructsRegistry.soulboundKit);

        ArmoryRegistry.registerModifier(modMending);
        modMending.addItem(ConstructsRegistry.mendingMossKit);

        ArmoryRegistry.registerModifier(modReinforced);
        modReinforced.addItem(ConstructsRegistry.reinforcementKit);

        ArmoryRegistry.registerModifier(modFireResist);
        modFireResist.addItem(ConstructsRegistry.fireResistKit);

        ArmoryRegistry.registerModifier(modBlastResist);
        modBlastResist.addItem(ConstructsRegistry.blastResistKit);

        ArmoryRegistry.registerModifier(modProjResist);
        modProjResist.addItem(ConstructsRegistry.projResistKit);

        ArmoryRegistry.registerModifier(modResist);
        modResist.addItem(ConstructsRegistry.resistKit);

        ArmoryRegistry.registerModifier(modTravelBelt);
        modTravelBelt.addItem(ConstructsRegistry.travelBelt);

        ArmoryRegistry.registerModifier(modTravelSack);
        modTravelSack.addItem(ConstructsRegistry.travelSack);

        ArmoryRegistry.registerModifier(modTravelGoggles);
        modTravelGoggles.addItem(ConstructsRegistry.travelGoggles);

//        ArmoryRegistry.registerModifier(modFrostStep);
//        modFrostStep.addItem(Blocks.PACKED_ICE, 1);
//
//        ArmoryRegistry.registerModifier(modMagmaStep);
//        modMagmaStep.addItem(Blocks.MAGMA, 1);
//
//        ArmoryRegistry.registerModifier(modArthopodWard);
//        modArthopodWard.addItem(Items.FERMENTED_SPIDER_EYE);
//
//        ArmoryRegistry.registerModifier(modHolyWard);
//        modHolyWard.addItem(TinkerCommons.consecratedSoil, 1, 1);

        ArmoryRegistry.registerModifier(modPolished);
        ArmoryRegistry.registerModifier(modExtraTrait);
        ArmoryRegistry.registerModifier(TinkerModifiers.modCreative.getIdentifier(), TinkerModifiers.modCreative);
    }

    private static Map<String, ModExtraArmorTrait> extraTraitLookup = new HashMap<>();

    public static void registerPolishedModifiers() {
        polishedMods = Lists.newArrayList();
        for (Material mat : TinkerRegistry.getAllMaterialsWithStats(ArmorMaterialType.PLATES)) {
            ModPolished mod = new ModPolished(mat);
            polishedMods.add(mod);
            ArmoryRegistry.registerModifier(mod);
        }
    }

    public static void registerExtraTraitModifiers() {
        TinkerRegistry.getAllMaterials().forEach(ArmorModifiers::registerExtraTraitModifiers);
        extraTraitMods = Lists.newArrayList(extraTraitLookup.values());
        extraTraitMods.forEach(ArmoryRegistry::registerModifier);
    }

    private static void registerExtraTraitModifiers(Material material) {
        ArmoryRegistry.getArmor().forEach(armor -> registerExtraTraitModifiers(material, armor));
    }

    private static void registerExtraTraitModifiers(Material material, ArmorCore armor) {
        armor.getRequiredComponents().forEach(pmt -> registerExtraTraitModifiers(material, armor, pmt));
    }

    private static void registerExtraTraitModifiers(Material material, ArmorCore armor, PartMaterialType partMaterialType) {
        partMaterialType.getPossibleParts().forEach(part -> registerExtraTraitModifiers(material, armor, partMaterialType, part));
    }

    @SuppressWarnings("unchecked")
    private static <T extends Item & IToolPart> void registerExtraTraitModifiers(Material material, ArmorCore armor, PartMaterialType partMaterialType, IToolPart armorPart) {
        if(armorPart instanceof Item) {
            Collection<ITrait> traits = partMaterialType.getApplicableTraitsForMaterial(material);
            if(!traits.isEmpty()) {
                final Collection<ITrait> traits2 = ImmutableSet.copyOf(traits);
                String identifier = ModExtraTrait.generateIdentifier(material, traits2);
                ModExtraArmorTrait mod = extraTraitLookup.computeIfAbsent(identifier, id -> new ModExtraArmorTrait(material, traits2, identifier));
                mod.addCombination(armor, (T) armorPart);
            }
        }
    }
}
