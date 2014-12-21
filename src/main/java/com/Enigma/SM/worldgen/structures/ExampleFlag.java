package com.Enigma.SM.worldgen.structures;


import com.Enigma.SM.init.ModBlocks;
import com.sun.javafx.tools.packager.Log;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import java.util.Random;


public class ExampleFlag implements IWorldGenerator
{


    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {


        if (random.nextInt(50) == 0)
        {
            // range over all 10

            int rX = 10 + random.nextInt(10);
            int rZ = 10 + random.nextInt(10);
            /*
            for (int i = 0; i < 10; i++)
            {
                world.setBlock((chunkX * 15) + rX, 5 + i, (chunkZ * 15) + rZ , Blocks.cobblestone, 0, 2);
            }

            for (int i = 0; i < 10; i++)
            {
                world.setBlock((chunkX * 15) + rX*2, 5 + i, (chunkZ * 15) + rZ , Blocks.cobblestone, 0, 2);
            }
            for (int i = 0; i < 10; i++)
            {
                world.setBlock((chunkX * 15) + rX, 5 + i, (chunkZ * 15) + rZ*2 , Blocks.cobblestone, 0, 2);
            }
            for (int i = 0; i < 10; i++)
            {
                world.setBlock((chunkX * 15) + rX*2, 5 + i, (chunkZ * 15) + rZ*2, Blocks.cobblestone, 0, 2);
            }*/
            this.gen_square(chunkX*15, 5, chunkZ*15, chunkX*15 + rX, 15,chunkZ*15 +rZ, world);

            Log.info("generated");
        }
    }

    private void gen_square(int X1, int Y1, int Z1, int X2, int Y2, int Z2, World world)
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
                    if (xdir == 0 || xdir == X-1 || zdir == 0 || zdir == Z-1 || ydir == 0 || ydir == Y-1)
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
