package com.ironclad49er.meeples.init;

import com.ironclad49er.meeples.MeeplesMod;
import com.ironclad49er.meeples.item.ModdedSpawnEggItem;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Holds a list of all our {@link Item}s.
 * Suppliers that create Items are added to the DeferredRegister.
 * The DeferredRegister is then added to our mod event bus in our constructor.
 * When the Item Registry Event is fired by Forge and it is time for the mod to
 * register its Items, our Items are created and registered by the DeferredRegister.
 * The Item Registry Event will always be called after the Block registry is filled.
 * Note: This supports registry overrides.
 *
 * @author Cadiboo
 */
public final class Items {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, MeeplesMod.MODID);

    // This is a very simple Item. It has no special properties except for being on our creative tab.
    public static final RegistryObject<Item> EXAMPLE_CRYSTAL = ITEMS.register("example_crystal", () ->
            new Item(new Item.Properties().group(ItemGroups.MOD_ITEM_GROUP))
    );

    public static final RegistryObject<ModdedSpawnEggItem> MEEPLE_SPAWN_EGG = ITEMS.register("meeple_spawn_egg", () ->
            new ModdedSpawnEggItem(EntityTypes.MEEPLE, 0xF0A5A2, 0xA9672B, new Item.Properties().group(ItemGroups.MOD_ITEM_GROUP))
    );
}
