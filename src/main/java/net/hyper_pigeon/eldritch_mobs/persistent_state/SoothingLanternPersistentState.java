package net.hyper_pigeon.eldritch_mobs.persistent_state;

import net.hyper_pigeon.eldritch_mobs.EldritchMobsMod;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.PersistentState;

import java.util.HashMap;

public class SoothingLanternPersistentState extends PersistentState {

    private final HashMap<String, ChunkPos> soothingLanternChunks = new HashMap<>();
    public final String key;

    public SoothingLanternPersistentState(String key) {
        super();
        this.key = key;
    }

    public SoothingLanternPersistentState() {
        this("SoothingLanternChunks");
    }

    public static SoothingLanternPersistentState readNbt(NbtCompound tag) {

        SoothingLanternPersistentState soothingLanternPersistentState = new SoothingLanternPersistentState();
        NbtCompound compoundTag = tag.getCompound("contents");

        for (String key : compoundTag.getKeys()) soothingLanternPersistentState.soothingLanternChunks.put(key, new ChunkPos(compoundTag.getLong(key)));
        soothingLanternPersistentState.markDirty();

        return soothingLanternPersistentState;
    }

    @Override
    public NbtCompound writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        NbtCompound compoundTag = new NbtCompound();

        this.soothingLanternChunks.forEach((key, chunkPos) -> compoundTag.putLong(key, chunkPos.toLong()));
        nbt.put("contents", compoundTag);
        return nbt;
    }

    public void addChunkPos(ServerWorld world, BlockPos pos) {
        soothingLanternChunks.put(pos.toString(), world.getChunk(pos).getPos());
        this.markDirty();
    }

    public void removeChunkPos(BlockPos pos) {
        if (soothingLanternChunks.containsKey(pos.toString())) {
            soothingLanternChunks.remove(pos.toString());
            this.markDirty();
        }
    }

    public boolean containsChunk(ChunkPos chunkPos) {
        return soothingLanternChunks.containsValue(chunkPos);
    }

    public int getSize() {
        return soothingLanternChunks.size();
    }

    public static SoothingLanternPersistentState get(ServerWorld world) {
        var type = new PersistentState.Type<>(
                () -> new SoothingLanternPersistentState(world.asString()),
                (nbt, wrapperLookup) -> SoothingLanternPersistentState.readNbt(nbt),
                null // Object builder API 12.1.0 and later makes this a no-op
        );
        return world.getPersistentStateManager().getOrCreate(type, "SoothingLanternChunks");
    }

    public void printSoothingLanternChunks() {
        for (String key : soothingLanternChunks.keySet()) EldritchMobsMod.LOGGER.info(soothingLanternChunks.get(key).toString());
    }
}
