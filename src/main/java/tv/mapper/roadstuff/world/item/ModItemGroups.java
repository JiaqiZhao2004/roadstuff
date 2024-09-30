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
        event.registerCreativeModeTab(new ResourceLocation(RoadStuff.MODID, "roadstuff"), builder ->
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

                            RSItemRegistry.TRAFFIC_CONE_ITEMS.values().forEach(item -> output.accept(item.get()));
                            RSItemRegistry.TRAFFIC_BARREL_ITEMS.values().forEach(item -> output.accept(item.get()));
                            RSItemRegistry.TRAFFIC_BOLLARD_ITEMS.values().forEach(item -> output.accept(item.get()));
                            RSItemRegistry.CYLINDRICAL_BOLLARD_ITEMS.values().forEach(item -> output.accept(item.get()));
                            RSItemRegistry.GUARDRAIL_ITEMS.values().forEach(item -> output.accept(item.get()));
                            RSItemRegistry.REFLECTOR_ITEMS.values().forEach(item -> output.accept(item.get()));
                            RSItemRegistry.LUMINESCENT_REFLECTOR_ITEMS.values().forEach(item -> output.accept(item.get()));

                            output.accept(RSBlockRegistry.CONCRETE.get());
                            output.accept(RSBlockRegistry.CONCRETE_STAIRS.get());
                            output.accept(RSBlockRegistry.CONCRETE_SLAB.get());
                            output.accept(RSBlockRegistry.CONCRETE_WALL.get());
                            output.accept(RSBlockRegistry.CONCRETE_FENCE.get());
                            output.accept(RSBlockRegistry.CONCRETE_FENCE_GATE.get());
                            output.accept(RSBlockRegistry.CONCRETE_SLOPE.get());
                            output.accept(RSBlockRegistry.ASPHALT.get());
                            output.accept(RSBlockRegistry.ASPHALT_STAIRS.get());
                            output.accept(RSBlockRegistry.ASPHALT_SLAB.get());
                            output.accept(RSBlockRegistry.ASPHALT_SLOPE.get());
                            output.accept(RSBlockRegistry.RED_ASPHALT.get());
                            output.accept(RSBlockRegistry.RED_ASPHALT_SLOPE.get());
                            output.accept(RSBlockRegistry.GREEN_ASPHALT.get());
                            output.accept(RSBlockRegistry.GREEN_ASPHALT_SLOPE.get());
                            output.accept(RSBlockRegistry.BLUE_ASPHALT.get());
                            output.accept(RSBlockRegistry.BLUE_ASPHALT_SLOPE.get());
                            output.accept(RSBlockRegistry.YELLOW_ASPHALT.get());
                            output.accept(RSBlockRegistry.YELLOW_ASPHALT_SLOPE.get());
                            output.accept(RSBlockRegistry.BITUMEN_BLOCK.get());
                            output.accept(RSBlockRegistry.BITUMEN_ORE.get());
                            output.accept(RSBlockRegistry.YELLOW_BOLLARD.get());
                            output.accept(RSBlockRegistry.WHITE_BOLLARD.get());
                            output.accept(RSBlockRegistry.RED_BOLLARD.get());
                            output.accept(RSBlockRegistry.YELLOW_SMALL_BOLLARD.get());
                            output.accept(RSBlockRegistry.WHITE_SMALL_BOLLARD.get());
                            output.accept(RSBlockRegistry.RED_SMALL_BOLLARD.get());
                            output.accept(RSBlockRegistry.STEEL_GUARDRAIL.get());
                            output.accept(RSBlockRegistry.PAINT_BUCKET.get());
                            output.accept(RSBlockRegistry.ASPHALT_PRESSURE_PLATE.get());
                            output.accept(RSBlockRegistry.CONCRETE_PRESSURE_PLATE.get());

                            RSBlockRegistry.TRAFFIC_CONE_BLOCKS.values().forEach(item -> output.accept(item.get()));
                            RSBlockRegistry.TRAFFIC_BARREL_BLOCKS.values().forEach(item -> output.accept(item.get()));
                            RSBlockRegistry.TRAFFIC_BOLLARD_BLOCKS.values().forEach(item -> output.accept(item.get()));
                            RSBlockRegistry.CYLINDRICAL_BOLLARD_BLOCKS.values().forEach(item -> output.accept(item.get()));
                            RSBlockRegistry.REFLECTOR_BLOCKS.values().forEach(item -> output.accept(item.get()));
                            RSBlockRegistry.LUMINESCENT_REFLECTOR_BLOCKS.values().forEach(item -> output.accept(item.get()));
                            RSBlockRegistry.GUARDRAIL_BLOCKS.values().forEach(item -> output.accept(item.get()));
                        })
        );
    }
}


