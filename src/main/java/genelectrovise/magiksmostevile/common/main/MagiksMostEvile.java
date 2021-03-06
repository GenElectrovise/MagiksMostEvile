package genelectrovise.magiksmostevile.common.main;

import org.apache.logging.log4j.LogManager;

import genelectrovise.magiksmostevile.common.main.registry.EvileDeferredRegistry;
import genelectrovise.magiksmostevile.common.particle.ParticleClientStartup;
import genelectrovise.magiksmostevile.common.particle.ParticleCommonStartup;
import genelectrovise.magiksmostevile.common.ritual.Ritual;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryBuilder;

@Mod(MagiksMostEvile.MODID)
@Mod.EventBusSubscriber(modid = MagiksMostEvile.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MagiksMostEvile {
	public static final EvileLog LOGGER = new EvileLog(LogManager.getLogger());
	public static final String MODID = "magiksmostevile";
	public static final String VERSION = "1.0";
	public static final String NAME = "MagiksMostEvile";
	public static final String ACCEPTED_VERSIONS = "1.15.2";

	public static IEventBus EVENT_BUS;

	public MagiksMostEvile() {
		EVENT_BUS = FMLJavaModLoadingContext.get().getModEventBus();
		
		LOGGER.info("Welcome to Magiks Most Evile! Hello from the Main class! (If you can see this message, Magiks Most Evile is being loaded by Forge! Woohoo!)");
		MagiksMostEvile.LOGGER.debug("Log Key 182927012020 : FMLJavaModLoadingContext = " + FMLJavaModLoadingContext.get());

		registerEventListeners(MinecraftForge.EVENT_BUS);
		EvileDeferredRegistry.init(FMLJavaModLoadingContext.get().getModEventBus());

		registerCommonEvents();
		DistExecutor.runWhenOn(Dist.CLIENT, () -> MagiksMostEvile::registerClientOnlyEvents);
	}

	@SubscribeEvent
	public static void createRegistries(RegistryEvent.NewRegistry event) {
		new RegistryBuilder<Ritual>().setType(Ritual.class).setName(new ResourceLocation(MODID, "ritual")).create();
	}

	private static void registerEventListeners(IEventBus bus) {
		MagiksMostEvile.LOGGER.debug("==MME1== Registering Event Listeners to Forge EventBus");
	}

	public static void registerCommonEvents() {
		EVENT_BUS.register(ParticleCommonStartup.class);
	}

	public static void registerClientOnlyEvents() {
		EVENT_BUS.register(ParticleClientStartup.class);
	}

}
