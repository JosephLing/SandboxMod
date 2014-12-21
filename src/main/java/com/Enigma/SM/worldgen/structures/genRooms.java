package com.Enigma.SM.worldgen.structures;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import java.util.Random;

public class genRooms implements IWorldGenerator
{

    private static final int SizeOfMap = 18;
    private static int ChunkCount = 0;
    private static int yLevel = 10;



    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {

        if (ChunkCount >= SizeOfMap)
        {
            ChunkCount = 0;
            //yLevel = 10 + random.nextInt(10);
        }
        else
        {
            ChunkCount ++;
        }



        int X = chunkX * 15;
        int Z = chunkZ * 15;
        if (ChunkCount < 18)
        {
            /*
            0 = +z
            1 = +x
            2 = -z
            3 = -x
             */
            int[] coords = {1,1};

            int DirectionX = random.nextInt(10);
            if (DirectionX  < 2)
            {
                coords[0] = -2;
            }
            else if (DirectionX > 7)
            {
                coords[0] = 2;
            }
            else if (DirectionX < 4)
            {
                int DirectionZ = random.nextInt(10);
                if (DirectionZ  < 2)
                {
                    coords[0] = -3;
                }
                else if (DirectionZ > 7)
                {
                    coords[0] = -2;
                }
            }



            /*
            0 = room small
            1 = path
            2 = big room
            3 = nothing

             */
            int Choice = random.nextInt(100);
            if (Choice <= 50)
            {
                this.square(X, yLevel, Z, X+ (5 * coords[0]), yLevel + 10, Z+ (5 * coords[1]), world);
            }
            else if (Choice <= 75)
            {
                this.square(X, yLevel, Z, X + (5 * coords[0]), yLevel + 5, Z + (5 * coords[1]), world);
            }
            else if (Choice <= 90)
            {
                this.square(X - X/8, yLevel, X - X/8, X+ (7 * coords[0]), yLevel + 10, Z+ (7 * coords[1]), world);
            }
            else
            {
                this.filled_section(X - 4, yLevel, Z -4, X+4, yLevel+4, Z+4, world);
            }

        }
    }





    public void filled_section(int X1, int Y1, int Z1, int X2, int Y2, int Z2, World world)
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
                    world.setBlock(X1 + xdir, Y1 + ydir, Z1 + zdir,  Blocks.cobblestone, 0, 2);
                }
            }
        }

    }





    public void square(int X1, int Y1, int Z1, int X2, int Y2, int Z2, World world)
    {
        int Y = Y2 - Y1;
        int Z = Z2 - Z1;
        int X = X2 - X1;
        // create an array of blocks for the walls then randomly select them


        for (int ydir = 0; ydir < Y; ydir++)
        {
            for (int zdir = 0; zdir < Z; zdir++)
            {
                for (int xdir = 0; xdir < X; xdir++)
                {
                    if (xdir == 0 || xdir == X - 1 || zdir == 0 || zdir == Z - 1 || ydir == 0 || ydir == Y - 1)
                    {
                        world.setBlock(X1 + xdir, Y1 + ydir, Z1 + zdir, Blocks.cobblestone, 0, 2);
                    } else
                    {
                        world.setBlock(X1 + xdir, Y1 + ydir, Z1 + zdir, Blocks.air, 0, 2);

                    }
                }
            }
        }
    }

}
