package tv.mapper.roadstuff.world.item;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tv.mapper.roadstuff.RoadStuff;
import tv.mapper.roadstuff.world.level.block.RSBlockRegistry;

import java.util.Arrays;

@Mod.EventBusSubscriber(modid = RoadStuff.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItemGroups
{
    @SubscribeEvent
    public static void buildContents(CreativeModeTabEvent.Register event) {
        event.registerCreativeModeTab(new ResourceLocation(RoadStuff.MODID, "roadstuff_group"), builder ->
                builder.title(Component.translatable("itemGroup.roadstuff_group"))
                        .icon(() -> new ItemStack(RSBlockRegistry.TRAFFIC_CONE_BLOCKS.get(DyeColor.ORANGE).get()))
                        .displayItems((parameters, output) -> {
                            output.accept(RSItemRegistry.CONCRETE_ITEM.get());
                            output.accept(RSItemRegistry.CONCRETE_STAIRS_ITEM.get());
                            output.accept(RSItemRegistry.CONCRETE_SLAB_ITEM.get());
                            output.accept(RSItemRegistry.CONCRETE_WALL_ITEM.get());
                            output.accept(RSItemRegistry.CONCRETE_PRESSURE_PLATE_ITEM.get());
                            output.accept(RSItemRegistry.CONCRETE_FENCE_ITEM.get());
                            output.accept(RSItemRegistry.CONCRETE_FENCE_GATE_ITEM.get());
                            output.accept(RSItemRegistry.ASPHALT_ITEM.get());
                            output.accept(RSItemRegistry.ASPHALT_STAIRS_ITEM.get());
                            output.accept(RSItemRegistry.ASPHALT_SLAB_ITEM.get());
                            output.accept(RSItemRegistry.ASPHALT_PRESSURE_PLATE_ITEM.get());
                            output.accept(RSItemRegistry.ASPHALT_SLOPE_ITEM.get());
                            output.accept(RSItemRegistry.CONCRETE_SLOPE_ITEM.get());
                            output.accept(RSItemRegistry.RED_ASPHALT_ITEM.get());
                            output.accept(RSItemRegistry.RED_ASPHALT_SLOPE_ITEM.get());
                            output.accept(RSItemRegistry.GREEN_ASPHALT_ITEM.get());
                            output.accept(RSItemRegistry.GREEN_ASPHALT_SLOPE_ITEM.get());
                            output.accept(RSItemRegistry.BLUE_ASPHALT_ITEM.get());
                            output.accept(RSItemRegistry.BLUE_ASPHALT_SLOPE_ITEM.get());
                            output.accept(RSItemRegistry.YELLOW_ASPHALT_ITEM.get());
                            output.accept(RSItemRegistry.YELLOW_ASPHALT_SLOPE_ITEM.get());
                            output.accept(RSItemRegistry.RAW_BITUMEN.get());
                            output.accept(RSItemRegistry.BITUMEN_ORE_ITEM.get());
                            output.accept(RSItemRegistry.BITUMEN_ITEM.get());
                            output.accept(RSItemRegistry.BITUMINOUS_COAL.get());
                            output.accept(RSItemRegistry.WHITE_BOLLARD_ITEM.get());
                            output.accept(RSItemRegistry.YELLOW_BOLLARD_ITEM.get());
                            output.accept(RSItemRegistry.RED_BOLLARD_ITEM.get());
                            output.accept(RSItemRegistry.WHITE_SMALL_BOLLARD_ITEM.get());
                            output.accept(RSItemRegistry.YELLOW_SMALL_BOLLARD_ITEM.get());
                            output.accept(RSItemRegistry.RED_SMALL_BOLLARD_ITEM.get());
                            output.accept(RSItemRegistry.STEEL_GUARDRAIL_ITEM.get());
                            output.accept(RSItemRegistry.PAINT_BUCKET_ITEM.get());
                            output.accept(RSItemRegistry.WOODEN_PAINT_BRUSH.get());
                            output.accept(RSItemRegistry.STONE_PAINT_BRUSH.get());
                            output.accept(RSItemRegistry.IRON_PAINT_BRUSH.get());
                            output.accept(RSItemRegistry.GOLDEN_PAINT_BRUSH.get());
                            output.accept(RSItemRegistry.STEEL_PAINT_BRUSH.get());
                            output.accept(RSItemRegistry.DIAMOND_PAINT_BRUSH.get());
                            output.accept(RSItemRegistry.NETHERITE_PAINT_BRUSH.get());

                            output.accept(RSItemRegistry.TRAFFIC_CONE_ITEMS.get(DyeColor.WHITE).get());
                            output.accept(RSItemRegistry.TRAFFIC_CONE_ITEMS.get(DyeColor.ORANGE).get());
                            output.accept(RSItemRegistry.TRAFFIC_CONE_ITEMS.get(DyeColor.MAGENTA).get());
                            output.accept(RSItemRegistry.TRAFFIC_CONE_ITEMS.get(DyeColor.LIGHT_BLUE).get());
                            output.accept(RSItemRegistry.TRAFFIC_CONE_ITEMS.get(DyeColor.YELLOW).get());
                            output.accept(RSItemRegistry.TRAFFIC_CONE_ITEMS.get(DyeColor.LIME).get());
                            output.accept(RSItemRegistry.TRAFFIC_CONE_ITEMS.get(DyeColor.PINK).get());
                            output.accept(RSItemRegistry.TRAFFIC_CONE_ITEMS.get(DyeColor.GRAY).get());
                            output.accept(RSItemRegistry.TRAFFIC_CONE_ITEMS.get(DyeColor.LIGHT_GRAY).get());
                            output.accept(RSItemRegistry.TRAFFIC_CONE_ITEMS.get(DyeColor.CYAN).get());
                            output.accept(RSItemRegistry.TRAFFIC_CONE_ITEMS.get(DyeColor.PURPLE).get());
                            output.accept(RSItemRegistry.TRAFFIC_CONE_ITEMS.get(DyeColor.BLUE).get());
                            output.accept(RSItemRegistry.TRAFFIC_CONE_ITEMS.get(DyeColor.BROWN).get());
                            output.accept(RSItemRegistry.TRAFFIC_CONE_ITEMS.get(DyeColor.GREEN).get());
                            output.accept(RSItemRegistry.TRAFFIC_CONE_ITEMS.get(DyeColor.RED).get());
                            output.accept(RSItemRegistry.TRAFFIC_CONE_ITEMS.get(DyeColor.BLACK).get());

                            output.accept(RSItemRegistry.TRAFFIC_BARREL_ITEMS.get(DyeColor.WHITE).get());
                            output.accept(RSItemRegistry.TRAFFIC_BARREL_ITEMS.get(DyeColor.ORANGE).get());
                            output.accept(RSItemRegistry.TRAFFIC_BARREL_ITEMS.get(DyeColor.MAGENTA).get());
                            output.accept(RSItemRegistry.TRAFFIC_BARREL_ITEMS.get(DyeColor.LIGHT_BLUE).get());
                            output.accept(RSItemRegistry.TRAFFIC_BARREL_ITEMS.get(DyeColor.YELLOW).get());
                            output.accept(RSItemRegistry.TRAFFIC_BARREL_ITEMS.get(DyeColor.LIME).get());
                            output.accept(RSItemRegistry.TRAFFIC_BARREL_ITEMS.get(DyeColor.PINK).get());
                            output.accept(RSItemRegistry.TRAFFIC_BARREL_ITEMS.get(DyeColor.GRAY).get());
                            output.accept(RSItemRegistry.TRAFFIC_BARREL_ITEMS.get(DyeColor.LIGHT_GRAY).get());
                            output.accept(RSItemRegistry.TRAFFIC_BARREL_ITEMS.get(DyeColor.CYAN).get());
                            output.accept(RSItemRegistry.TRAFFIC_BARREL_ITEMS.get(DyeColor.PURPLE).get());
                            output.accept(RSItemRegistry.TRAFFIC_BARREL_ITEMS.get(DyeColor.BLUE).get());
                            output.accept(RSItemRegistry.TRAFFIC_BARREL_ITEMS.get(DyeColor.BROWN).get());
                            output.accept(RSItemRegistry.TRAFFIC_BARREL_ITEMS.get(DyeColor.GREEN).get());
                            output.accept(RSItemRegistry.TRAFFIC_BARREL_ITEMS.get(DyeColor.RED).get());
                            output.accept(RSItemRegistry.TRAFFIC_BARREL_ITEMS.get(DyeColor.BLACK).get());

                            output.accept(RSItemRegistry.TRAFFIC_BOLLARD_ITEMS.get(DyeColor.WHITE).get());
                            output.accept(RSItemRegistry.TRAFFIC_BOLLARD_ITEMS.get(DyeColor.ORANGE).get());
                            output.accept(RSItemRegistry.TRAFFIC_BOLLARD_ITEMS.get(DyeColor.MAGENTA).get());
                            output.accept(RSItemRegistry.TRAFFIC_BOLLARD_ITEMS.get(DyeColor.LIGHT_BLUE).get());
                            output.accept(RSItemRegistry.TRAFFIC_BOLLARD_ITEMS.get(DyeColor.YELLOW).get());
                            output.accept(RSItemRegistry.TRAFFIC_BOLLARD_ITEMS.get(DyeColor.LIME).get());
                            output.accept(RSItemRegistry.TRAFFIC_BOLLARD_ITEMS.get(DyeColor.PINK).get());
                            output.accept(RSItemRegistry.TRAFFIC_BOLLARD_ITEMS.get(DyeColor.GRAY).get());
                            output.accept(RSItemRegistry.TRAFFIC_BOLLARD_ITEMS.get(DyeColor.LIGHT_GRAY).get());
                            output.accept(RSItemRegistry.TRAFFIC_BOLLARD_ITEMS.get(DyeColor.CYAN).get());
                            output.accept(RSItemRegistry.TRAFFIC_BOLLARD_ITEMS.get(DyeColor.PURPLE).get());
                            output.accept(RSItemRegistry.TRAFFIC_BOLLARD_ITEMS.get(DyeColor.BLUE).get());
                            output.accept(RSItemRegistry.TRAFFIC_BOLLARD_ITEMS.get(DyeColor.BROWN).get());
                            output.accept(RSItemRegistry.TRAFFIC_BOLLARD_ITEMS.get(DyeColor.GREEN).get());
                            output.accept(RSItemRegistry.TRAFFIC_BOLLARD_ITEMS.get(DyeColor.RED).get());
                            output.accept(RSItemRegistry.TRAFFIC_BOLLARD_ITEMS.get(DyeColor.BLACK).get());

                            output.accept(RSItemRegistry.CYLINDRICAL_BOLLARD_ITEMS.get(DyeColor.WHITE).get());
                            output.accept(RSItemRegistry.CYLINDRICAL_BOLLARD_ITEMS.get(DyeColor.ORANGE).get());
                            output.accept(RSItemRegistry.CYLINDRICAL_BOLLARD_ITEMS.get(DyeColor.MAGENTA).get());
                            output.accept(RSItemRegistry.CYLINDRICAL_BOLLARD_ITEMS.get(DyeColor.LIGHT_BLUE).get());
                            output.accept(RSItemRegistry.CYLINDRICAL_BOLLARD_ITEMS.get(DyeColor.YELLOW).get());
                            output.accept(RSItemRegistry.CYLINDRICAL_BOLLARD_ITEMS.get(DyeColor.LIME).get());
                            output.accept(RSItemRegistry.CYLINDRICAL_BOLLARD_ITEMS.get(DyeColor.PINK).get());
                            output.accept(RSItemRegistry.CYLINDRICAL_BOLLARD_ITEMS.get(DyeColor.GRAY).get());
                            output.accept(RSItemRegistry.CYLINDRICAL_BOLLARD_ITEMS.get(DyeColor.LIGHT_GRAY).get());
                            output.accept(RSItemRegistry.CYLINDRICAL_BOLLARD_ITEMS.get(DyeColor.CYAN).get());
                            output.accept(RSItemRegistry.CYLINDRICAL_BOLLARD_ITEMS.get(DyeColor.PURPLE).get());
                            output.accept(RSItemRegistry.CYLINDRICAL_BOLLARD_ITEMS.get(DyeColor.BLUE).get());
                            output.accept(RSItemRegistry.CYLINDRICAL_BOLLARD_ITEMS.get(DyeColor.BROWN).get());
                            output.accept(RSItemRegistry.CYLINDRICAL_BOLLARD_ITEMS.get(DyeColor.GREEN).get());
                            output.accept(RSItemRegistry.CYLINDRICAL_BOLLARD_ITEMS.get(DyeColor.RED).get());
                            output.accept(RSItemRegistry.CYLINDRICAL_BOLLARD_ITEMS.get(DyeColor.BLACK).get());

                            output.accept(RSItemRegistry.GUARDRAIL_ITEMS.get(DyeColor.WHITE).get());
                            output.accept(RSItemRegistry.GUARDRAIL_ITEMS.get(DyeColor.ORANGE).get());
                            output.accept(RSItemRegistry.GUARDRAIL_ITEMS.get(DyeColor.MAGENTA).get());
                            output.accept(RSItemRegistry.GUARDRAIL_ITEMS.get(DyeColor.LIGHT_BLUE).get());
                            output.accept(RSItemRegistry.GUARDRAIL_ITEMS.get(DyeColor.YELLOW).get());
                            output.accept(RSItemRegistry.GUARDRAIL_ITEMS.get(DyeColor.LIME).get());
                            output.accept(RSItemRegistry.GUARDRAIL_ITEMS.get(DyeColor.PINK).get());
                            output.accept(RSItemRegistry.GUARDRAIL_ITEMS.get(DyeColor.GRAY).get());
                            output.accept(RSItemRegistry.GUARDRAIL_ITEMS.get(DyeColor.LIGHT_GRAY).get());
                            output.accept(RSItemRegistry.GUARDRAIL_ITEMS.get(DyeColor.CYAN).get());
                            output.accept(RSItemRegistry.GUARDRAIL_ITEMS.get(DyeColor.PURPLE).get());
                            output.accept(RSItemRegistry.GUARDRAIL_ITEMS.get(DyeColor.BLUE).get());
                            output.accept(RSItemRegistry.GUARDRAIL_ITEMS.get(DyeColor.BROWN).get());
                            output.accept(RSItemRegistry.GUARDRAIL_ITEMS.get(DyeColor.GREEN).get());
                            output.accept(RSItemRegistry.GUARDRAIL_ITEMS.get(DyeColor.RED).get());
                            output.accept(RSItemRegistry.GUARDRAIL_ITEMS.get(DyeColor.BLACK).get());

                            output.accept(RSItemRegistry.REFLECTOR_ITEMS.get(DyeColor.WHITE).get());
                            output.accept(RSItemRegistry.REFLECTOR_ITEMS.get(DyeColor.ORANGE).get());
                            output.accept(RSItemRegistry.REFLECTOR_ITEMS.get(DyeColor.MAGENTA).get());
                            output.accept(RSItemRegistry.REFLECTOR_ITEMS.get(DyeColor.LIGHT_BLUE).get());
                            output.accept(RSItemRegistry.REFLECTOR_ITEMS.get(DyeColor.YELLOW).get());
                            output.accept(RSItemRegistry.REFLECTOR_ITEMS.get(DyeColor.LIME).get());
                            output.accept(RSItemRegistry.REFLECTOR_ITEMS.get(DyeColor.PINK).get());
                            output.accept(RSItemRegistry.REFLECTOR_ITEMS.get(DyeColor.GRAY).get());
                            output.accept(RSItemRegistry.REFLECTOR_ITEMS.get(DyeColor.LIGHT_GRAY).get());
                            output.accept(RSItemRegistry.REFLECTOR_ITEMS.get(DyeColor.CYAN).get());
                            output.accept(RSItemRegistry.REFLECTOR_ITEMS.get(DyeColor.PURPLE).get());
                            output.accept(RSItemRegistry.REFLECTOR_ITEMS.get(DyeColor.BLUE).get());
                            output.accept(RSItemRegistry.REFLECTOR_ITEMS.get(DyeColor.BROWN).get());
                            output.accept(RSItemRegistry.REFLECTOR_ITEMS.get(DyeColor.GREEN).get());
                            output.accept(RSItemRegistry.REFLECTOR_ITEMS.get(DyeColor.RED).get());
                            output.accept(RSItemRegistry.REFLECTOR_ITEMS.get(DyeColor.BLACK).get());

                            output.accept(RSItemRegistry.LUMINESCENT_REFLECTOR_ITEMS.get(DyeColor.WHITE).get());
                            output.accept(RSItemRegistry.LUMINESCENT_REFLECTOR_ITEMS.get(DyeColor.ORANGE).get());
                            output.accept(RSItemRegistry.LUMINESCENT_REFLECTOR_ITEMS.get(DyeColor.MAGENTA).get());
                            output.accept(RSItemRegistry.LUMINESCENT_REFLECTOR_ITEMS.get(DyeColor.LIGHT_BLUE).get());
                            output.accept(RSItemRegistry.LUMINESCENT_REFLECTOR_ITEMS.get(DyeColor.YELLOW).get());
                            output.accept(RSItemRegistry.LUMINESCENT_REFLECTOR_ITEMS.get(DyeColor.LIME).get());
                            output.accept(RSItemRegistry.LUMINESCENT_REFLECTOR_ITEMS.get(DyeColor.PINK).get());
                            output.accept(RSItemRegistry.LUMINESCENT_REFLECTOR_ITEMS.get(DyeColor.GRAY).get());
                            output.accept(RSItemRegistry.LUMINESCENT_REFLECTOR_ITEMS.get(DyeColor.LIGHT_GRAY).get());
                            output.accept(RSItemRegistry.LUMINESCENT_REFLECTOR_ITEMS.get(DyeColor.CYAN).get());
                            output.accept(RSItemRegistry.LUMINESCENT_REFLECTOR_ITEMS.get(DyeColor.PURPLE).get());
                            output.accept(RSItemRegistry.LUMINESCENT_REFLECTOR_ITEMS.get(DyeColor.BLUE).get());
                            output.accept(RSItemRegistry.LUMINESCENT_REFLECTOR_ITEMS.get(DyeColor.BROWN).get());
                            output.accept(RSItemRegistry.LUMINESCENT_REFLECTOR_ITEMS.get(DyeColor.GREEN).get());
                            output.accept(RSItemRegistry.LUMINESCENT_REFLECTOR_ITEMS.get(DyeColor.RED).get());
                            output.accept(RSItemRegistry.LUMINESCENT_REFLECTOR_ITEMS.get(DyeColor.BLACK).get());
                        })
        );
    }
}


