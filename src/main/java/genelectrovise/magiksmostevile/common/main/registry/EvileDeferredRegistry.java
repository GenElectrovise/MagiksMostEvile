package genelectrovise.magiksmostevile.common.main.registry;

import genelectrovise.magiksmostevile.common.entity.vampire_bat.VampireBatEntity;
import genelectrovise.magiksmostevile.common.entity.vampire_bat.VampireBatRenderer;
import genelectrovise.magiksmostevile.common.item.equipment.armor.EvileArmorBases.AmethystArmorBase;
import genelectrovise.magiksmostevile.common.item.equipment.armor.EvileArmorBases.OverPoweredAmethystArmorBase;
import genelectrovise.magiksmostevile.common.item.equipment.armor.EvileArmorBases.PoweredAmethystArmorBase;
import genelectrovise.magiksmostevile.common.item.glowing.GlowingAxe;
import genelectrovise.magiksmostevile.common.item.glowing.GlowingHoe;
import genelectrovise.magiksmostevile.common.item.glowing.GlowingItem;
import genelectrovise.magiksmostevile.common.item.glowing.GlowingPickaxe;
import genelectrovise.magiksmostevile.common.item.glowing.GlowingShovel;
import genelectrovise.magiksmostevile.common.item.glowing.GlowingSword;
import genelectrovise.magiksmostevile.common.item.spawn_egg.VampireBatSpawnEgg;
import genelectrovise.magiksmostevile.common.main.MagiksMostEvile;
import genelectrovise.magiksmostevile.common.main.support.EnumEvileArmorMaterial;
import genelectrovise.magiksmostevile.common.main.support.EnumEvileItemTier;
import genelectrovise.magiksmostevile.common.main.support.EvileItemGroup;
import genelectrovise.magiksmostevile.common.ritual.Ritual;
import genelectrovise.magiksmostevile.common.ritual.ConvertAmethystRitual;
import genelectrovise.magiksmostevile.common.tileentity.altar.AltarBlock;
import genelectrovise.magiksmostevile.common.tileentity.altar.AltarContainer;
import genelectrovise.magiksmostevile.common.tileentity.altar.AltarScreenManager;
import genelectrovise.magiksmostevile.common.tileentity.altar.AltarTileEntity;
import genelectrovise.magiksmostevile.common.tileentity.amethyst_crystal.AmethystCrystalBlock;
import genelectrovise.magiksmostevile.common.tileentity.amethyst_crystal.AmethystCrystalTileEntity;
import genelectrovise.magiksmostevile.common.world.gen.ore.EvileOreFeature;
import genelectrovise.magiksmostevile.common.world.gen.ore.EvileOreFeatureConfig;
import genelectrovise.magiksmostevile.common.world.gen.ore.EvileOreGeneration;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.WrittenBookItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryManager;

public class EvileDeferredRegistry {
	// https://github.com/McJty/YouTubeModding14/blob/master/src/main/java/com/mcjty/mytutorial/setup/Registration.java

	private static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, MagiksMostEvile.MODID);
	private static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, MagiksMostEvile.MODID);
	private static final DeferredRegister<Feature<?>> FEATURES = new DeferredRegister<>(ForgeRegistries.FEATURES, MagiksMostEvile.MODID);
	private static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = new DeferredRegister<TileEntityType<?>>(ForgeRegistries.TILE_ENTITIES, MagiksMostEvile.MODID);
	private static final DeferredRegister<EntityType<?>> ENTITIES = new DeferredRegister<>(ForgeRegistries.ENTITIES, MagiksMostEvile.MODID);
	private static final DeferredRegister<ContainerType<?>> CONTAINERS = new DeferredRegister<>(ForgeRegistries.CONTAINERS, MagiksMostEvile.MODID);
	private static final DeferredRegister<Ritual> RITUALS = new DeferredRegister<Ritual>(LazyForgeRegistry.of(Ritual.class), MagiksMostEvile.MODID);

	// =========BLOCKS======================================================================================================================
	public static final RegistryObject<Block> AMETHYST_BLOCK = BLOCKS.register("amethyst_block", () -> new Block(Block.Properties.create(Material.GLASS).harvestTool(ToolType.PICKAXE).sound(SoundType.GLASS).lightValue(5 / 16).hardnessAndResistance(3F, 3F)));
	public static final RegistryObject<Block> AMETHYST_ORE_OVERWORLD = BLOCKS.register("amethyst_ore_overworld", () -> new Block(Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).sound(SoundType.CORAL).hardnessAndResistance(5F, 5F)));
	public static final RegistryObject<Block> AMETHYST_ORE_NETHER = BLOCKS.register("amethyst_ore_nether", () -> new Block(Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).sound(SoundType.CORAL).hardnessAndResistance(5F, 5F)));
	public static final RegistryObject<Block> AMETHYST_ORE_END = BLOCKS.register("amethyst_ore_end", () -> new Block(Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).sound(SoundType.CORAL).hardnessAndResistance(5F, 5F)));
	public static final RegistryObject<Block> AMETHYST_CRYSTAL = BLOCKS.register("amethyst_crystal", () -> new AmethystCrystalBlock(Block.Properties.create(Material.GLASS).harvestTool(ToolType.PICKAXE).sound(SoundType.GLASS).hardnessAndResistance(2F, 10F)));
	public static final RegistryObject<Block> ALTAR = BLOCKS.register("altar", () -> new AltarBlock(Block.Properties.create(Material.GLASS).harvestTool(ToolType.PICKAXE).sound(SoundType.CLOTH).hardnessAndResistance(6F, 10F)));

//=========BLOCK_ITEMS=================================================================================================================
	public static final RegistryObject<Item> AMETHYST_BLOCK_ITEM = ITEMS.register("amethyst_block", () -> new BlockItem(AMETHYST_BLOCK.get(), new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> AMETHYST_ORE_OVERWORLD_ITEM = ITEMS.register("amethyst_ore_overworld", () -> new BlockItem(AMETHYST_ORE_OVERWORLD.get(), new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> AMETHYST_ORE_NETHER_ITEM = ITEMS.register("amethyst_ore_nether", () -> new BlockItem(AMETHYST_ORE_NETHER.get(), new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> AMETHYST_ORE_END_ITEM = ITEMS.register("amethyst_ore_end", () -> new BlockItem(AMETHYST_ORE_END.get(), new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> AMETHYST_CRYSTAL_ITEM = ITEMS.register("amethyst_crystal", () -> new BlockItem(AMETHYST_CRYSTAL.get(), new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> ALTAR_ITEM = ITEMS.register("altar", () -> new BlockItem(ALTAR.get(), new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));

//=========ITEMS=======================================================================================================================
	public static final RegistryObject<Item> AMETHYST = ITEMS.register("amethyst", () -> new Item(new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> POWERED_AMETHYST = ITEMS.register("powered_amethyst", () -> new GlowingItem(new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> OVER_POWERED_AMETHYST = ITEMS.register("over_powered_amethyst", () -> new GlowingItem(new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> LESSER_POWER_STONE = ITEMS.register("lesser_power_stone", () -> new Item(new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> GREATER_POWER_STONE = ITEMS.register("greater_power_stone", () -> new GlowingItem(new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> GOING_TO_THE_BALL = ITEMS.register("going_to_the_ball", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> INTRO_BOOK = ITEMS.register("intro_book", () -> new WrittenBookItem(new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));

//=========TOOLS=======================================================================================================================
	public static final RegistryObject<Item> AMETHYST_SWORD = ITEMS.register("amethyst_sword", () -> new SwordItem(EnumEvileItemTier.AMETHYST, 1, -0.5F, new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> AMETHYST_AXE = ITEMS.register("amethyst_axe", () -> new AxeItem(EnumEvileItemTier.AMETHYST, 1, -0.5F, new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> AMETHYST_PICKAXE = ITEMS.register("amethyst_pickaxe", () -> new PickaxeItem(EnumEvileItemTier.AMETHYST, 1, -0.5F, new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> AMETHYST_SHOVEL = ITEMS.register("amethyst_shovel", () -> new ShovelItem(EnumEvileItemTier.AMETHYST, 1, -0.5F, new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> AMETHYST_HOE = ITEMS.register("amethyst_hoe", () -> new HoeItem(EnumEvileItemTier.AMETHYST, -0.5F, new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> POWERED_AMETHYST_SWORD = ITEMS.register("powered_amethyst_sword", () -> new GlowingSword(EnumEvileItemTier.POWERED_AMETHYST, 2, -0.25F, new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> POWERED_AMETHYST_AXE = ITEMS.register("powered_amethyst_axe", () -> new GlowingAxe(EnumEvileItemTier.POWERED_AMETHYST, 2, -0.25F, new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> POWERED_AMETHYST_PICKAXE = ITEMS.register("powered_amethyst_pickaxe", () -> new GlowingPickaxe(EnumEvileItemTier.POWERED_AMETHYST, 2, -0.25F, new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> POWERED_AMETHYST_SHOVEL = ITEMS.register("powered_amethyst_shovel", () -> new GlowingShovel(EnumEvileItemTier.POWERED_AMETHYST, 2, -0.25F, new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> POWERED_AMETHYST_HOE = ITEMS.register("powered_amethyst_hoe", () -> new GlowingHoe(EnumEvileItemTier.POWERED_AMETHYST, -0.25F, new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));

//=========TOMES======================================================================================================================
	public static final RegistryObject<Item> TOME_CONVERT_AMETHYST = ITEMS.register("tome_convert_amethyst", () -> new Item(new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));

//=========ARMOR======================================================================================================================
	public static final RegistryObject<Item> AMETHYST_HELMET = ITEMS.register("amethyst_helmet", () -> new AmethystArmorBase(EnumEvileArmorMaterial.AMETHYST, EquipmentSlotType.HEAD, new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> AMETHYST_CHESTPLATE = ITEMS.register("amethyst_chestplate", () -> new AmethystArmorBase(EnumEvileArmorMaterial.AMETHYST, EquipmentSlotType.CHEST, new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> AMETHYST_LEGGINGS = ITEMS.register("amethyst_leggings", () -> new AmethystArmorBase(EnumEvileArmorMaterial.AMETHYST, EquipmentSlotType.LEGS, new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> AMETHYST_BOOTS = ITEMS.register("amethyst_boots", () -> new AmethystArmorBase(EnumEvileArmorMaterial.AMETHYST, EquipmentSlotType.FEET, new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	//
	public static final RegistryObject<Item> POWERED_AMETHYST_HELMET = ITEMS.register("powered_amethyst_helmet", () -> new PoweredAmethystArmorBase(EnumEvileArmorMaterial.POWERED_AMETHYST, EquipmentSlotType.HEAD, new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> POWERED_AMETHYST_CHESTPLATE = ITEMS.register("powered_amethyst_chestplate", () -> new PoweredAmethystArmorBase(EnumEvileArmorMaterial.POWERED_AMETHYST, EquipmentSlotType.CHEST, new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> POWERED_AMETHYST_LEGGINGS = ITEMS.register("powered_amethyst_leggings", () -> new PoweredAmethystArmorBase(EnumEvileArmorMaterial.POWERED_AMETHYST, EquipmentSlotType.LEGS, new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> POWERED_AMETHYST_BOOTS = ITEMS.register("powered_amethyst_boots", () -> new PoweredAmethystArmorBase(EnumEvileArmorMaterial.POWERED_AMETHYST, EquipmentSlotType.FEET, new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	//
	public static final RegistryObject<Item> OVER_POWERED_AMETHYST_HELMET = ITEMS.register("over_powered_amethyst_helmet", () -> new OverPoweredAmethystArmorBase(EnumEvileArmorMaterial.OVER_POWERED_AMETHYST, EquipmentSlotType.HEAD, new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> OVER_POWERED_AMETHYST_CHESTPLATE = ITEMS.register("over_powered_amethyst_chestplate", () -> new OverPoweredAmethystArmorBase(EnumEvileArmorMaterial.OVER_POWERED_AMETHYST, EquipmentSlotType.CHEST, new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> OVER_POWERED_AMETHYST_LEGGINGS = ITEMS.register("over_powered_amethyst_leggings", () -> new OverPoweredAmethystArmorBase(EnumEvileArmorMaterial.OVER_POWERED_AMETHYST, EquipmentSlotType.LEGS, new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));
	public static final RegistryObject<Item> OVER_POWERED_AMETHYST_BOOTS = ITEMS.register("over_powered_amethyst_boots", () -> new OverPoweredAmethystArmorBase(EnumEvileArmorMaterial.OVER_POWERED_AMETHYST, EquipmentSlotType.FEET, new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE)));

//=========FOOD========================================================================================================================
	public static final RegistryObject<Item> AMETHYST_POTATO = ITEMS.register("amethyst_potato", () -> new Item(new Item.Properties().food((new Food.Builder()).hunger(3).saturation(0.8F).effect(() -> new EffectInstance(Effects.SPEED, 400, 1), 1.0F).fastToEat().build()).group(EvileItemGroup.ITEMGROUP_EVILE)));

//=========TILE ENTITIES===============================================================================================================
	public static final RegistryObject<TileEntityType<AmethystCrystalTileEntity>> TILE_ENTITY_AMETHYST_CRYSTAL = TILE_ENTITIES.register("tile_entity_amethyst_crystal", () -> TileEntityType.Builder.create(AmethystCrystalTileEntity::new, EvileDeferredRegistry.AMETHYST_CRYSTAL.get()).build(null));
	public static final RegistryObject<TileEntityType<AltarTileEntity>> TILE_ENTITY_ALTAR = TILE_ENTITIES.register("tile_entity_altar", () -> TileEntityType.Builder.create(AltarTileEntity::new, EvileDeferredRegistry.ALTAR.get()).build(null));

//=========CONTAINERS==================================================================================================================

	public static final RegistryObject<ContainerType<AltarContainer>> ALTAR_CONTAINER = CONTAINERS.register("altar", () -> IForgeContainerType.create(AltarContainer::new));

	public static void createContainerFactories() {
		ScreenManager.registerFactory(ALTAR_CONTAINER.get(), new AltarScreenManager());
	}

//=========ENTITIES====================================================================================================================
	public static final RegistryObject<EntityType<VampireBatEntity>> VAMPIRE_BAT = ENTITIES.register("vampire_bat", () -> EntityType.Builder.create(VampireBatEntity::new, EntityClassification.MONSTER).setTrackingRange(64).size(0.5f, 0.5f).build("vampire_bat"));
	public static final RegistryObject<Item> VAMPIRE_BAT_EGG = ITEMS.register("vampire_bat_egg", () -> new VampireBatSpawnEgg(new Item.Properties().group(EvileItemGroup.ITEMGROUP_EVILE).maxStackSize(64)));

	public static void renderers(FMLClientSetupEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(VAMPIRE_BAT.get(), VampireBatRenderer::new);
	}

//=========GENERATION (structures should be done via registry events) =================================================================

	public static final RegistryObject<EvileOreFeature> AMETHYST_ORE_OVERWORLD_GEN = FEATURES.register("amethyst_ore_overworld_gen", () -> new EvileOreFeature(EvileOreFeatureConfig::deserialize));

	public static void addOres() {
		EvileOreGeneration.addOverworldOres();
		// EvileOreGeneration.addEndOres();
		EvileOreGeneration.addNetherOres();
	}

//=========RITUALS=====================================================================================================================
	public static final RegistryObject<ConvertAmethystRitual> CONVERT_AMETHYST_RITUAL = RITUALS.register("convert_amethyst_ritual", () -> new ConvertAmethystRitual());

//=========CONSTRUCTOR=================================================================================================================

	private static boolean isInitialised = false;

	/**
	 * Should be called during mod construction
	 */
	public static void init(final IEventBus eventBus) {

		if (isInitialised) {
			throw new IllegalStateException("MagiksMostEvile is already initialised!");
		}

		MagiksMostEvile.LOGGER.debug("Constructing EvileRegistry!");
		MagiksMostEvile.LOGGER.debug("Log Key 182727012020 : FMLJavaModLoadingContext = " + FMLJavaModLoadingContext.get());

		BLOCKS.register(eventBus);
		ITEMS.register(eventBus);
		FEATURES.register(eventBus);
		TILE_ENTITIES.register(eventBus);
		ENTITIES.register(eventBus);
		CONTAINERS.register(eventBus);
		RITUALS.register(eventBus);
	}
}