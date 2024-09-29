package tv.mapper.roadstuff.world;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import tv.mapper.roadstuff.config.Settings;
import tv.mapper.roadstuff.world.level.block.RSBlockRegistry;

import java.util.List;

public class RSConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registries.CONFIGURED_FEATURE, "roadstuff");

    public static final Supplier<List<OreConfiguration.TargetBlockState>> BITUMEN_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, RSBlockRegistry.BITUMEN_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, RSBlockRegistry.BITUMEN_ORE.get().defaultBlockState())));




    public static final RegistryObject<ConfiguredFeature<?, ?>> BITUMEN_ORE = CONFIGURED_FEATURES.register("bitumen",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(BITUMEN_ORES.get(), Settings.BITUMEN_SIZE.get())));


    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }
}