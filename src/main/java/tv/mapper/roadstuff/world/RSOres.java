//package tv.mapper.roadstuff.world;
//
//import net.minecraft.core.Holder;
//import net.minecraft.data.worldgen.features.CaveFeatures;
//import net.minecraft.data.worldgen.features.FeatureUtils;
//import net.minecraft.data.worldgen.features.OreFeatures;
//import net.minecraft.data.worldgen.placement.PlacementUtils;
//import net.minecraft.util.valueproviders.UniformInt;
//import net.minecraft.world.level.levelgen.Heightmap;
//import net.minecraft.world.level.levelgen.VerticalAnchor;
//import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
//import net.minecraft.world.level.levelgen.feature.Feature;
//import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
//import net.minecraft.world.level.levelgen.placement.*;
//import tv.mapper.mapperbase.world.BaseOreGenerator;
//import tv.mapper.mapperbase.world.CustomOre;
//import tv.mapper.mapperbase.world.OreList;
//import tv.mapper.roadstuff.config.RSConfig.CommonConfig;
//import tv.mapper.roadstuff.world.level.block.RSBlockRegistry;
//
//import java.util.List;
//
//import static net.minecraft.data.worldgen.features.OreFeatures.STONE_ORE_REPLACEABLES;
//
//public class RSOres {
//
//    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> BITUMEN_CONF = FeatureUtils.register("bitumen", Feature.ORE, new OreConfiguration(STONE_ORE_REPLACEABLES, RSBlockRegistry.BITUMEN_ORE.get().defaultBlockState(), CommonConfig.BITUMEN_SIZE.get()));
//
//    public static final Holder<PlacedFeature> BITUMEN = PlacementUtils.register("bitumen", BITUMEN_CONF, commonOrePlacement(CommonConfig.BITUMEN_CHANCE.get(), HeightRangePlacement.uniform(VerticalAnchor.absolute(CommonConfig.BITUMEN_MIN_HEIGHT.get()), VerticalAnchor.absolute(CommonConfig.BITUMEN_MAX_HEIGHT.get()))));
//
//    private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
//        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
//    }
//
//    private static List<PlacementModifier> commonOrePlacement(int pCount, PlacementModifier pHeightRange) {
//        return orePlacement(CountPlacement.of(pCount), pHeightRange);
//    }
//
//
//    public static final CustomOre bitumen = new CustomOre("bitumen", BITUMEN.get(), CommonConfig.BITUMEN_GENERATION.get(), CommonConfig.BITUMEN_WHITELIST_MODE.get(), CommonConfig.BITUMEN_BIOME_LIST.get());
//
//    public static void initOres() {
//        OreList.addOre(bitumen);
//    }
//}
//
//