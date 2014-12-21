package com.Enigma.SM.worldgen.structures;


import com.Enigma.SM.init.ModBlocks;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import java.util.Random;

public class generateStructures implements IWorldGenerator
{
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        //world.setBlock(chunkX * 15, 42, chunkZ * 15, ModBlocks.ExampleBlock, 0, 2);
        int X = chunkX * 15;
        int Z = chunkZ * 15;
        int Chance = random.nextInt(100);

        if (Chance <= 40)
        {
            this.square(X, 4, Z,X + 8, 8, Z + 8, world);
        }
        else if (Chance >= 40)
        {
            Chance = random.nextInt(100);
            int dist = 18;
            if (Chance <= 25)
            {
                this.square(X, 4, Z,X - dist, dist, Z + dist, world);

            }
            else if (Chance <= 50)
            {
                this.square(X, 4, Z,X + dist, dist, Z - dist, world);

            }
            else if (Chance <= 75)
            {
                this.square(X, 4, Z,X - dist, dist, Z - dist, world);

            }
            else
            {
                this.square(X, 4, Z,X - dist, dist, Z - dist, world);

            }

        }
    }
    public static void square(int X1, int Y1, int Z1, int X2, int Y2, int Z2, World world)
    {
        int Y = Y2 - Y1;
        int Z = Z2 - Z1;
        int X = X2 - X1;
        // create an array of blocks for the walls then randomly select them
        for (int ydir = 0; ydir < Y; ydir++)
        {
            for (int zdir = 0; zdir <Z; zdir++)
            {
                for (int xdir = 0; xdir < X; xdir++)
                {
                    if (xdir == 0 || xdir == X-1 || zdir == 0 || zdir == Z-1)
                    {
                        world.setBlock(X1 + xdir, Y1 + ydir, Z1 + zdir,  Blocks.cobblestone, 0, 2);
                    }
                    else
                    {
                        world.setBlock(X1 + xdir, Y1 + ydir, Z1 + zdir,  Blocks.air, 0, 2);

                    }
                }
            }
        }

    }
}
