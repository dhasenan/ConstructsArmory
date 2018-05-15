/*
 * Copyright (c) 2018 <C4>
 *
 * This Java class is distributed as a part of the Construct's Armory mod.
 * Construct's Armory is open source and distributed under the GNU General Public License v3.
 * View the source code and license file on github: https://github.com/TheIllusiveC4/ConstructsArmory
 */

package c4.conarm.common.armor.traits;

import c4.conarm.lib.traits.AbstractArmorTrait;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class TraitSubterranean extends AbstractArmorTrait {

    public TraitSubterranean() {
        super("subterranean", TextFormatting.DARK_GRAY);
    }

    @Override
    public int onArmorDamage(ItemStack armor, DamageSource source, int damage, int newDamage, EntityPlayer player, int slot) {
        World world = player.getEntityWorld();
        double belowSea = world.getSeaLevel() - player.posY;
        if (belowSea > 0) {
            if (random.nextFloat() < belowSea / 100) {
                return 0;
            } else {
                return newDamage;
            }
        }
        return super.onArmorDamage(armor, source, damage, newDamage, player, slot);
    }
}
