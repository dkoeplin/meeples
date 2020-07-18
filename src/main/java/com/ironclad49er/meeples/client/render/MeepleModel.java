package com.ironclad49er.meeples.client.render;

import com.ironclad49er.meeples.entity.MeepleEntity;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.util.math.MathHelper;

public class MeepleModel<T extends MeepleEntity> extends EntityModel<T> {
    //protected RendererModel head;
    /*protected RendererModel body;
    protected RendererModel leftArm;
    protected RendererModel rightArm;
    protected RendererModel leftLeg;
    protected RendererModel rightLeg;*/

    protected RendererModel head;
    protected RendererModel body;
    protected RendererModel leftLeg;
    protected RendererModel rightLeg;
    protected RendererModel leftArm;
    protected RendererModel rightArm;

    protected RendererModel leftEye;
    protected RendererModel rightEye;

    public MeepleModel() { this(0.0f); }

    public MeepleModel(float scale) {
        int height = 4;
        this.head = new RendererModel(this, 32, 0);
        //this.head.setTextureSize(8, 8);
        this.head.addBox(-2.0F, 0.0F, -2.0F, 4, 4, 3, scale);
        this.head.setRotationPoint(0.0F, 10.0f, 0.0F);

        this.leftEye = new RendererModel(this, 0, 16);
        this.leftEye.setTextureSize(8, 8);
        this.leftEye.addBox(-1.0F, 0.0F, -0.5F, 2, 2, 1, scale * 0.5f);
        this.leftEye.setRotationPoint(-1.5f, 1.5f, -2.0f);

        this.rightEye = new RendererModel(this, 0, 16);
        this.rightEye.setTextureSize(8, 8);
        this.rightEye.addBox(-1.0F, 0.0F, -0.5F, 2, 2, 1, scale * 0.5F);
        this.rightEye.setRotationPoint(1.5f, 1.5f, -2.0f);

        head.addChild(leftEye);
        head.addChild(rightEye);

        this.body = new RendererModel(this, 32, 0);
        this.body.addBox(-3.0F, 0.0F, -1.5F, 6, 6, 3, scale);
        this.body.setRotationPoint(0.0F, 14.0f, 0.0F);

        this.leftLeg = new RendererModel(this, 32, 0);
        this.leftLeg.addBox(-2.5F, 0.0F, -1.0F, 2, height, 2, scale);
        this.leftLeg.setRotationPoint(-0.5F, 20.0f, 0.0F);

        this.rightLeg = new RendererModel(this, 32, 0);
        this.rightLeg.addBox(0.5F, 0.0F, -1.0F, 2, height, 2, scale);
        this.rightLeg.setRotationPoint(0.5F, 20.0f, 0.0F);

        this.leftArm = new RendererModel(this, 32, 0);
        this.leftArm.addBox(-1.0F, 0.0F, -0.5F, 1, 6, 1, scale);
        this.leftArm.setRotationPoint(-3.0F, 14.5f, 0.0F);

        this.rightArm = new RendererModel(this, 32, 0);
        this.rightArm.addBox(0.0F, 0.0F, -0.5F, 1, 6, 1, scale);
        this.rightArm.setRotationPoint(3.0F, 14.5f, 0.0F);
    }

    public void render(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        setRotationAngles(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        this.head.render(scale);
        this.body.render(scale);
        this.leftLeg.render(scale);
        this.rightLeg.render(scale);
        this.leftArm.render(scale);
        this.rightArm.render(scale);
    }

    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
          this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
          this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
          //this.body.rotateAngleX = ((float)Math.PI / 2F);
          this.leftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
          this.rightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
          this.leftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
          this.rightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }

    /*public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
        head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        //leftLeg.rotateAngleX = -1.5F * triangleWave(limbSwing, 13.0F) * limbSwingAmount;
        //rightLeg.rotateAngleX = 1.5F * triangleWave(limbSwing, 13.0F) * limbSwingAmount;
        //leftLeg.rotateAngleY = 0.0F;
        //rightLeg.rotateAngleY = 0.0F;
    }

    public void setLivingAnimations(T entity, float limbSwing, float limbSwingAmount, float partialTick) {
    }

    private float triangleWave(float p_78172_1_, float p_78172_2_) {
        return (Math.abs(p_78172_1_ % p_78172_2_ - p_78172_2_ * 0.5F) - p_78172_2_ * 0.25F) / (p_78172_2_ * 0.25F);
    }*/
}
