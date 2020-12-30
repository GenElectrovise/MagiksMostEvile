package genelectrovise.magiksmostevile.common.core.registry.orbital.registries;

import genelectrovise.magiksmostevile.common.core.registry.orbital.IOrbitalRegistry;
import genelectrovise.magiksmostevile.common.core.support.EvileItemGroup;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

public class TomeOrbitalRegistry implements IOrbitalRegistry {

  // =========TOMES======================================================================================================================
  public static final RegistryObject<Item> TOME_CONVERT_AMETHYST =
      ItemOrbitalRegistry.ITEMS.register("tome_convert_amethyst",
          () -> new Item(new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
  public static final RegistryObject<Item> TOME_SUMMON_FLAPPY =
      ItemOrbitalRegistry.ITEMS.register("tome_summon_flappy",
          () -> new Item(new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));

  @Override
  public int priority() {
    return 6;
  }

  @Override
  public void initialise() {

  }

  @Override
  public String name() {
    return "tomes";
  }

}