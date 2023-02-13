package tv.mapper.roadstuff.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import tv.mapper.roadstuff.world.level.block.state.properties.EnumPaintColor;

import static tv.mapper.roadstuff.world.level.block.RSBlockRegistry.nameToPaintableBlockMap;

public class ModColorHandler {
    public static void registerBlockColor() {
        final BlockColors blockColors = Minecraft.getInstance().getBlockColors();

        for (String key : nameToPaintableBlockMap.keySet()) {
            if (!key.matches(".*[0-9]$")) continue;
            Block block = nameToPaintableBlockMap.get(key).get();

            for (EnumPaintColor paintColor : EnumPaintColor.values()) {
                if (paintColor == EnumPaintColor.WHITE) continue;
                String color = paintColor.getSerializedName();
                if (block.getDescriptionId().contains(color + "_line")) {
                    final BlockColor blockColor = (state, blockAccess, pos, tintIndex) ->
                            DyeColor.valueOf(paintColor.getSerializedName().toUpperCase()).getFireworkColor();

                    blockColors.register(blockColor, block);
                }
            }
        }
    }
}