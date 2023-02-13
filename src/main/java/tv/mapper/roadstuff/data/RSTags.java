package tv.mapper.roadstuff.data;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import tv.mapper.roadstuff.RoadStuff;

public class RSTags
{
    public static class Blocks
    {
        public static final TagKey<Block> CONCRETE_ROAD = tag("concrete_road");
        public static final TagKey<Block> ASPHALT_ROAD = tag("asphalt_road");
        public static final TagKey<Block> REFLECTORS = tag("reflectors");
        public static final TagKey<Block> CONCRETE = tag("concrete");
        public static final TagKey<Block> ASPHALT = tag("asphalt");

        private static TagKey<Block> tag(String name)
        {
            return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(RoadStuff.MODID,name));

          //  return BlockTags.bind(new ResourceLocation(RoadStuff.MODID, name).toString());
        }
    }

    public static class Items
    {
        public static final TagKey<Item> CONCRETE_ROAD = tag("concrete_road");
        public static final TagKey<Item> ASPHALT_ROAD = tag("asphalt_road");
        public static final TagKey<Item> REFLECTORS = tag("reflectors");
        public static final TagKey<Item> CONCRETE = tag("concrete");
        public static final TagKey<Item> ASPHALT = tag("asphalt");

        private static TagKey<Item> tag(String name)
        {
            return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(RoadStuff.MODID,name));

       //     return ItemTags.bind(new ResourceLocation(RoadStuff.MODID, name).toString());
        }
    }

    public static class ForgeBlocks
    {
        public static final TagKey<Block> STORAGE_BLOCKS_BITUMEN = tag("storage_blocks/bitumen");
        public static final TagKey<Block> ORES_BITUMEN = tag("ores/bitumen");

        private static TagKey<Block> tag(String name)
        {
            return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation("forge",name));

           // return BlockTags.bind(new ResourceLocation("forge", name).toString());
        }
    }

    public static class ForgeItems
    {
        public static final TagKey<Item> STORAGE_BLOCKS_BITUMEN = tag("storage_blocks/bitumen");
        public static final TagKey<Item> ORES_BITUMEN = tag("ores/bitumen");

        public static final TagKey<Item> BITUMEN = tag("bitumen");

        private static TagKey<Item> tag(String name)
        {
            return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge",name));

         //   return ItemTags.bind(new ResourceLocation("forge", name).toString());
        }
    }
}