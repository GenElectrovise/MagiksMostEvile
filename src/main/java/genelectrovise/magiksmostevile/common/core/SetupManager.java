package genelectrovise.magiksmostevile.common.core;

import genelectrovise.magiksmostevile.common.core.registry.EvileDeferredRegistry;
import genelectrovise.magiksmostevile.common.entity.boss.egg_capone.EggCaponeEntity;
import genelectrovise.magiksmostevile.common.entity.boss.the_kraken.TheKrakenEntity;
import genelectrovise.magiksmostevile.common.entity.boss.tinder_and_cinder.TinderAndCinderEntity;
import genelectrovise.magiksmostevile.common.entity.boss.tom_the_troll.TomTheTrollEntity;
import genelectrovise.magiksmostevile.common.entity.vampire_bat.VampireBatEntity;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.ParallelDispatchEvent;

public final class SetupManager {

  public static final Runnable[] tasks = {

      // Setup entity attributes
      () -> {
        MagiksMostEvile.LOGGER.debug("Registering MME entity attributes");

        // Vampire Bat
        GlobalEntityTypeAttributes.put(EvileDeferredRegistry.VAMPIRE_BAT.get(),
            VampireBatEntity.getEntityAttributes().create());

        // Egg Capone
        GlobalEntityTypeAttributes.put(EvileDeferredRegistry.EGG_CAPONE.get(),
            EggCaponeEntity.getEntityAttributes().create());

        // The Kraken
        GlobalEntityTypeAttributes.put(EvileDeferredRegistry.THE_KRAKEN.get(),
            TheKrakenEntity.getEntityAttributes().create());

        // Tinder and Cinder
        GlobalEntityTypeAttributes.put(EvileDeferredRegistry.TINDER_AND_CINDER.get(),
            TinderAndCinderEntity.getEntityAttributes().create());

        // Tom the Trol
        GlobalEntityTypeAttributes.put(EvileDeferredRegistry.TOM_THE_TROLL.get(),
            TomTheTrollEntity.getEntityAttributes().create());
      }

      //
  };

  @SubscribeEvent
  public static void setup(ParallelDispatchEvent event) {

    MagiksMostEvile.LOGGER.debug("SetupManager#setup() called for MME");

    for (Runnable runnable : tasks) {
      event.enqueueWork(runnable);
    }

  }
}