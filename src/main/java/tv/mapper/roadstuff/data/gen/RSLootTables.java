package tv.mapper.roadstuff.data.gen;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.ExplosionCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import tv.mapper.mapperbase.data.gen.BaseLootTables;
import tv.mapper.mapperbase.world.level.block.SlopeBlock;
import tv.mapper.roadstuff.RoadStuff;
import tv.mapper.roadstuff.world.item.RSItemRegistry;
import tv.mapper.roadstuff.world.level.block.RSBlockRegistry;
import tv.mapper.roadstuff.world.level.block.PaintableSlopeBlock;

import static tv.mapper.roadstuff.util.BlockHelper.getUnpaintedBlock;
import static tv.mapper.roadstuff.world.level.block.RSBlockRegistry.nameToPaintableBlockMap;

public class RSLootTables extends BaseLootTables {
    public RSLootTables(DataGenerator generator, Set<ResourceLocation> lootTables, List<SubProviderEntry> subProviderEntryList) {
        super(generator, lootTables, subProviderEntryList);
    }

    @Override
    protected void addTables() {
        lootTables.put(RSBlockRegistry.CONCRETE.get(), createStandardTable(RoadStuff.MODID, RSBlockRegistry.CONCRETE.get()));
        lootTables.put(RSBlockRegistry.CONCRETE_SLAB.get(), createSlabTable(RoadStuff.MODID, RSBlockRegistry.CONCRETE_SLAB.get()));
        lootTables.put(RSBlockRegistry.CONCRETE_STAIRS.get(), createStandardTable(RoadStuff.MODID, RSBlockRegistry.CONCRETE_STAIRS.get()));
        lootTables.put(RSBlockRegistry.CONCRETE_WALL.get(), createStandardTable(RoadStuff.MODID, RSBlockRegistry.CONCRETE_WALL.get()));
        lootTables.put(RSBlockRegistry.CONCRETE_PRESSURE_PLATE.get(), createStandardTable(RoadStuff.MODID, RSBlockRegistry.CONCRETE_PRESSURE_PLATE.get()));
        lootTables.put(RSBlockRegistry.CONCRETE_FENCE.get(), createStandardTable(RoadStuff.MODID, RSBlockRegistry.CONCRETE_FENCE.get()));

        lootTables.put(RSBlockRegistry.ASPHALT_SLAB.get(), createSlabTable(RoadStuff.MODID, RSBlockRegistry.ASPHALT_SLAB.get()));
        lootTables.put(RSBlockRegistry.ASPHALT_STAIRS.get(), createStandardTable(RoadStuff.MODID, RSBlockRegistry.ASPHALT_STAIRS.get()));
        lootTables.put(RSBlockRegistry.ASPHALT_PRESSURE_PLATE.get(), createStandardTable(RoadStuff.MODID, RSBlockRegistry.ASPHALT_PRESSURE_PLATE.get()));

        lootTables.put(RSBlockRegistry.BITUMEN_BLOCK.get(), createStandardTable(RoadStuff.MODID, RSBlockRegistry.BITUMEN_BLOCK.get()));
        lootTables.put(RSBlockRegistry.BITUMEN_ORE.get(), createSilkTable(RoadStuff.MODID, RSBlockRegistry.BITUMEN_ORE.get(), RSItemRegistry.RAW_BITUMEN.get(), 3, 8, 2));

        for (String key : nameToPaintableBlockMap.keySet()) {
            Block block = nameToPaintableBlockMap.get(key).get();

            if (block instanceof PaintableSlopeBlock)
                lootTables.put(block, createSlopeTable(RoadStuff.MODID, block));
            else
                lootTables.put(block, createRoadBlockTable(RoadStuff.MODID, block));
        }

        for (int i = 0; i < Arrays.stream(DyeColor.values()).count(); i++) {
            lootTables.put(RSBlockRegistry.TRAFFIC_CONE_BLOCKS.get(DyeColor.byId(i)).get(), createStandardTable(RoadStuff.MODID, RSBlockRegistry.TRAFFIC_CONE_BLOCKS.get(DyeColor.byId(i)).get()));
            lootTables.put(RSBlockRegistry.TRAFFIC_BARREL_BLOCKS.get(DyeColor.byId(i)).get(), createStandardTable(RoadStuff.MODID, RSBlockRegistry.TRAFFIC_BARREL_BLOCKS.get(DyeColor.byId(i)).get()));
            lootTables.put(RSBlockRegistry.TRAFFIC_BOLLARD_BLOCKS.get(DyeColor.byId(i)).get(), createStandardTable(RoadStuff.MODID, RSBlockRegistry.TRAFFIC_BOLLARD_BLOCKS.get(DyeColor.byId(i)).get()));
            lootTables.put(RSBlockRegistry.CYLINDRICAL_BOLLARD_BLOCKS.get(DyeColor.byId(i)).get(), createStandardTable(RoadStuff.MODID, RSBlockRegistry.CYLINDRICAL_BOLLARD_BLOCKS.get(DyeColor.byId(i)).get()));
            lootTables.put(RSBlockRegistry.REFLECTOR_BLOCKS.get(DyeColor.byId(i)).get(), createStandardTable(RoadStuff.MODID, RSBlockRegistry.REFLECTOR_BLOCKS.get(DyeColor.byId(i)).get()));
            lootTables.put(RSBlockRegistry.LUMINESCENT_REFLECTOR_BLOCKS.get(DyeColor.byId(i)).get(), createStandardTable(RoadStuff.MODID, RSBlockRegistry.LUMINESCENT_REFLECTOR_BLOCKS.get(DyeColor.byId(i)).get()));
            lootTables.put(RSBlockRegistry.GUARDRAIL_BLOCKS.get(DyeColor.byId(i)).get(), createStandardTable(RoadStuff.MODID, RSBlockRegistry.GUARDRAIL_BLOCKS.get(DyeColor.byId(i)).get()));
        }

        lootTables.put(RSBlockRegistry.STEEL_GUARDRAIL.get(), createStandardTable(RoadStuff.MODID, RSBlockRegistry.STEEL_GUARDRAIL.get()));

        lootTables.put(RSBlockRegistry.YELLOW_BOLLARD.get(), createStandardTable(RoadStuff.MODID, RSBlockRegistry.YELLOW_BOLLARD.get()));
        lootTables.put(RSBlockRegistry.WHITE_BOLLARD.get(), createStandardTable(RoadStuff.MODID, RSBlockRegistry.WHITE_BOLLARD.get()));
        lootTables.put(RSBlockRegistry.RED_BOLLARD.get(), createStandardTable(RoadStuff.MODID, RSBlockRegistry.RED_BOLLARD.get()));
        lootTables.put(RSBlockRegistry.YELLOW_SMALL_BOLLARD.get(), createStandardTable(RoadStuff.MODID, RSBlockRegistry.YELLOW_SMALL_BOLLARD.get()));
        lootTables.put(RSBlockRegistry.WHITE_SMALL_BOLLARD.get(), createStandardTable(RoadStuff.MODID, RSBlockRegistry.WHITE_SMALL_BOLLARD.get()));
        lootTables.put(RSBlockRegistry.RED_SMALL_BOLLARD.get(), createStandardTable(RoadStuff.MODID, RSBlockRegistry.RED_SMALL_BOLLARD.get()));
    }

    protected LootTable.Builder createRoadBlockTable(String modid, Block block) {
        Block drop = getUnpaintedBlock(block.defaultBlockState());

        String name = block.getDescriptionId().toString().replace(modid + ":", "");
        LootPool.Builder builder = LootPool.lootPool().setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(drop)).when(ExplosionCondition.survivesExplosion());
        return LootTable.lootTable().withPool(builder);
    }

    protected LootTable.Builder createSlopeTable(String modid, Block block) {
        String name = block.getDescriptionId().toString().replace(modid + ":", "");
        Block drop = getUnpaintedBlock(block.defaultBlockState());

        LootPool.Builder builder = LootPool.lootPool().setRolls(ConstantValue.exactly(1)).add(withExplosionDecay(block, LootItem.lootTableItem(drop).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SlopeBlock.LAYERS, 2)))).apply(SetItemCountFunction.setCount(ConstantValue.exactly(3)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SlopeBlock.LAYERS, 3)))).apply(SetItemCountFunction.setCount(ConstantValue.exactly(4)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SlopeBlock.LAYERS, 4))))));
        return LootTable.lootTable().withPool(builder);
    }
}