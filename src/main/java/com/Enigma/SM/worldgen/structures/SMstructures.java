package com.Enigma.SM.worldgen.structures;



import net.minecraft.init.Blocks;
import net.minecraft.world.World;

/*
CURRENTLY HIGHLY UNEFFICENT (is as laggy as other peoples code after testing)



 */



public class SMstructures
{

    public static void filled_section(int X1, int Y1, int Z1, int X2, int Y2, int Z2, World world, Blocks BlockMade)
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
