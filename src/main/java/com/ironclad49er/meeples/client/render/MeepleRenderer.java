package com.ironclad49er.meeples.client.render;

import com.ironclad49er.meeples.MeeplesMod;
import com.ironclad49er.meeples.entity.MeepleEntity;

import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class MeepleRenderer extends MobRenderer<MeepleEntity, MeepleModel<MeepleEntity>> {
    private static final ResourceLocation TEXTURES = new ResourceLocation(MeeplesMod.MODID, "textures/entity/meeple.png");

    public MeepleRenderer(final EntityRendererManager manager) {
        super(manager, new MeepleModel<>(), /*shadow size*/0.4F);
    }

    @Override
    public ResourceLocation getEntityTexture(final MeepleEntity entity) {
        return TEXTURES;
    }

    protected void applyRotations(MeepleEntity entity, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entity, ageInTicks, rotationYaw, partialTicks);
        /*if (!((double)entity.limbSwingAmount < 0.01D)) {
            float f1 = entity.limbSwing - entity.limbSwingAmount * (1.0F - partialTicks) + 6.0F;
            float f2 = (Math.abs(f1 % 13.0F - 6.5F) - 3.25F) / 3.25F;
            GlStateManager.rotatef(6.5F * f2, 0.0F, 0.0F, 1.0F);
        }*/
    }
}