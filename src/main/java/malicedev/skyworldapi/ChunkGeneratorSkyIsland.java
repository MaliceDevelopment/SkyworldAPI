package malicedev.skyworldapi;

import net.minecraft.core.block.Block;
import net.minecraft.core.world.World;
import net.minecraft.core.world.chunk.Chunk;
import net.minecraft.core.world.generate.chunk.ChunkGenerator;
import net.minecraft.core.world.generate.chunk.ChunkGeneratorResult;

public class ChunkGeneratorSkyIsland extends ChunkGenerator {
	public ChunkGeneratorSkyIsland(World world) {
		super(world, new ChunkDecoratorSkyIsland());
	}

	@Override
	protected ChunkGeneratorResult doBlockGeneration(Chunk chunk) {
		ChunkGeneratorResult result = new ChunkGeneratorResult();

		if (chunk.xPosition == 0 && chunk.zPosition == 0 || chunk.xPosition == 1 && chunk.zPosition == 0 || chunk.xPosition == 0 && chunk.zPosition == 1) {
			int xOffset = -chunk.xPosition * 16;
			int zOffset = -chunk.zPosition * 16;

			for (int x = 0; x < 18; x++) {
				for (int z = 0; z < 9; z++) {
					result.setBlock(x+xOffset, 32, z+zOffset, Block.grass.id);
				}
			}
			for (int x = 0; x < 9; x++) {
				for (int z = 9; z < 18; z++) {
					result.setBlock(x+xOffset, 32, z+zOffset, Block.grass.id);
				}
			}

			for (int y = 30; y <  32; y++) {
				for (int x = 0; x < 18; x++) {
					for (int z = 0; z < 9; z++) {
						result.setBlock(x+xOffset, y, z+zOffset, Block.dirt.id);
					}
				}
				for (int x = 0; x < 9; x++) {
					for (int z = 9; z < 18; z++) {
						result.setBlock(x+xOffset, y, z+zOffset, Block.dirt.id);
					}
				}
			}

			if (chunk.xPosition == 1) {
				result.setBlock(0, 33, 5, Block.saplingCherry.id);
			}
		}

		return result;
	}
}
