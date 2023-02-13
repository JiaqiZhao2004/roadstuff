package tv.mapper.roadstuff.data.gen;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.minecraft.core.Direction;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CrossCollisionBlock;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelFile.UncheckedModelFile;
import net.minecraftforge.client.model.generators.MultiPartBlockStateBuilder;
import net.minecraftforge.client.model.generators.VariantBlockStateBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import tv.mapper.mapperbase.data.gen.BaseBlockStates;
import tv.mapper.roadstuff.RoadStuff;
import tv.mapper.roadstuff.world.level.block.PaintBucketBlock;
import tv.mapper.roadstuff.world.level.block.PaintSystem;
import tv.mapper.roadstuff.world.level.block.RSBlockRegistry;
import tv.mapper.roadstuff.world.level.block.PaintableSlopeBlock;
import tv.mapper.roadstuff.world.level.block.state.properties.EnumPaintColor;

import static tv.mapper.roadstuff.util.BlockHelper.getUnpaintedBlock;
import static tv.mapper.roadstuff.world.level.block.RSBlockRegistry.nameToPaintableBlockMap;

public class RSBlockStates extends BaseBlockStates {
    public RSBlockStates(DataGenerator gen, String modid, ExistingFileHelper exFileHelper) {
        super(gen, modid, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(RSBlockRegistry.CONCRETE.get());
        slopeBlock(RSBlockRegistry.CONCRETE_SLOPE.get(), "concrete", RoadStuff.MODID);

        slabBlock(RSBlockRegistry.CONCRETE_SLAB.get(), modLoc("block/concrete"), modLoc("block/concrete"), modLoc("block/concrete"), modLoc("block/concrete"));
        stairsBlock(RSBlockRegistry.CONCRETE_STAIRS.get(), modLoc("block/concrete"), modLoc("block/concrete"), modLoc("block/concrete"));
        newWallBlock(RSBlockRegistry.CONCRETE_WALL.get(), new UncheckedModelFile(RoadStuff.MODID + ":block/concrete_wall_post"), new UncheckedModelFile(RoadStuff.MODID + ":block/concrete_wall_side"), new UncheckedModelFile(RoadStuff.MODID + ":block/concrete_wall_side_tall"));
        pressurePlateBlock(RSBlockRegistry.CONCRETE_PRESSURE_PLATE.get(), new UncheckedModelFile(RoadStuff.MODID + ":block/concrete_pressure_plate"), new UncheckedModelFile(RoadStuff.MODID + ":block/concrete_pressure_plate_down"));
        fenceBlock(RSBlockRegistry.CONCRETE_FENCE.get(), modLoc("block/concrete"));
        fenceGateBlock(RSBlockRegistry.CONCRETE_FENCE_GATE.get(), modLoc("block/concrete"));

        simpleBlock(RSBlockRegistry.ASPHALT.get());
        slopeBlock(RSBlockRegistry.ASPHALT_SLOPE.get(), RSBlockRegistry.ASPHALT.getKey().location().getPath(), RoadStuff.MODID);

        slabBlock(RSBlockRegistry.ASPHALT_SLAB.get(), modLoc("block/asphalt"), modLoc("block/asphalt"), modLoc("block/asphalt"), modLoc("block/asphalt"));
        stairsBlock(RSBlockRegistry.ASPHALT_STAIRS.get(), modLoc("block/asphalt"), modLoc("block/asphalt"), modLoc("block/asphalt"));
        pressurePlateBlock(RSBlockRegistry.ASPHALT_PRESSURE_PLATE.get(), new UncheckedModelFile(RoadStuff.MODID + ":block/asphalt_pressure_plate"), new UncheckedModelFile(RoadStuff.MODID + ":block/asphalt_pressure_plate_down"));

        simpleBlock(RSBlockRegistry.RED_ASPHALT.get());
        slopeBlock(RSBlockRegistry.RED_ASPHALT_SLOPE.get(), RSBlockRegistry.RED_ASPHALT.getKey().location().getPath(), RoadStuff.MODID);

        simpleBlock(RSBlockRegistry.GREEN_ASPHALT.get());
        slopeBlock(RSBlockRegistry.GREEN_ASPHALT_SLOPE.get(), RSBlockRegistry.GREEN_ASPHALT.getKey().location().getPath(), RoadStuff.MODID);

        simpleBlock(RSBlockRegistry.BLUE_ASPHALT.get());
        slopeBlock(RSBlockRegistry.BLUE_ASPHALT_SLOPE.get(), RSBlockRegistry.BLUE_ASPHALT.getKey().location().getPath(), RoadStuff.MODID);

        simpleBlock(RSBlockRegistry.YELLOW_ASPHALT.get());
        slopeBlock(RSBlockRegistry.YELLOW_ASPHALT_SLOPE.get(), RSBlockRegistry.YELLOW_ASPHALT.getKey().location().getPath(), RoadStuff.MODID);

        for (String key : nameToPaintableBlockMap.keySet()) {
            Block block = nameToPaintableBlockMap.get(key).get();

            if (block instanceof PaintSystem) {
                String mat, number;
                mat = getUnpaintedBlock(block.defaultBlockState()).getDescriptionId().replace("_slope", "").replaceAll("^block.roadstuff.", "");

                Pattern p = Pattern.compile("\\d+$");
                Matcher m = p.matcher(block.getDescriptionId());
                if (m.find()) number = m.group();
                else continue;

                if (block instanceof PaintableSlopeBlock) {
                    VariantBlockStateBuilder builder = getVariantBuilder(block);
                    String modelName = "";

                    for (Direction dir : Direction.Plane.HORIZONTAL) {
                        for (int i = 1; i < 9; i++) {
                            modelName = i == 8 ? RoadStuff.MODID + ":block/" + mat + "_line_" + number : RoadStuff.MODID + ":block/" + mat + "_slope_" + i * 2 + "_line_" + number;

                            builder.partialState().with(PaintableSlopeBlock.DIRECTION, dir).with(PaintableSlopeBlock.LAYERS, i).modelForState().modelFile(new UncheckedModelFile(modelName)).rotationY((int) ((dir.toYRot() + 180) % 360)).addModel();
                        }
                    }
                } else
                    horizontalBlock(block, new UncheckedModelFile(RoadStuff.MODID + ":block/" + mat + "_line_" + number), 180);
            }
        }

        simpleBlock(RSBlockRegistry.BITUMEN_ORE.get());
        simpleBlock(RSBlockRegistry.BITUMEN_BLOCK.get());

        for (int i = 0; i < Arrays.stream(DyeColor.values()).count(); i++) {
            simpleBlock(RSBlockRegistry.TRAFFIC_CONE_BLOCKS.get(DyeColor.byId(i)).get(), new UncheckedModelFile(RoadStuff.MODID + ":block/" + DyeColor.byId(i).getSerializedName() + "_traffic_cone"));
            simpleBlock(RSBlockRegistry.TRAFFIC_BARREL_BLOCKS.get(DyeColor.byId(i)).get(), new UncheckedModelFile(RoadStuff.MODID + ":block/" + DyeColor.byId(i).getSerializedName() + "_traffic_barrel"));
            simpleBlock(RSBlockRegistry.TRAFFIC_BOLLARD_BLOCKS.get(DyeColor.byId(i)).get(), new UncheckedModelFile(RoadStuff.MODID + ":block/" + DyeColor.byId(i).getSerializedName() + "_traffic_bollard"));
            simpleBlock(RSBlockRegistry.CYLINDRICAL_BOLLARD_BLOCKS.get(DyeColor.byId(i)).get(), new UncheckedModelFile(RoadStuff.MODID + ":block/" + DyeColor.byId(i).getSerializedName() + "_cylindrical_bollard"));
            horizontalBlock(RSBlockRegistry.REFLECTOR_BLOCKS.get(DyeColor.byId(i)).get(), new UncheckedModelFile(RoadStuff.MODID + ":block/" + DyeColor.byId(i).getSerializedName() + "_reflector"), 0);
            horizontalBlock(RSBlockRegistry.LUMINESCENT_REFLECTOR_BLOCKS.get(DyeColor.byId(i)).get(), new UncheckedModelFile(RoadStuff.MODID + ":block/" + DyeColor.byId(i).getSerializedName() + "_reflector"), 0);
            guardrailBlock(RSBlockRegistry.GUARDRAIL_BLOCKS.get(DyeColor.byId(i)).get(), new UncheckedModelFile(RoadStuff.MODID + ":block/" + DyeColor.byId(i).getSerializedName() + "_guardrail_post"), new UncheckedModelFile(RoadStuff.MODID + ":block/" + DyeColor.byId(i).getSerializedName() + "_guardrail_side"));
        }

        guardrailBlock(RSBlockRegistry.STEEL_GUARDRAIL.get(), new UncheckedModelFile(RoadStuff.MODID + ":block/steel_guardrail_post"), new UncheckedModelFile(RoadStuff.MODID + ":block/steel_guardrail_side"));

        horizontalBlock(RSBlockRegistry.YELLOW_BOLLARD.get(), new UncheckedModelFile(RoadStuff.MODID + ":block/yellow_bollard"), 180);
        horizontalBlock(RSBlockRegistry.WHITE_BOLLARD.get(), new UncheckedModelFile(RoadStuff.MODID + ":block/white_bollard"), 180);
        horizontalBlock(RSBlockRegistry.RED_BOLLARD.get(), new UncheckedModelFile(RoadStuff.MODID + ":block/red_bollard"), 180);

        horizontalBlock(RSBlockRegistry.YELLOW_SMALL_BOLLARD.get(), new UncheckedModelFile(RoadStuff.MODID + ":block/yellow_small_bollard"), 180);
        horizontalBlock(RSBlockRegistry.WHITE_SMALL_BOLLARD.get(), new UncheckedModelFile(RoadStuff.MODID + ":block/white_small_bollard"), 180);
        horizontalBlock(RSBlockRegistry.RED_SMALL_BOLLARD.get(), new UncheckedModelFile(RoadStuff.MODID + ":block/red_small_bollard"), 180);

        paintBucketBlock(RSBlockRegistry.PAINT_BUCKET.get(), 0);
    }

    protected void rotatableSlopeBlock(Block block, String name, String pattern, int offset) {

    }

    protected void paintBucketBlock(Block block, int offset) {
        VariantBlockStateBuilder builder = getVariantBuilder(block);
        String modelName = "";

        for (EnumPaintColor paintColor : EnumPaintColor.values()) {
            for (Direction dir : Direction.Plane.HORIZONTAL) {
                for (int i = 0; i < 9; i++) {
                    modelName = i == 0 ? RoadStuff.MODID + ":block/paint_bucket" : RoadStuff.MODID + ":block/paint_bucket_" + paintColor.getSerializedName() + "_" + i;
                    builder.partialState().with(PaintBucketBlock.COLOR, paintColor).with(PaintBucketBlock.DIRECTION, dir).with(PaintBucketBlock.CURRENT_PAINT_LEVEL, i).modelForState().modelFile(new UncheckedModelFile(modelName)).rotationY((int) ((dir.toYRot() + offset) % 360)).addModel();

                    // modelName = i == 0 ? RoadStuff.MODID + ":block/paint_bucket" : RoadStuff.MODID + ":block/paint_bucket_yellow_" + i;
                    // builder.partialState().with(PaintBucketBlock.COLOR, EnumPaintColor.YELLOW).with(PaintBucketBlock.DIRECTION, dir).with(PaintBucketBlock.PAINT, i).modelForState().modelFile(new UncheckedModelFile(modelName)).rotationY((int)((dir.toYRot() + offset) % 360)).addModel();
                }
            }
        }
    }

    public void guardrailBlock(CrossCollisionBlock block, ModelFile post, ModelFile side) {
        MultiPartBlockStateBuilder builder = getMultipartBuilder(block).part().modelFile(post).addModel().end();
        guardrailBlock(builder, side);
    }

    public void guardrailBlock(MultiPartBlockStateBuilder builder, ModelFile side) {
        PipeBlock.PROPERTY_BY_DIRECTION.forEach((dir, value) -> {
            if (dir.getAxis().isHorizontal()) {
                builder.part().modelFile(side).rotationY((((int) dir.toYRot()) + 180) % 360).addModel().condition(value, true);
            }
        });
    }
}