package io.github.apjifengc.yaaddition.addition;

import io.github.apjifengc.yaaddition.core.BlockStorage;
import io.github.apjifengc.yaaddition.util.Data;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.*;
import org.bukkit.block.*;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdditionBlock {
    private static final Map<Location, AdditionBlock> loadedBlocks = new HashMap<>();
    @Getter @Setter private AdditionMaterial material;
    @Getter private final Block block;
    @Getter private final Data additionData;

    public AdditionBlock(AdditionMaterial material, Block block, Data data) {
        this.material = material;
        this.block = block;
        this.additionData = data;
        loadedBlocks.put(block.getLocation(), this);
    }

    public AdditionBlock(AdditionMaterial material, Block block) {
        this(material, block, new Data());
    }

    public AdditionBlock(AdditionMaterial material, Block block, String data) {
        this(material, block, new Data(data));
    }

    public static AdditionBlock asAdditionCopy(Block block) {
        if (loadedBlocks.containsKey(block.getLocation())) return loadedBlocks.get(block.getLocation());
        AdditionMaterial material = AdditionMaterial.byId(BlockStorage.get(block.getLocation(), "id").toString());
        Data data = new Data(BlockStorage.get(block.getLocation(), "data").toString());
        return new AdditionBlock(material, block, data);
    }

    public Block asBukkitCopy() {
        return AdditionBlock.asBukkitCopy(this);
    }

    public static Block asBukkitCopy(AdditionBlock block) {
        return block.getBlock();
    }

    public static boolean isAddition(Block block) {
        return BlockStorage.contains(block.getLocation(), "id");
    }

    public void setAdditionData() {
        material.getState().setData(block);
        BlockStorage.set(block.getLocation(), "id", material.getIdentifier());
        BlockStorage.set(block.getLocation(), "data", additionData.toString());
    }

    //<editor-fold desc="Original Block Methods">
    /** @deprecated  */
    public byte getData() {
        return block.getData();
    }

    @NotNull
    public BlockData getBlockData() {
        return block.getBlockData();
    }

    @NotNull
    public Block getRelative(int modX, int modY, int modZ) {
        return block.getRelative(modX, modY, modZ);
    }

    @NotNull
    public Block getRelative(@NotNull BlockFace face) {
        return block.getRelative(face);
    }

    @NotNull
    public Block getRelative(@NotNull BlockFace face, int distance) {
        return block.getRelative(face, distance);
    }

    @NotNull
    public Material getType() {
        return block.getType();
    }

    public byte getLightLevel() {
        return block.getLightLevel();
    }

    public byte getLightFromSky() {
        return block.getLightFromSky();
    }

    public byte getLightFromBlocks() {
        return block.getLightFromBlocks();
    }

    @NotNull
    public World getWorld() {
        return block.getWorld();
    }

    public int getX() {
        return block.getX();
    }

    public int getY() {
        return block.getY();
    }

    public int getZ() {
        return block.getZ();
    }

    @NotNull
    public Location getLocation() {
        return block.getLocation();
    }

    @Nullable
    public Location getLocation(@Nullable Location loc) {
        return block.getLocation(loc);
    }

    @NotNull
    public Chunk getChunk() {
        return block.getChunk();
    }

    public void setBlockData(@NotNull BlockData data) {
        block.setBlockData(data);
    }

    public void setBlockData(@NotNull BlockData data, boolean applyPhysics) {
        block.setBlockData(data, applyPhysics);
    }

    public void setType(@NotNull Material type) {
        block.setType(type);
    }

    public void setType(@NotNull Material type, boolean applyPhysics) {
        block.setType(type, applyPhysics);
    }

    @Nullable
    public BlockFace getFace(@NotNull Block block) {
        return block.getFace(block);
    }

    @NotNull
    public BlockState getState() {
        return block.getState();
    }

    @NotNull
    public Biome getBiome() {
        return block.getBiome();
    }

    public void setBiome(@NotNull Biome bio) {
        block.setBiome(bio);
    }

    public boolean isBlockPowered() {
        return block.isBlockPowered();
    }

    public boolean isBlockIndirectlyPowered() {
        return block.isBlockIndirectlyPowered();
    }

    public boolean isBlockFacePowered(@NotNull BlockFace face) {
        return block.isBlockFacePowered(face);
    }

    public boolean isBlockFaceIndirectlyPowered(@NotNull BlockFace face) {
        return block.isBlockFaceIndirectlyPowered(face);
    }

    public int getBlockPower(@NotNull BlockFace face) {
        return block.getBlockPower(face);
    }

    public int getBlockPower() {
        return block.getBlockPower();
    }

    public boolean isEmpty() {
        return block.isEmpty();
    }

    public boolean isLiquid() {
        return block.isLiquid();
    }

    public double getTemperature() {
        return block.getTemperature();
    }

    public double getHumidity() {
        return block.getHumidity();
    }

    @NotNull
    public PistonMoveReaction getPistonMoveReaction() {
        return block.getPistonMoveReaction();
    }

    public boolean breakNaturally() {
        return block.breakNaturally();
    }

    public boolean breakNaturally(@Nullable ItemStack tool) {
        return block.breakNaturally(tool);
    }

    public boolean applyBoneMeal(@NotNull BlockFace face) {
        return block.applyBoneMeal(face);
    }

    @NotNull
    public Collection<ItemStack> getDrops() {
        return block.getDrops();
    }

    @NotNull
    public Collection<ItemStack> getDrops(@Nullable ItemStack tool) {
        return block.getDrops(tool);
    }

    @NotNull
    public Collection<ItemStack> getDrops(@NotNull ItemStack tool, @Nullable Entity entity) {
        return block.getDrops(tool, entity);
    }

    public boolean isPassable() {
        return block.isPassable();
    }

    @Nullable
    public RayTraceResult rayTrace(@NotNull Location start, @NotNull Vector direction, double maxDistance, @NotNull FluidCollisionMode fluidCollisionMode) {
        return block.rayTrace(start, direction, maxDistance, fluidCollisionMode);
    }

    @NotNull
    public BoundingBox getBoundingBox() {
        return block.getBoundingBox();
    }

    public void setMetadata(@NotNull String metadataKey, @NotNull MetadataValue newMetadataValue) {
        block.setMetadata(metadataKey, newMetadataValue);
    }

    @NotNull
    public List<MetadataValue> getMetadata(@NotNull String metadataKey) {
        return block.getMetadata(metadataKey);
    }

    public boolean hasMetadata(@NotNull String metadataKey) {
        return block.hasMetadata(metadataKey);
    }

    public void removeMetadata(@NotNull String metadataKey, @NotNull Plugin owningPlugin) {
        block.removeMetadata(metadataKey, owningPlugin);
    }
    //</editor-fold>
}
