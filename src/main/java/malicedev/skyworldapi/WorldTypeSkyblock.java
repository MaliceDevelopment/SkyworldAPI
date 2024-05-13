package malicedev.skyworldapi;

import net.minecraft.core.world.World;
import net.minecraft.core.world.biome.Biomes;
import net.minecraft.core.world.biome.provider.BiomeProvider;
import net.minecraft.core.world.biome.provider.BiomeProviderSingleBiome;
import net.minecraft.core.world.generate.chunk.ChunkGenerator;
import net.minecraft.core.world.generate.chunk.classic.ChunkGeneratorClassic;
import net.minecraft.core.world.generate.chunk.empty.ChunkGeneratorEmpty;
import net.minecraft.core.world.type.WorldTypeEmpty;

public class WorldTypeSkyblock extends WorldTypeEmpty {

	public WorldTypeSkyblock(String languageKey) {
		super(languageKey);
	}

	@Override
	public BiomeProvider createBiomeProvider(World world) {
		return new BiomeProviderSingleBiome(Biomes.OVERWORLD_FOREST, 1.0, 1.0, 1.0);
	}

	@Override
	public ChunkGenerator createChunkGenerator(World world) {
		return new ChunkGeneratorSkyIsland(world);
	}

	@Override
	public void getInitialSpawnLocation(World world) {
		world.getLevelData().setSpawn(5, 33, 5);
	}
}
