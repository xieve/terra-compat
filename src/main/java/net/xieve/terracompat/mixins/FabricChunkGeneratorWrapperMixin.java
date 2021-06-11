package net.xieve.terracompat.mixins;

import com.dfsek.terra.api.platform.world.generator.GeneratorWrapper;
import com.dfsek.terra.config.pack.ConfigPack;
import com.dfsek.terra.fabric.world.generator.FabricChunkGeneratorWrapper;
import net.minecraft.structure.StructureManager;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.world.biome.source.BiomeAccess;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.StructuresConfig;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = FabricChunkGeneratorWrapper.class, remap = false)
public abstract class FabricChunkGeneratorWrapperMixin extends ChunkGenerator implements GeneratorWrapper {
	@Shadow @Final private ConfigPack pack;

	// This should be ignored
	public FabricChunkGeneratorWrapperMixin(BiomeSource biomeSource, StructuresConfig structuresConfig) {
		super(biomeSource, structuresConfig);
	}

	@Override
	public void carve(long seed, BiomeAccess access, Chunk chunk, GenerationStep.Carver carver) {
	    // TODO: Steal Simplex' optimized vanilla carver
		if (pack.getTemplate().vanillaCaves()) super.carve(seed, access, chunk, carver);
	}

	@Override
	public void setStructureStarts(DynamicRegistryManager dynamicRegistryManager, StructureAccessor structureAccessor, Chunk chunk, StructureManager structureManager, long worldSeed) {
		if (pack.getTemplate().vanillaStructures()) super.setStructureStarts(dynamicRegistryManager, structureAccessor, chunk, structureManager, worldSeed);
	}
}
