package tv.mapper.roadstuff.data.gen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tv.mapper.roadstuff.RoadStuff;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RSGenerators
{
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        String modid = RoadStuff.MODID;
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(true,new RSRecipes(generator));
        generator.addProvider(true,new RSLootTables(generator));
        generator.addProvider(true,new RSBlockStates(generator, modid, existingFileHelper));
        generator.addProvider(true,new RSBlockModels(generator, modid, existingFileHelper));
        generator.addProvider(true,new RSItemModels(generator, modid, existingFileHelper));

        RSBlockTags rsBlockTags = new RSBlockTags(generator, modid, existingFileHelper);

        generator.addProvider(true,rsBlockTags);
        generator.addProvider(true,new RSItemTags(generator, rsBlockTags, existingFileHelper));
        generator.addProvider(true,new RSLang(generator, modid, "en_us"));
        generator.addProvider(true,new RSLang(generator, modid, "fr_fr"));
    }
}