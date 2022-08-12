package tv.mapper.roadstuff.world;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import tv.mapper.mapperbase.world.BaseOreGenerator;
import tv.mapper.mapperbase.world.CustomOre;
import tv.mapper.mapperbase.world.OreList;
import tv.mapper.roadstuff.config.RSConfig.CommonConfig;
import tv.mapper.roadstuff.world.level.block.RSBlockRegistry;

import java.util.List;

public class RSOres
{
    static OreConfiguration bitumenConfig = new OreConfiguration(
            OreFeatures.STONE_ORE_REPLACEABLES,
            RSBlockRegistry.BITUMEN_ORE.get().defaultBlockState(),
            CommonConfig.BITUMEN_SIZE.get()
    );

    public static Holder<PlacedFeature> BITUMEN = registerPlacedOreFeature("bitumen", new ConfiguredFeature<>(Feature.ORE, bitumenConfig),
            BaseOreGenerator.commonOrePlacement(
                    CommonConfig.BITUMEN_CHANCE.get(),
                    HeightRangePlacement.uniform(
                            VerticalAnchor.absolute(CommonConfig.BITUMEN_MIN_HEIGHT.get()),
                            VerticalAnchor.absolute(CommonConfig.BITUMEN_MAX_HEIGHT.get())
                    )
            )
    );

    public static final CustomOre bitumen = new CustomOre("bitumen", BITUMEN, CommonConfig.BITUMEN_GENERATION.get(), CommonConfig.BITUMEN_WHITELIST_MODE.get(), CommonConfig.BITUMEN_BIOME_LIST.get());

    public static void initOres()
    {
        OreList.addOre(bitumen);
    }

    private static <C extends FeatureConfiguration, F extends Feature<C>> Holder<PlacedFeature> registerPlacedOreFeature(String registryName, ConfiguredFeature<C, F> feature, List<PlacementModifier> placementModifiers) {
        return PlacementUtils.register(registryName, Holder.direct(feature), placementModifiers);
    }
}