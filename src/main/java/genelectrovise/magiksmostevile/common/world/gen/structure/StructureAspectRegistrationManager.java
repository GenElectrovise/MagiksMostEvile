package genelectrovise.magiksmostevile.common.world.gen.structure;

import java.util.Locale;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.Structure;

/**
 * Contains the register method for all MME structure features.
 * 
 * {@link StructureFeatures}
 * 
 * @author GenElectrovise
 *
 */
public class StructureAspectRegistrationManager {

  public static <FC extends IFeatureConfig, F extends Structure<FC>> StructureFeature<FC, F> registerStructureFeature(
      String name, StructureFeature<FC, F> structure) {

    return WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, name,
        structure);
  }

  public static IStructurePieceType registerStructurePiece(IStructurePieceType type, String key) {
    return Registry.register(Registry.STRUCTURE_PIECE, key.toLowerCase(Locale.ROOT), type);
  }
}