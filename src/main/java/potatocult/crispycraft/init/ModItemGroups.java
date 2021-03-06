package potatocult.crispycraft.init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import potatocult.crispycraft.Main;
import java.util.function.Supplier;

public class ModItemGroups {

    public static final ItemGroup CRISPYCRAFTITEMS = new ModItemGroup(Main.MODID, () -> new ItemStack(ModItems.RUBY));

    public static class ModItemGroup extends ItemGroup {

        private final Supplier<ItemStack> iconSupplier;

        public ModItemGroup(final String name, final Supplier<ItemStack> iconSupplier) {
            super(name);
            this.iconSupplier = iconSupplier;
        }

        @Override
        public ItemStack createIcon() {
            return iconSupplier.get();
        }

    }
}
