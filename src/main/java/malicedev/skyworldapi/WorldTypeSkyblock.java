package malicedev.skyworldapi;

import net.minecraft.core.world.World;
import net.minecraft.core.world.biome.Biomes;
import net.minecraft.core.world.biome.provider.BiomeProvider;
import net.minecraft.core.world.biome.provider.BiomeProviderSingleBiome;
import net.minecraft.core.world.config.season.SeasonConfig;
import net.minecraft.core.world.generate.chunk.ChunkGenerator;
import net.minecraft.core.world.generate.chunk.classic.ChunkGeneratorClassic;
import net.minecraft.core.world.generate.chunk.empty.ChunkGeneratorEmpty;
import net.minecraft.core.world.season.Seasons;
import net.minecraft.core.world.type.WorldTypeEmpty;
import net.minecraft.core.world.type.WorldTypeOverworldExtended;
import net.minecraft.core.world.weather.Weather;
import net.minecraft.core.world.wind.WindManagerGeneric;

public class WorldTypeSkyblock extends WorldTypeEmpty {
	public SeasonConfig seasonConfig;

	public WorldTypeSkyblock(String languageKey) {
		super(languageKey);

		seasonConfig = SeasonConfig.builder()
			.withSeasonInCycle(Seasons.OVERWORLD_SPRING, 14)
			.withSeasonInCycle(Seasons.OVERWORLD_SUMMER, 14)
			.withSeasonInCycle(Seasons.OVERWORLD_FALL, 14)
			.withSeasonInCycle(Seasons.OVERWORLD_WINTER, 14)
			.build();
	}

	@Override
	public BiomeProvider createBiomeProvider(World world) {
		return new BiomeProviderSingleBiome(Biomes.OVERWORLD_FOREST, 1.0, 1.0, 1.0);
	}

	@Override
	public SeasonConfig getDefaultSeasonConfig() {
		return seasonConfig;
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
