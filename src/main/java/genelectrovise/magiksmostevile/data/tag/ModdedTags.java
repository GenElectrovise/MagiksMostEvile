/*******************************************************************************
 * Magiks Most Evile Copyright (c) 2020, 2021 GenElectrovise    
 *
 * This file is part of Magiks Most Evile.
 * Magiks Most Evile is free software: you can redistribute it and/or modify it under the terms 
 * of the GNU General Public License as published by the Free Software Foundation, 
 * either version 3 of the License, or (at your option) any later version.
 *
 * Magiks Most Evile is distributed in the hope that it will be useful, but WITHOUT 
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or 
 * FITNESS FOR A PARTICULAR PURPOSE.  
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with Magiks Most Evile. 
 * If not, see <https://www.gnu.org/licenses/>.
 *******************************************************************************/
package genelectrovise.magiksmostevile.data.tag;

import genelectrovise.magiksmostevile.core.MagiksMostEvile;
import net.minecraft.block.Block;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.util.ResourceLocation;

public class ModdedTags {
  public static final ITag<Block> AMETHYST_ORE_SPAWNABLE = BlockTags.makeWrapperTag(new ResourceLocation(MagiksMostEvile.MODID, "amethyst_ore_spawnable").toString());
  public static final ITag<Block> LEAD_ORE_SPAWNABLE = BlockTags.makeWrapperTag(new ResourceLocation(MagiksMostEvile.MODID, "lead_ore_spawnable").toString());
}

