package com.ironclad49er.meeples;

import com.ironclad49er.meeples.init.EntityTypes;
import com.ironclad49er.meeples.config.Sides;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.IEventBus;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(MeeplesMod.MODID)
public class MeeplesMod {
    public static final String MODID = "meeples";
    public static final Logger LOGGER = LogManager.getLogger();

    public MeeplesMod() {
        final ModLoadingContext modLoadingContext = ModLoadingContext.get();
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        EntityTypes.ENTITY_TYPES.register(modEventBus);

        modLoadingContext.registerConfig(ModConfig.Type.CLIENT, Sides.CLIENT_SPEC);
        modLoadingContext.registerConfig(ModConfig.Type.SERVER, Sides.SERVER_SPEC);
    }
}
