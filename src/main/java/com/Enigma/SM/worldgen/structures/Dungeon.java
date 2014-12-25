package com.Enigma.SM.worldgen.structures;


import com.Enigma.SM.handler.ConfiguartionHandler;
import com.Enigma.SM.init.ModBlocks;
import com.Enigma.SM.utility.LogHelper;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.ChestGenHooks;

import java.util.Random;
/*
Generally probably reasonably inefficent method of generating a dungeon. But I don't know how to do the tree traversal
stuff and things like that and this works and it produces good resutls.
 */



public class Dungeon implements IWorldGenerator
{



    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        int Xchunk = chunkX *15;
        int Zchunk = chunkZ *15;
        int Y = ConfiguartionHandler.DG_YValue;
        int yHeight = 6;
        if (Xchunk % 100 == 0 && Zchunk % 100 == 0 && random.nextInt(2) == 0)
        {

            LogHelper.info("generated dungoen");
            char[][] Map = genMap(random, ConfiguartionHandler.DG_XSIZE, ConfiguartionHandler.DG_ZSIZE, ConfiguartionHandler.DG_nTRIES);
            // 50, 50, 250
            int temp_ymax = world.getHeightValue(Xchunk, Zchunk)-Y+10;
            for (int i = 0; i < temp_ymax; i++)
            {
                world.setBlock(Xchunk, Y+i, Zchunk, Blocks.gold_block, 0, 2);
            }
            for (int Z = 0; Z < Map.length; Z++)
            {
                for (int X = 0; X <Map[0].length ; X++)
                {
                    if (Map[Z][X] == '+')
                    {
                        for (int i = 1; i < yHeight; i++)
                        {
                            world.setBlock(Xchunk + X, Y+i, Zchunk + Z, ModBlocks.ExampleBlock, 0, 2);

                        }
                    }
                    else if (Map[Z][X] == '#')
                    {
                        if (random.nextInt(3) == 0)
                        {
                            world.setBlock(Xchunk + X, Y, Zchunk + Z, Blocks.mossy_cobblestone, 0, 2);

                        }
                        else
                        {
                            world.setBlock(Xchunk + X, Y, Zchunk + Z, Blocks.cobblestone, 0, 2);
                        }
                        for (int i = 1; i < yHeight-1; i++)
                        {
                            world.setBlock(Xchunk + X, Y+i, Zchunk + Z, Blocks.air, 0, 2);

                        }

                    }
                    else if (Map[Z][X] == 'w')
                    {
                        for (int i = 0; i < yHeight; i++)
                        {
                            int randChoice = random.nextInt(5);
                            if (randChoice == 0)
                            {
                                world.setBlock(Xchunk + X, Y+i, Zchunk + Z, Blocks.stonebrick, 1, 2);
                            }
                            else if(randChoice == 1)
                            {
                                world.setBlock(Xchunk + X, Y+i, Zchunk + Z, Blocks.stonebrick, 2, 2);
                            }
                            else
                            {
                                world.setBlock(Xchunk + X, Y+i, Zchunk + Z, Blocks.cobblestone, 0, 2);
                            }

                        }

                    }
                    else if (Map[Z][X] == 'b')
                    {
                        for (int i = 0; i < yHeight; i++)
                        {
                            world.setBlock(Xchunk + X, Y+i, Zchunk + Z, Blocks.bookshelf, 0, 2);

                        }
                    }
                    else if (Map[Z][X] == 'c')
                    {
                        /*
                        current code below is not working as it was copied off the internet :)

                        courses.vswe.se -> check out (maybe a little out of date but their will be some follow through hopefully)

                        generate chest
                        get chest inventory
                        manipulate inventory (ON BOTH SERVER AND CLIENT SIDE) (this I think is the main area of the problem.. )


                         */
                        world.setBlock(Xchunk + X, Y, Zchunk + Z, Blocks.cobblestone, 0, 2);
                        world.setBlock(Xchunk + X, Y+1, Zchunk + Z, Blocks.chest, 0, 2);
                        TileEntityChest Chest = (TileEntityChest)world.getTileEntity(Xchunk + X, Y+1, Zchunk + Z);
                        ChestGenHooks info = ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST);
                        WeightedRandomChestContent.generateChestContents(random, info.getItems(random), Chest, info.getCount(random));

                        for (int i = 2; i < yHeight-1; i++)
                        {
                            world.setBlock(Xchunk + X, Y+i, Zchunk + Z, Blocks.air, 0, 2);

                        }

                    }
                    else if (Map[Z][X] == 's')
                    {
                        world.setBlock(Xchunk + X, Y, Zchunk + Z, Blocks.cobblestone, 0, 2);
                        world.setBlock(Xchunk + X, Y+1, Zchunk + Z, Blocks.mob_spawner, 0, 2);
                        TileEntityMobSpawner Spawner = (TileEntityMobSpawner)world.getTileEntity(Xchunk + X, Y+1, Zchunk + Z);
                        Spawner.func_145881_a().setEntityName("Zombie");
                        for (int i = 2; i < yHeight-1; i++)
                        {
                            world.setBlock(Xchunk + X, Y+i, Zchunk + Z, Blocks.air, 0, 2);

                        }

                    }
                    else if (Map[Z][X] == 'j')
                    {
                        for (int i = 0; i < yHeight; i++)
                        {
                            world.setBlock(Xchunk + X, Y+i, Zchunk + Z, ModBlocks.ExampleBlock, 1, 2);
                        }
                    }


                    // user for debugging this stuff below here isL:
                    else if (Map[Z][X] == 'd')
                    {
                        for (int i = 0; i < yHeight; i++)
                        {
                            world.setBlock(Xchunk + X, Y+i, Zchunk + Z, Blocks.diamond_ore, 0, 2);

                        }

                    }
                    else if (Map[Z][X] == 'a')
                    {
                        for (int i = 0; i < yHeight; i++)
                        {
                            world.setBlock(Xchunk + X, Y+i, Zchunk + Z, Blocks.sandstone, 0, 2);

                        }

                    }
                }
            }


        }
    }

    private void printCharArray(char[][] Array)
    {
        String Text = "\n";
        for (int i = 0; i < Array.length; i++)
        {
            for (int j = 0; j < Array[0].length; j++)
            {
                if (Array[i][j] == '+')
                {
                    Text = Text + ' ';
                }
                else
                {
                    Text = Text + Array[i][j];
                }
            }
            Text = Text + "\n";
        }
        System.out.println(Text);
    }

    private char[][] genSquare(char Char, int x, int z)
    {

        char[][] Square = new char[z][x];
        for (int X = 0; X < x; X++)
        {
            for (int Z = 0; Z < z; Z++)
            {
                if (Z == 0 || Z == z-1 || X == 0 || X == x-1)
                {
                    Square[Z][X] = 'w';
                }
                else
                {
                    Square[Z][X] = Char;

                }
            }
        }
        return Square;
    }
    private char[][] genStartingSquare(char Char, int x, int z)
    {

        char[][] Square = new char[z][x];
        for (int X = 0; X < x; X++)
        {
            for (int Z = 0; Z < z; Z++)
            {
                if (Z == 0 || Z == z - 1 || X == 0 || X == x - 1)
                {
                    Square[Z][X] = 'j';
                } else
                {
                    Square[Z][X] = Char;

                }
            }
        }
        return Square;
    }

    private char[][] genRoom(char[][] Map, Random random)
    {

        int xRange = (Map[0].length - 5)/6;
        int zRange = (Map.length - 5)/6;
        int X1;
        int Z1;
        int Count = 0;
        int xCount = 0;
        int zCount = 0;

        int xStart = 4;
        int zStart = 3;
        boolean Valid = true;

        if (random.nextInt(2) == 0)
        {
            X1 = xStart + random.nextInt(xRange);
            Z1 = zStart + random.nextInt(zRange);

        }
        else
        {
            X1 = Map[0].length - 1 - xStart - random.nextInt(xRange);
            Z1 = Map.length - 1 - zStart - random.nextInt(zRange);

        }
        int[][] Coords = new int[X1 * Z1][2];
        int[][] roomCoords= new int[X1 * Z1][2];
        char[][] Room = this.genSquare('#', X1, Z1);

        int X2 = Math.abs( X1 + random.nextInt(Map[0].length -1) - Map[0].length-1);
        int Z2 = Math.abs(Z1 + random.nextInt(Map.length -1) - Map.length-1);

        if ((Room.length - 1 + Z2) < Map.length && (Room[0].length-1+X2) < Map[0].length)
        {
            while (Valid && zCount < Room.length)
            {
                if (Map[Z2 + zCount][X2 + xCount] == '+')
                {
                    if (zCount + Z2 < Map.length && xCount + X2 < Map[0].length)
                    {
                        Coords[Count][0] = Z2 + zCount;
                        Coords[Count][1] = X2 + xCount;
                        roomCoords[Count][0] = zCount;
                        roomCoords[Count][1] = xCount;
                        Count ++;
                        if (xCount >= Room[0].length-1)
                        {
                            xCount = 0;
                            zCount ++;
                        }
                        else
                        {
                            xCount ++;
                        }

                    }
                }
                else
                {
                    Valid = false;
                }
            }
            if (Valid)
            {
                for (int i = 0; i < roomCoords.length; i++)
                {
                    Map[Coords[i][0]][Coords[i][1]] = Room[roomCoords[i][0]][roomCoords[i][1]];
                }
            }
        }
        return Map;
    }

    private char[][] check(char[][] Map)
    {
        int zlength = Map.length;
        int xlength = Map[0].length;

        for (int z = 0; z < zlength; z++)
        {
            for (int x = 0; x < xlength; x++)
            {
                if (!(x-2 <= 0 || x+1 >= xlength))
                {
                    if (Map[z][x-2] == '#' && Map[z][x-1] == 'w' && Map[z][x] == 'w'&& Map[z][x+1] == '#')
                    {
                        Map[z][x] = '#';
                        Map[z][x-1] = '#';
                    }
                }
                if (!(z-2 <= 0 || z+1 >= zlength))
                {
                    if (Map[z-2][x] == '#' && Map[z-1][x] == 'w' && Map[z][x] == 'w'&& Map[z+1][x] == '#')
                    {
                        Map[z][x] = '#';
                        Map[z-1][x] = '#';
                    }
                }

                if (!(z-3 <=0 || z+2 >= zlength || x-1 <= 0 || x+1 >= xlength))
                {

                    if (Map[z-3][x] == '#' && Map[z-2][x] == 'w' && Map[z-1][x] == '+' && Map[z][x] == 'w' && Map[z+1][x] == '#')
                    {

                        Map[z][x] = '#';
                        Map[z-1][x] = '#';
                        Map[z-2][x] = '#';
                        Map[z-1][x+1] = 'w';
                        Map[z-1][x-1] = 'w';
                    }
                }
                if (!(z-1 <=0 || z+1 >= zlength || x-3 <= 0 || x+1 >= xlength))
                {
                    if (Map[z][x-3] == '#' && Map[z][x-2] == 'w' && Map[z][x-1] == '+' && Map[z][x] == 'w' && Map[z][x+1] == '#')
                    {
                        Map[z][x-1] = '#';
                        Map[z][x-2] = '#';
                        Map[z][x] = '#';
                        Map[z-1][x-1] = 'w';
                        Map[z+1][x-1] = 'w';
                    }
                }

                if (!(z-2 <=0 || z+2 >= zlength || x-2 <= 0 || x+2 >= xlength))
                {
                    if (Map[z+2][x+2] == '#' && Map[z+2][x+1] == '#' && Map[z+1][x+1] == 'w' && Map[z][x] == 'w' && Map[z-1][x] == '#' && Map[z-1][x-1] == '#')
                    {
                        Map[z][x] = '#';
                        Map[z+1][x+1] = '#';
                        Map[z+1][x] = '#';
                        Map[z][x+1] = '#';
                        Map[z+1][x-1] = 'w';
                        Map[z][x+2] = 'w';


                    }
                }
                if (!(z-2 <=0 || z+2 >= zlength || x-2 <= 0 || x+2 >= xlength))
                {
                    if ( Map[z+1][x+1] == '#' && Map[z][x+1] == '#' && Map[z][x] == 'w' && Map[z-1][x-1] == 'w' && Map[z-1][x-2] == '#' && Map[z-2][x-2] == '#')
                    {
                        Map[z][x] = '#';
                        Map[z-1][x+1] = '#';
                        Map[z-1][x] = '#';
                        Map[z-1][x-1] = '#';
                        Map[z-2][x] = 'w';

                        Map[z-2][x+1] = 'w';



                    }
                }

            }
        }
        return Map;
    }

    private char[][] checkDoors(char[][] Map, Random random)
    {
        int zlength = Map.length;
        int xlength = Map[0].length;

        for (int z = 0; z < zlength; z++)
        {
            for (int x = 0; x < xlength; x++)
            {
                if (!(z-2 <=0 || z+2 >= zlength || x-2 <= 0 || x+3 >= xlength))
                {
                    if(Map[z][x-2] == '#' && Map[z][x-1] == 'w' && Map[z][x] == '+' && Map[z][x+1] == '+' && Map[z][x+2] == 'w' && Map[z][x+3] == '#' )
                    {
                        if (random.nextInt(2) == 0)
                        {
                            Map[z][x] = '#';
                            Map[z][x+1] = '#';
                            Map[z][x+2] = '#';
                            Map[z][x-1] = '#';

                            Map[z+1][x] = 'b';
                            Map[z+1][x+1] = 'b';
                            Map[z-1][x] = 'b';
                            Map[z-1][x+1] = 'b';
                        }
                    }
                }

                if (!(z-2 <=0 || z+3 >= zlength || x-2 <= 0 || x+2 >= xlength))
                {
                    if(Map[z-2][x] == '#' && Map[z-1][x] == 'w' && Map[z][x] == '+' && Map[z+1][x] == '+' && Map[z+2][x] == 'w' && Map[z+3][x] == '#' )
                    {
                        if (random.nextInt(2) == 0)
                        {
                            Map[z][x] = '#';
                            Map[z+1][x] = '#';
                            Map[z+2][x] = '#';
                            Map[z-1][x] = '#';

                            Map[z][x+1] = 'b';
                            Map[z][x-1] = 'b';
                            Map[z+1][x+1] = 'b';
                            Map[z+1][x-1] = 'b';
                        }
                    }
                }

                if (!(z-3 <=0 || z+2 >= zlength || x-2 <= 0 || x+3 >= xlength))
                {
                    if(Map[z][x-3] == '#' && Map[z][x-2] == 'w' && Map[z][x-1] == '+' && Map[z][x] == '+' && Map[z][x+1] == '+' && Map[z][x+2] == 'w' && Map[z][x+3] == '#' )
                    {
                        if (random.nextInt(2) == 0)
                        {

                            Map[z][x+2] = '#';
                            Map[z][x+1] = '#';
                            Map[z][x] = '#';
                            Map[z][x-1] = '#';
                            Map[z][x-2] = '#';

                            Map[z+1][x] = 'b';
                            Map[z-1][x] = 'b';
                            Map[z+1][x+1] = 'b';
                            Map[z-1][x+1] = 'b';
                            Map[z+1][x-1] = 'b';
                            Map[z-1][x-1] = 'b';
                        }
                    }
                }

                if (!(z-3 <=0 || z+3 >= zlength || x-2 <= 0 || x+3 >= xlength))
                {
                    if(Map[z-3][x] == '#' && Map[z-2][x] == 'w' && Map[z-1][x] == '+' && Map[z][x] == '+' && Map[z+1][x] == '+' && Map[z+2][x] == 'w' && Map[z+3][x] == '#' )
                    {
                        if (random.nextInt(2) == 0)
                        {
                            Map[z-2][x] = '#';
                            Map[z-1][x] = '#';
                            Map[z][x] = '#';
                            Map[z+1][x] = '#';
                            Map[z+2][x] = '#';

                            Map[z][x+1] = 'w';
                            Map[z][x-1] = 'w';
                            Map[z+1][x+1] = 'w';
                            Map[z+1][x-1] = 'w';
                            Map[z-1][x+1] = 'w';
                            Map[z-1][x-1] = 'w';
                        }
                    }
                }

            }
        }



        return Map;
    }

    private char[][] genDecor(char[][] Map, Random random)
    {
        int zlength = Map.length;
        int xlength = Map[0].length;

        for (int z = 0; z < zlength; z++)
        {
            for (int x = 0; x < xlength; x++)
            {

                if (!(z-1 <=0 || z+1 >= zlength || x-1 <= 0 || x+1 >= xlength))
                {
                    // z direction
                    if(Map[z][x] == '#' && Map[z][x-1] == 'w' && Map[z+1][x-1] == 'w' && Map[z+1][x] == 'w' && random.nextInt(5) == 0)
                    {
                        Map[z][x] ='c';
                    }

                    else if(Map[z][x] == '#' && Map[z][x+1] == 'w' && Map[z+1][x+1] == 'w' && Map[z+1][x] == 'w' && random.nextInt(5) == 0)
                    {
                        Map[z][x] ='c';
                    }

                    // z directoin
                    else if(Map[z][x] == '#' && Map[z][x-1] == 'w' && Map[z-1][x-1] == 'w' && Map[z-1][x] == 'w' && random.nextInt(4) == 0)
                    {
                        Map[z][x] ='s';
                    }

                    // if(Map[z][x] == '#' && Map[z][x-1] == 'w' && Map[z+1][x-1] == 'w' && Map[z+1][x] == 'w')
                    else if(Map[z][x] == '#' && Map[z-1][x] == 'w' && Map[z-1][x+1] == 'w' && Map[z][x+1] == 'w' && random.nextInt(4) == 0)
                    {
                        Map[z][x] ='s';
                    }
                }
            }
        }

        return Map;
    }

    private char[][] genMap(Random random, int X, int Z, int roomAttempts)
    {
        char[][] Map = genStartingSquare('+', X, Z);
        for (int i = 0; i < roomAttempts; i++)
        {
            Map = this.genRoom(Map, random);
        }
        Map = this.checkDoors(Map, random);
        Map = this.check(Map);
        Map = this.genDecor(Map, random);

        return Map;
    }



}

