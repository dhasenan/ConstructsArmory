/*
 * Copyright (c) 2018 <C4>
 *
 * This Java class is distributed as a part of the Construct's Armory mod.
 * Construct's Armory is open source and distributed under the GNU General Public License v3.
 * View the source code and license file on github: https://github.com/TheIllusiveC4/ConstructsArmory
 */

package c4.conarm.lib.book.sectiontransformers;

import c4.conarm.lib.book.content.ContentArmorMaterial;
import c4.conarm.lib.materials.ArmorMaterialType;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.mantle.client.book.data.content.PageContent;
import slimeknights.tconstruct.library.book.sectiontransformer.AbstractMaterialSectionTransformer;
import slimeknights.tconstruct.library.materials.Material;

@SideOnly(Side.CLIENT)
public class ArmorMaterialSectionTransformer extends AbstractMaterialSectionTransformer {

    public ArmorMaterialSectionTransformer() {
        super("materials");
    }

    @Override
    protected boolean isValidMaterial(Material material) {
        return material.hasStats(ArmorMaterialType.CORE) || material.hasStats(ArmorMaterialType.PLATES) || material.hasStats(ArmorMaterialType.TRIM);
    }

    @Override
    protected PageContent getPageContent(Material material) {
        return new ContentArmorMaterial(material);
    }
}
