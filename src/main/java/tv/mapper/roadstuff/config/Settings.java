package tv.mapper.roadstuff.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

import java.util.ArrayList;

public final class Settings {
    public static ForgeConfigSpec.BooleanValue BITUMEN_GENERATION;
    public static ForgeConfigSpec.IntValue BITUMEN_CHANCE;
    public static ForgeConfigSpec.IntValue BITUMEN_SIZE;
    public static ForgeConfigSpec.IntValue BITUMEN_MIN_HEIGHT;
    public static ForgeConfigSpec.IntValue BITUMEN_MAX_HEIGHT;

    public static void initialize() {
        var COMMON_BUILDER = new ForgeConfigSpec.Builder();

        COMMON_BUILDER.comment("Bitumen Generation").push("bitumen");

        BITUMEN_GENERATION = COMMON_BUILDER.comment("Generate bitumen in the world [true / false]").define("bitumenGeneration", true);
        BITUMEN_SIZE = COMMON_BUILDER.comment("Size of bitumen pockets [1-100, default: 28]").defineInRange("bitumenSize", 28, 1, 100);
        BITUMEN_CHANCE = COMMON_BUILDER.comment("Amount of bitumen pocket being generated per chunk [1-10, default: 1]").defineInRange("bitumenChance", 1, 1, 10);
        BITUMEN_MIN_HEIGHT = COMMON_BUILDER.comment("Minimal height for bitumen pocket generation, [-63~318, default: 60]").defineInRange("bitumenMinHeight", 60, -63, 318);
        BITUMEN_MAX_HEIGHT = COMMON_BUILDER.comment("Maximal height for bitumen pocket generation, must be higher than minimal height [-63~319, default: 68]").defineInRange("bitumenMaxHeight", 68, -63, 319);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, COMMON_BUILDER.build());
    }
}
