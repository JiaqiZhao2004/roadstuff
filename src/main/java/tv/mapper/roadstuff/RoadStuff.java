package tv.mapper.roadstuff;

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
import tv.mapper.roadstuff.world.RSConfiguredFeatures;
import tv.mapper.roadstuff.world.RSPlacedFeatures;
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


        if (!Settings.BITUMEN_GENERATION.get())
            LOGGER.info("Road Stuff worldgen is disabled by config.");
        else {

            RSConfiguredFeatures.register(modEventBus);
            RSPlacedFeatures.register(modEventBus);
            //  ConfigChecker.checkConfig(Settings.BITUMEN_BIOME_LIST.get(), MODID);
        }

        RSBlockRegistry.init();
        RSItemRegistry.init();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::serverSetup);
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