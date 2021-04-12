package net.xieve.terracompat;

import com.dfsek.terra.api.platform.world.generator.GeneratorWrapper;
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
import org.spongepowered.asm.mixin.Mixin;

@Mixin(FabricChunkGeneratorWrapper.class)
public abstract class ChunkGeneratorMixin extends ChunkGenerator implements GeneratorWrapper {
    // This should be ignored
	public ChunkGeneratorMixin(BiomeSource biomeSource, StructuresConfig structuresConfig) {
		super(biomeSource, structuresConfig);
	}

	@Override
	public void carve(long seed, BiomeAccess access, Chunk chunk, GenerationStep.Carver carver) {
	    System.out.println("Debug: Vanilla carve method accessed.");
		super.carve(seed, access, chunk, carver);
	}

	@Override
	public void setStructureStarts(DynamicRegistryManager dynamicRegistryManager, StructureAccessor structureAccessor, Chunk chunk, StructureManager structureManager, long worldSeed) {
		System.out.println("Debug: Vanilla structure population method accessed.");
		super.setStructureStarts(dynamicRegistryManager, structureAccessor, chunk, structureManager, worldSeed);
	}
}
