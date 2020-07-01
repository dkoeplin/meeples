package com.ironclad49er.meeples.init;

import com.ironclad49er.meeples.MeeplesMod;
import com.ironclad49er.meeples.entity.MeepleEntity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.util.ResourceLocation;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.RegistryObject;

public final class Entities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES, MeeplesMod.MODID);

    public static final String MEEPLE_NAME = "meeple";
    public static final RegistryObject<EntityType<MeepleEntity>> MEEPLE_TYPE = ENTITY_TYPES.register(MEEPLE_NAME, () ->
            EntityType.Builder.create(MeepleEntity::new, EntityClassification.CREATURE)
                    .size(EntityType.PIG.getWidth(), EntityType.PIG.getHeight())
                    .build(new ResourceLocation(MeeplesMod.MODID, MEEPLE_NAME).toString())
    );
}
