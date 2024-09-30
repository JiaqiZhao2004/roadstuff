package tv.mapper.roadstuff.world.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import tv.mapper.roadstuff.RoadStuff;
import tv.mapper.roadstuff.world.level.block.RSBlockRegistry;

public class ModCreativeModeTabs {

        // Create a DeferredRegister for CreativeModeTabs
        public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
                DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RoadStuff.MODID);

        // Register your custom tab
        public static RegistryObject<CreativeModeTab> ROAD_STUFF_TAB = CREATIVE_MODE_TABS.register("roadstuff_tab",
                () -> CreativeModeTab.builder()
                        .icon(() -> new ItemStack(RSBlockRegistry.TRAFFIC_CONE_BLOCKS.get(DyeColor.ORANGE).get())) // Set the icon for the tab
                        .title(Component.translatable("itemGroup.roadstuff_group"))
                        .withTabsAfter(CreativeModeTabs.SPAWN_EGGS)
                        .build()
        );

        public static void register(IEventBus modEventBus) {
                CREATIVE_MODE_TABS.register(modEventBus);
        }

}