package potatocult.crispycraft;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.IForgeRegistryEntry;
import potatocult.crispycraft.init.ModItemGroups;
import potatocult.crispycraft.Main;

import static potatocult.crispycraft.init.BlockInit.ruby_block;
import static potatocult.crispycraft.init.ModItems.RUBY_BLOCK;


@EventBusSubscriber(modid = Main.MODID, bus = EventBusSubscriber.Bus.MOD)
public final class ModEventSubscriber {

    @SubscribeEvent
    public static void onRegisterItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                setup(new Item(new Item.Properties().group(ModItemGroups.CRISPYCRAFTITEMS)), "ruby")
        );
    }
    @SubscribeEvent
    public static void onRegisterBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(
                setup(new Block(Block.Properties.create(Material.IRON)
                        .hardnessAndResistance(6.0F, 60F)
                        .harvestLevel(2)
                        .harvestTool(ToolType.PICKAXE)
                        .sound(SoundType.METAL))
                        , "ruby_block")
        );

    }
    @SubscribeEvent
    public static void onRegisterBlockItems(RegistryEvent.Register<Item> event){
        event.getRegistry().registerAll(
                new BlockItem(
                        ruby_block, new Item.Properties()
                        .group(ModItemGroups.CRISPYCRAFTITEMS))
                        .setRegistryName("ruby_block")
        );
    }
    public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name) {
        return setup(entry, new ResourceLocation(Main.MODID, name));
    }

    public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final ResourceLocation registryName) {
        entry.setRegistryName(registryName);
        return entry;
    }
}