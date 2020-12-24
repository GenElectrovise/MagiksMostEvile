package genelectrovise.magiksmostevile.common.world.gen.ore;

import java.util.ArrayList;
import genelectrovise.magiksmostevile.common.core.registry.EvileDeferredRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class OreFeatureRegistry {

  public static final ArrayList<SimpleConfiguredOreFeature> overworldOres =
      new ArrayList<SimpleConfiguredOreFeature>();

  public static final ArrayList<SimpleConfiguredOreFeature> netherOres =
      new ArrayList<SimpleConfiguredOreFeature>();

  public static final ArrayList<SimpleConfiguredOreFeature> endOres =
      new ArrayList<SimpleConfiguredOreFeature>();


  /**
   * Form the lists of ores to register
   * 
   * @param event
   */
  @SubscribeEvent
  public static void createOreLists(final FMLCommonSetupEvent event) {
    overworldOres();
    netherOres();
    endOres();
  }

  /**
   * Trigger ore registration.
   * 
   * @param event
   */
  @SubscribeEvent(priority = EventPriority.HIGH)
  public static void addOresToBiomes(final BiomeLoadingEvent event) {
    registerOres(event);
  }

  private static void overworldOres() {
    overworldOres
        .add(new SimpleConfiguredOreFeature.Builder().withSimpleOreFeature(new SimpleOreFeature())
            .withSimpleOreFeatureConfiguration(
                new SimpleOreFeatureConfiguration(Blocks.STONE.getDefaultState(),
                    EvileDeferredRegistry.AMETHYST_ORE_OVERWORLD.get().getDefaultState(), 10, true))
            .build());
  }

  private static void netherOres() {

  }

  private static void endOres() {

  }

  /**
   * Apply {@value #overworldOres()}, {@value #netherOres} and {@value #endOres} to {@link Biome}s
   * of their various {@link Biome.Category}.
   * 
   * @param event
   */
  private static void registerOres(final BiomeLoadingEvent event) {

    BiomeGenerationSettingsBuilder generation = event.getGeneration();

    switch (event.getCategory()) {
      case NETHER:
        for (SimpleConfiguredOreFeature simpleConfiguredOreFeature : netherOres) {
          registerTo(generation, simpleConfiguredOreFeature);
        }
        break;

      case THEEND:
        for (SimpleConfiguredOreFeature simpleConfiguredOreFeature : endOres) {
          registerTo(generation, simpleConfiguredOreFeature);
        }
        break;

      default:
        for (SimpleConfiguredOreFeature simpleConfiguredOreFeature : overworldOres) {
          registerTo(generation, simpleConfiguredOreFeature);
        }
        break;
    }

  }

  /**
   * Convenience method to tidy up {@link #registerOres(BiomeLoadingEvent)} by abstracting away
   * {@link BiomeGenerationSettingsBuilder} calls.
   * 
   * @param builder
   * @param feature
   */
  private static void registerTo(BiomeGenerationSettingsBuilder builder,
      SimpleConfiguredOreFeature feature) {
    builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, feature);
  }
}
