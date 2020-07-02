package com.ironclad49er.meeples.init;

import com.ironclad49er.meeples.MeeplesMod;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

/**
 * This class holds all our ItemGroups (Formerly called CreativeTabs).
 * Static initialisers are fine here.
 *
 * @author Cadiboo
 */
public final class ItemGroups {
    public static final ItemGroup MOD_ITEM_GROUP = new ModItemGroup(MeeplesMod.MODID, () -> new ItemStack(Items.EXAMPLE_CRYSTAL.get()));

    public static final class ModItemGroup extends ItemGroup {
        @Nonnull
        private final Supplier<ItemStack> iconSupplier;

        public ModItemGroup(@Nonnull final String name, @Nonnull final Supplier<ItemStack> iconSupplier) {
            super(name);
            this.iconSupplier = iconSupplier;
        }

        @Override
        @Nonnull
        public ItemStack createIcon() { return iconSupplier.get(); }
    }
}