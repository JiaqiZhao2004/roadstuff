package tv.mapper.roadstuff.proxy;

import java.util.function.Predicate;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.RegistryObject;
import tv.mapper.roadstuff.util.ModColorHandler;
import tv.mapper.roadstuff.world.item.BrushItem;
import tv.mapper.roadstuff.world.item.RSItemRegistry;
import tv.mapper.roadstuff.world.level.block.RSBlockRegistry;

import static tv.mapper.roadstuff.world.level.block.RSBlockRegistry.nameToPaintableBlockMap;

public class ClientProxy implements IProxy {
    @Override
    public void setup(FMLCommonSetupEvent event) {
        ModColorHandler.registerBlockColor();

        Predicate<RenderType> cutoutPredicate = renderType -> renderType == RenderType.cutout();

        for (String key : nameToPaintableBlockMap.keySet()) {
            Block block = nameToPaintableBlockMap.get(key).get();
            ItemBlockRenderTypes.setRenderLayer(block, cutoutPredicate);
        }

        ItemBlockRenderTypes.setRenderLayer(RSBlockRegistry.PAINT_BUCKET.get(), cutoutPredicate);

        ItemProperties.register(RSItemRegistry.PAINT_BUCKET_ITEM.get(), new ResourceLocation("color"), (itemStack, world, entity, id) ->
        {
            if (itemStack.hasTag()) {
                CompoundTag nbt = itemStack.getTag();
                if (nbt.getInt("paint") == 0)
                    return 0.0f;
                return (nbt.getInt("color") + 1) * 0.5f;
            }
            return 0.0f;
        });

        for (RegistryObject<Item> item : RSItemRegistry.MOD_PAINTBRUSHES) {
            ItemProperties.register(item.get(), new ResourceLocation("color"), (itemStack, world, entity, id) ->
            {
                CompoundTag nbt = BrushItem.checkNBT(itemStack);
                if (nbt.getInt("paint") == 0)
                    return 0.0f;
                return (nbt.getInt("color") + 1) * 0.5f;
                //return 0.0f;
            });
        }
    }
}