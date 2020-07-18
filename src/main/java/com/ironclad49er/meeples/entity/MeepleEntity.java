package com.ironclad49er.meeples.entity;

import net.minecraft.block.BlockState;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.network.NetworkHooks;

/**
 * A Meeple entity.
 */
public class MeepleEntity extends CreatureEntity {

    public MeepleEntity(final EntityType<? extends MeepleEntity> entityType, final World world) {
        super(entityType, world);
    }

    public void notifyDataManagerChange(DataParameter<?> key) {
        super.notifyDataManagerChange(key);
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();

        final double baseSpeed = this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getBaseValue();
        final double baseHealth = this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).getBaseValue();
        // Multiply base health and base speed by one and a half
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(baseSpeed * 1.5D);
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(baseHealth * 1.5D);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 60.0F));
    }

    public void livingTick() {
        super.livingTick();
    }

    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {
        super.handleStatusUpdate(id);
    }

    /***** SAVING ******/

    protected void registerData() {
        super.registerData();
    }

    public void writeAdditional(CompoundNBT nbt) {
        super.writeAdditional(nbt);
    }

    public void readAdditional(CompoundNBT nbt) {
        super.readAdditional(nbt);
    }

    /******** SOUNDS *********/

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_PIG_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_PIG_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_PIG_DEATH;
    }

    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.ENTITY_PIG_STEP, 0.15F, 1.0F);
    }

    // Minimum number of ticks between sounds
    public int getTalkInterval() { return 120; }

    /***** INTERACTIONS *******/

    public boolean processInteract(PlayerEntity player, Hand hand) {
        if (super.processInteract(player, hand)) {
            return true;
        }
        ItemStack stack = player.getHeldItem(hand);
        if (stack.getItem() == Items.NAME_TAG) {
            stack.interactWithEntity(player, this, hand);
            return true;
        }
        return false;
    }

    public boolean attackEntityFrom(DamageSource source, float amount) {
        return super.attackEntityFrom(source, amount);
    }

    protected void dropInventory() {
        super.dropInventory();
    }

    // Experience points the entity currently has.
    protected int getExperiencePoints(PlayerEntity player) {
        return 1 + this.world.rand.nextInt(3);
    }


    public void onStruckByLightning(LightningBoltEntity lightningBolt) {

    }

    public void travel(Vec3d vec) {
        if (this.isAlive()) {
            super.travel(vec);
        }
    }

    public float getBlockPathWeight(BlockPos pos, IWorldReader worldReader) {
        // worldReader.getBlockState(pos.down()).getBlock()
        return 10.0f;
    }


    /**
     * Creates a child new entity from the parent entity.
     * Can be used to set additional on the child entity based on the parent.
     *
     * @param parent The entity that made this child
     * @return A new WildBoar
     */
    public MeepleEntity createChild(final AgeableEntity parent) {
        // Use getType to support overrides in subclasses
        return (MeepleEntity) getType().create(this.world);
    }

    /**
     * Called on the logical server to get a packet to send to the client containing data necessary to spawn your entity.
     * Using Forge's method instead of the default vanilla one allows extra stuff to work such as sending extra data,
     * using a non-default entity factory and having {@link IEntityAdditionalSpawnData} work.
     *
     * It is not actually necessary for our WildBoarEntity to use Forge's method as it doesn't need any of this extra
     * functionality, however, this is an example mod and many modders are unaware that Forge's method exists.
     *
     * @return The packet with data about your entity
     * @see FMLPlayMessages.SpawnEntity
     */
    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

}