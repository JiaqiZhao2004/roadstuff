package tv.mapper.roadstuff.util;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import static tv.mapper.roadstuff.world.level.block.RSBlockRegistry.nameToPaintableBlockMap;

public class BlockHelper {

    public static Block getUnpaintedBlock(BlockState state) {
        String newId = state.getBlock().getDescriptionId().replaceFirst("_[a-z]*_line_.*", "").replaceAll("^block.roadstuff.", "");
        return (nameToPaintableBlockMap.get(newId).get());
    }
}
