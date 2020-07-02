package com.ironclad49er.meeples.config;

import net.minecraftforge.fml.config.ModConfig;

/**
 * This registers the config values to normal fields
 *
 * @author Cadiboo
 */
public final class ConfigHelper {

    public static void storeClientConfig(final ModConfig config) {
        Config.clientBoolean = Sides.CLIENT.clientBoolean.get();
        Config.clientStringList = Sides.CLIENT.clientStringList.get();
        Config.clientDyeColorEnum = Sides.CLIENT.clientDyeColorEnum.get();

        Config.modelTranslucency = Sides.CLIENT.modelTranslucency.get();
        Config.modelScale = Sides.CLIENT.modelScale.get().floatValue();
    }

    public static void storeServerConfig(final ModConfig config) {
        Config.serverBoolean = Sides.SERVER.serverBoolean.get();
        Config.serverStringList = Sides.SERVER.serverStringList.get();
        Config.serverEnumDyeColor = Sides.SERVER.serverEnumDyeColor.get();

        Config.electricFurnaceEnergySmeltCostPerTick = Sides.SERVER.electricFurnaceEnergySmeltCostPerTick.get();
        Config.heatCollectorTransferAmountPerTick = Sides.SERVER.heatCollectorTransferAmountPerTick.get();
    }
}
