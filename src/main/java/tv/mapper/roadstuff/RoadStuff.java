package tv.mapper.roadstuff;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ConfigTracker;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tv.mapper.roadstuff.config.Settings;
import tv.mapper.roadstuff.network.RSNetwork;
import tv.mapper.roadstuff.proxy.ClientProxy;
import tv.mapper.roadstuff.proxy.IProxy;
import tv.mapper.roadstuff.proxy.ServerProxy;
//import tv.mapper.roadstuff.world.RSConfiguredFeatures;
//import tv.mapper.roadstuff.world.RSPlacedFeatures;
import tv.mapper.roadstuff.world.item.ModCreativeModeTabs;
import tv.mapper.roadstuff.world.item.RSItemRegistry;
import tv.mapper.roadstuff.world.level.block.RSBlockRegistry;

@Mod(RoadStuff.MODID)
public class RoadStuff {
    public static final String MODID = "roadstuff";
    public static IProxy proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> ServerProxy::new);

    public static long clickInterval = System.currentTimeMillis();

    public static final Logger LOGGER = LogManager.getLogger();

    public RoadStuff() {
        Settings.initialize();

        ConfigTracker.INSTANCE.loadConfigs(ModConfig.Type.COMMON, FMLPaths.CONFIGDIR.get());
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModCreativeModeTabs.register(modEventBus);

//        if (!Settings.BITUMEN_GENERATION.get())
//            LOGGER.info("Road Stuff worldgen is disabled by config.");
//        else {

//            RSConfiguredFeatures.register(modEventBus);
//            RSPlacedFeatures.register(modEventBus);
//              ConfigChecker.checkConfig(Settings.BITUMEN_BIOME_LIST.get(), MODID);
//        }

        RSBlockRegistry.init();
        RSItemRegistry.init();

        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::clientSetup);
        modEventBus.addListener(this::serverSetup);

//        modEventBus.register(new RSOreGenerator());
//        modEventBus.register(new BaseTiers());
        modEventBus.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == ModCreativeModeTabs.ROAD_STUFF_TAB.get()) {
            event.accept(RSItemRegistry.CONCRETE_ITEM.get());
            event.accept(RSItemRegistry.CONCRETE_STAIRS_ITEM.get());
            event.accept(RSItemRegistry.CONCRETE_SLAB_ITEM.get());
            event.accept(RSItemRegistry.CONCRETE_WALL_ITEM.get());
            event.accept(RSItemRegistry.CONCRETE_PRESSURE_PLATE_ITEM.get());
            event.accept(RSItemRegistry.CONCRETE_FENCE_ITEM.get());
            event.accept(RSItemRegistry.CONCRETE_FENCE_GATE_ITEM.get());
            event.accept(RSItemRegistry.ASPHALT_ITEM.get());
            event.accept(RSItemRegistry.ASPHALT_STAIRS_ITEM.get());
            event.accept(RSItemRegistry.ASPHALT_SLAB_ITEM.get());
            event.accept(RSItemRegistry.ASPHALT_PRESSURE_PLATE_ITEM.get());
            event.accept(RSItemRegistry.ASPHALT_SLOPE_ITEM.get());
            event.accept(RSItemRegistry.CONCRETE_SLOPE_ITEM.get());
            event.accept(RSItemRegistry.RED_ASPHALT_ITEM.get());
            event.accept(RSItemRegistry.RED_ASPHALT_SLOPE_ITEM.get());
            event.accept(RSItemRegistry.GREEN_ASPHALT_ITEM.get());
            event.accept(RSItemRegistry.GREEN_ASPHALT_SLOPE_ITEM.get());
            event.accept(RSItemRegistry.BLUE_ASPHALT_ITEM.get());
            event.accept(RSItemRegistry.BLUE_ASPHALT_SLOPE_ITEM.get());
            event.accept(RSItemRegistry.YELLOW_ASPHALT_ITEM.get());
            event.accept(RSItemRegistry.YELLOW_ASPHALT_SLOPE_ITEM.get());
            event.accept(RSItemRegistry.RAW_BITUMEN.get());
            event.accept(RSItemRegistry.BITUMEN_ORE_ITEM.get());
            event.accept(RSItemRegistry.BITUMEN_ITEM.get());
            event.accept(RSItemRegistry.BITUMINOUS_COAL.get());
            event.accept(RSItemRegistry.WHITE_BOLLARD_ITEM.get());
            event.accept(RSItemRegistry.YELLOW_BOLLARD_ITEM.get());
            event.accept(RSItemRegistry.RED_BOLLARD_ITEM.get());
            event.accept(RSItemRegistry.WHITE_SMALL_BOLLARD_ITEM.get());
            event.accept(RSItemRegistry.YELLOW_SMALL_BOLLARD_ITEM.get());
            event.accept(RSItemRegistry.RED_SMALL_BOLLARD_ITEM.get());
            event.accept(RSItemRegistry.STEEL_GUARDRAIL_ITEM.get());
            event.accept(RSItemRegistry.PAINT_BUCKET_ITEM.get());
            event.accept(RSItemRegistry.WOODEN_PAINT_BRUSH.get());
            event.accept(RSItemRegistry.STONE_PAINT_BRUSH.get());
            event.accept(RSItemRegistry.IRON_PAINT_BRUSH.get());
            event.accept(RSItemRegistry.GOLDEN_PAINT_BRUSH.get());
            event.accept(RSItemRegistry.STEEL_PAINT_BRUSH.get());
            event.accept(RSItemRegistry.DIAMOND_PAINT_BRUSH.get());
            event.accept(RSItemRegistry.NETHERITE_PAINT_BRUSH.get());

            RSItemRegistry.TRAFFIC_CONE_ITEMS.values().forEach(item -> event.accept(item.get()));
            RSItemRegistry.TRAFFIC_BARREL_ITEMS.values().forEach(item -> event.accept(item.get()));
            RSItemRegistry.TRAFFIC_BOLLARD_ITEMS.values().forEach(item -> event.accept(item.get()));
            RSItemRegistry.CYLINDRICAL_BOLLARD_ITEMS.values().forEach(item -> event.accept(item.get()));
            RSItemRegistry.GUARDRAIL_ITEMS.values().forEach(item -> event.accept(item.get()));
            RSItemRegistry.REFLECTOR_ITEMS.values().forEach(item -> event.accept(item.get()));
            RSItemRegistry.LUMINESCENT_REFLECTOR_ITEMS.values().forEach(item -> event.accept(item.get()));

            event.accept(RSBlockRegistry.CONCRETE.get());
            event.accept(RSBlockRegistry.CONCRETE_STAIRS.get());
            event.accept(RSBlockRegistry.CONCRETE_SLAB.get());
            event.accept(RSBlockRegistry.CONCRETE_WALL.get());
            event.accept(RSBlockRegistry.CONCRETE_FENCE.get());
            event.accept(RSBlockRegistry.CONCRETE_FENCE_GATE.get());
            event.accept(RSBlockRegistry.CONCRETE_SLOPE.get());
            event.accept(RSBlockRegistry.ASPHALT.get());
            event.accept(RSBlockRegistry.ASPHALT_STAIRS.get());
            event.accept(RSBlockRegistry.ASPHALT_SLAB.get());
            event.accept(RSBlockRegistry.ASPHALT_SLOPE.get());
            event.accept(RSBlockRegistry.RED_ASPHALT.get());
            event.accept(RSBlockRegistry.RED_ASPHALT_SLOPE.get());
            event.accept(RSBlockRegistry.GREEN_ASPHALT.get());
            event.accept(RSBlockRegistry.GREEN_ASPHALT_SLOPE.get());
            event.accept(RSBlockRegistry.BLUE_ASPHALT.get());
            event.accept(RSBlockRegistry.BLUE_ASPHALT_SLOPE.get());
            event.accept(RSBlockRegistry.YELLOW_ASPHALT.get());
            event.accept(RSBlockRegistry.YELLOW_ASPHALT_SLOPE.get());
            event.accept(RSBlockRegistry.BITUMEN_BLOCK.get());
            event.accept(RSBlockRegistry.BITUMEN_ORE.get());
            event.accept(RSBlockRegistry.YELLOW_BOLLARD.get());
            event.accept(RSBlockRegistry.WHITE_BOLLARD.get());
            event.accept(RSBlockRegistry.RED_BOLLARD.get());
            event.accept(RSBlockRegistry.YELLOW_SMALL_BOLLARD.get());
            event.accept(RSBlockRegistry.WHITE_SMALL_BOLLARD.get());
            event.accept(RSBlockRegistry.RED_SMALL_BOLLARD.get());
            event.accept(RSBlockRegistry.STEEL_GUARDRAIL.get());
            event.accept(RSBlockRegistry.PAINT_BUCKET.get());
            event.accept(RSBlockRegistry.ASPHALT_PRESSURE_PLATE.get());
            event.accept(RSBlockRegistry.CONCRETE_PRESSURE_PLATE.get());

            RSBlockRegistry.TRAFFIC_CONE_BLOCKS.values().forEach(item -> event.accept(item.get()));
            RSBlockRegistry.TRAFFIC_BARREL_BLOCKS.values().forEach(item -> event.accept(item.get()));
            RSBlockRegistry.TRAFFIC_BOLLARD_BLOCKS.values().forEach(item -> event.accept(item.get()));
            RSBlockRegistry.CYLINDRICAL_BOLLARD_BLOCKS.values().forEach(item -> event.accept(item.get()));
            RSBlockRegistry.REFLECTOR_BLOCKS.values().forEach(item -> event.accept(item.get()));
            RSBlockRegistry.LUMINESCENT_REFLECTOR_BLOCKS.values().forEach(item -> event.accept(item.get()));
            RSBlockRegistry.GUARDRAIL_BLOCKS.values().forEach(item -> event.accept(item.get()));
        }
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("RoadStuff setup started!");
        proxy.setup(event);

        RSNetwork.registerNetworkPackets();
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        // LOGGER.info("RoadStuff client setup");
    }

    private void serverSetup(final FMLDedicatedServerSetupEvent event) {
        // LOGGER.info("RoadStuff server setup");
    }
}