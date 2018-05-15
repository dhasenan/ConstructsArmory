/*
 * Copyright (c) 2018 <C4>
 *
 * This Java class is distributed as a part of the Construct's Armory mod.
 * Construct's Armory is open source and distributed under the GNU General Public License v3.
 * View the source code and license file on github: https://github.com/TheIllusiveC4/ConstructsArmory
 */

package c4.conarm.integrations.crafttweaker.materials;

import slimeknights.tconstruct.library.materials.Material;

public class ConArmMatDefinition implements IConArmMatDefinition {

    private final Material material;

    public ConArmMatDefinition(Material material) {
        this.material = material;
    }

    @Override
    public IConArmMaterial asMaterial() {
        return new ConArmMaterial(material);
    }

    @Override
    public String getName() {
        return material.getLocalizedName();
    }

    @Override
    public String getDisplayName() {
        return material.getLocalizedName();
    }
}
