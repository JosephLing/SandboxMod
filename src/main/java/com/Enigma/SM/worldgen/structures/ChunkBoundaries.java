package com.Enigma.SM.worldgen.structures;


import com.Enigma.SM.init.ModBlocks;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import java.util.Random;

public class ChunkBoundaries implements IWorldGenerator
{
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        world.setBlock(chunkX * 15, 42, chunkZ * 15, ModBlocks.ExampleBlock, 0, 2);
        //this.square(chunkX * 15, 4, chunkZ * 15,chunkX * 15 + 8, 8, chunkZ * 15 + 8, world);
    }

}
