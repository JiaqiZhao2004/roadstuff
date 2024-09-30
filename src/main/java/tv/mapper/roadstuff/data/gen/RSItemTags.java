package tv.mapper.roadstuff.data.gen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import org.jetbrains.annotations.NotNull;
import tv.mapper.roadstuff.data.RSTags;
import tv.mapper.roadstuff.world.item.RSItemRegistry;

public class RSItemTags extends ItemTagsProvider
{
    public RSItemTags(GatherDataEvent event, RSBlockTags blockTagProvider, String modId, ExistingFileHelper existingFileHelper)
    {
        super(event.getGenerator().getPackOutput(), event.getLookupProvider(), blockTagProvider.contentsGetter(), modId, existingFileHelper);
    }

    public void addTags(HolderLookup.@NotNull Provider provider)
    {
        this.tag(RSTags.Items.ASPHALT).add(RSItemRegistry.ASPHALT_ITEM.get());
        this.tag(RSTags.Items.CONCRETE).add(RSItemRegistry.CONCRETE_ITEM.get());
        this.tag(RSTags.Items.ASPHALT_ROAD).add(RSItemRegistry.ASPHALT_ITEM.get(), RSItemRegistry.ASPHALT_SLOPE_ITEM.get());
        this.tag(RSTags.Items.CONCRETE_ROAD).add(RSItemRegistry.CONCRETE_ITEM.get(), RSItemRegistry.CONCRETE_SLOPE_ITEM.get());
        copy(RSTags.Blocks.REFLECTORS, RSTags.Items.REFLECTORS);

        copy(RSTags.ForgeBlocks.ORES_BITUMEN, RSTags.ForgeItems.ORES_BITUMEN);
        copy(RSTags.ForgeBlocks.STORAGE_BLOCKS_BITUMEN, RSTags.ForgeItems.STORAGE_BLOCKS_BITUMEN);
        tag(RSTags.ForgeItems.BITUMEN).add(RSItemRegistry.RAW_BITUMEN.get());
        tag(ItemTags.COALS).add(RSItemRegistry.BITUMINOUS_COAL.get());
    }
}