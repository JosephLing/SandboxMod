package com.Enigma.SM.worldgen.structures;


import com.Enigma.SM.Dungeon.DungeonGenerator;
import com.Enigma.SM.handler.ConfiguartionHandler;
import com.Enigma.SM.init.ModBlocks;
import com.Enigma.SM.utility.LogHelper;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import java.util.Random;
/*
Generally probably reasonably inefficent method of generating a dungeon. But I don't know how to do the tree traversal
stuff and things like that and this works and it produces good resutls.
 */



public class Dungeon implements IWorldGenerator
{

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        int Xchunk = chunkX * 15;
        int Zchunk = chunkZ * 15;
        int Y = 4; // ConfiguartionHandler.DG_YValue
        int yHeight = 3;  // 6
        if (random.nextInt(50) == 0 && world.provider.dimensionId == 0 && world.getBiomeGenForCoords(Xchunk, Zchunk) != BiomeGenBase.ocean && world.getBiomeGenForCoords(Xchunk, Zchunk) != BiomeGenBase.deepOcean && world.getBiomeGenForCoords(Xchunk, Zchunk) != BiomeGenBase.extremeHills && world.getBiomeGenForCoords(Xchunk, Zchunk) != BiomeGenBase.extremeHillsPlus && world.getBiomeGenForCoords(Xchunk, Zchunk) != BiomeGenBase.extremeHillsEdge)
        {
            // chunkX % 100 == 0 && Zchunk % 100 == 0
            /*
            BUG: Generates twice (according to the log)

            just had an index error
            in the DungeonGenerator section of code
                while (!(RoomFound) && nSteps < maxSteps)
                {
                    if (Map[Count][Count] == '#')
                    {
                        RoomFound = true;
                    }
                    else
                    {
             */
            LogHelper.info("X: " + Xchunk + " Z: " + Zchunk);
            makeDungeon(world, random, Xchunk, Y, yHeight, Zchunk); // what could possibly go wrong

        }

    }

    public void makeDungeon(World world, Random random, int Xchunk, int Y, int yHeight, int Zchunk)
    {

        int SpawnerCount = 0;
        int ChestCount = 0;



        // && random.nextInt(2) == 0
        long StartTime = System.nanoTime();
        LogHelper.info("generated dungoen");
        LogHelper.info("X value: " + ConfiguartionHandler.DG_XSIZE);
        LogHelper.info("Z value: " + ConfiguartionHandler.DG_ZSIZE);
        LogHelper.info("Y value: " + ConfiguartionHandler.DG_YValue);
        LogHelper.info("number of tries creating room: " + ConfiguartionHandler.DG_nTRIES);

        char[][] Map = DungeonGenerator.genMap(random, ConfiguartionHandler.DG_XSIZE, ConfiguartionHandler.DG_ZSIZE, ConfiguartionHandler.DG_nTRIES);
        // 50, 50, 250
        int temp_ymax = world.getHeightValue(Xchunk, Zchunk)-Y+10;
        for (int i = 5; i < temp_ymax; i++)
        {
            world.setBlock(Xchunk, Y+i, Zchunk, Blocks.air, 0, 2);
            world.setBlock(Xchunk+1, Y+i, Zchunk, Blocks.log, 0, 2);
            world.setBlock(Xchunk-1, Y+i, Zchunk, Blocks.log, 0, 2);
            world.setBlock(Xchunk, Y+i, Zchunk+1, Blocks.log, 0, 2);
            world.setBlock(Xchunk, Y+i, Zchunk-1, Blocks.log, 0, 2);
            world.setBlock(Xchunk+1, Y+i, Zchunk+1, Blocks.log, 0, 2);
            world.setBlock(Xchunk-1, Y+i, Zchunk-1, Blocks.log, 0, 2);
            world.setBlock(Xchunk, Y+i, Zchunk, Blocks.vine, 0, 2);
            if (random.nextInt(5) == 0)
            {
                // some random values ot make it look like a dead tree as leaves aren't really going to work
                //world.setBlock(Xchunk-1, Y+i, Zchunk-1, Blocks.log, 0, 2);
            }

            if (random.nextInt(3) == 0)
            {
                // one of the outer logs places a vine on it
            }
        }





        for (int Z = 0; Z < Map.length; Z++)
        {
            for (int X = 0; X <Map[0].length ; X++)
            {
                switch(Map[Z][X])
                {
                    case '+':
                        /*for (int i = 1; i < yHeight; i++)
                        {
                            world.setBlock(Xchunk + X, Y+i, Zchunk + Z, ModBlocks.ExampleBlock, 0, 2);

                        }*/
                        break;

                    case '#':
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
                        break;

                    case 'w':
                        for (int i = 0; i < yHeight; i++)
                        {
                            int randChoice = random.nextInt(5);
                            if (randChoice == 0)
                            {
                                world.setBlock(Xchunk + X, Y+i, Zchunk + Z, Blocks.stonebrick, 1, 2); // mossy stone brick
                            }
                            else if(randChoice == 1)
                            {
                                world.setBlock(Xchunk + X, Y+i, Zchunk + Z, Blocks.stonebrick, 3, 2); // chiseled stone brick
                            }
                            else
                            {
                                world.setBlock(Xchunk + X, Y+i, Zchunk + Z, Blocks.stonebrick, 0, 2);
                            }

                        }
                        break;

                    case 'b':
                        for (int i = 0; i < yHeight; i++)
                        {
                            world.setBlock(Xchunk + X, Y+i, Zchunk + Z, Blocks.bookshelf, 0, 2);

                        }
                        break;

                    case 'c':
                        ChestCount++;
                        world.setBlock(Xchunk + X, Y, Zchunk + Z, Blocks.cobblestone, 0, 2);
                        world.setBlock(Xchunk + X, Y+1, Zchunk + Z, ModBlocks.LootChestBlock, 0, 2);

                        if (random.nextInt(5) == 0)
                        {
                            world.setBlock(Xchunk + X, Y+2, Zchunk + Z, ModBlocks.LootChestBlock, 0, 2);
                            ChestCount++;
                            for (int i = 3; i < yHeight-2; i++)
                            {
                                world.setBlock(Xchunk + X, Y+i, Zchunk + Z, Blocks.air, 0, 2);

                            }
                        }
                        else
                        {
                            for (int i = 2; i < yHeight-1; i++)
                            {
                                world.setBlock(Xchunk + X, Y+i, Zchunk + Z, Blocks.air, 0, 2);

                            }
                        }
                        break;

                    case 's':
                        SpawnerCount ++;
                        world.setBlock(Xchunk + X, Y, Zchunk + Z, Blocks.cobblestone, 0, 2);
                        world.setBlock(Xchunk + X, Y+1, Zchunk + Z, Blocks.mob_spawner, 0, 2);
                        TileEntityMobSpawner Spawner = (TileEntityMobSpawner)world.getTileEntity(Xchunk + X, Y+1, Zchunk + Z);
                        Spawner.func_145881_a().setEntityName("Zombie");
                        for (int i = 2; i < yHeight-1; i++)
                        {
                            world.setBlock(Xchunk + X, Y+i, Zchunk + Z, Blocks.air, 0, 2);

                        }
                        break;

                    case 'j':
                        /*for (int i = 0; i < yHeight; i++)
                        {
                            world.setBlock(Xchunk + X, Y+i, Zchunk + Z, ModBlocks.ExampleBlock, 1, 2);
                        }*/
                        break;

                    case 'f':
                        for (int i = 0; i < yHeight; i++)
                        {
                            world.setBlock(Xchunk + X, Y+i, Zchunk + Z, Blocks.stonebrick, 2, 2);
                        }
                        break;

                    case 'i':
                        world.setBlock(Xchunk + X, Y, Zchunk + Z, Blocks.stonebrick, 3, 2); // chiseled stone brick
                        for (int i = 1; i < yHeight-1; i++)
                        {
                            world.setBlock(Xchunk + X, Y+i, Zchunk + Z, Blocks.iron_bars, 2, 2);
                        }
                        world.setBlock(Xchunk + X, Y + yHeight-1, Zchunk + Z, ModBlocks.ExampleBlock,0,  2);
                        break;

                    // user for debugging this stuff below here isL:
                    case 'd':
                        for (int i = 0; i < yHeight; i++)
                        {
                            world.setBlock(Xchunk + X, Y+i, Zchunk + Z, Blocks.diamond_ore, 0, 2);
                        }
                        break;

                    case 'a':
                        for (int i = 0; i < yHeight; i++)
                        {
                            world.setBlock(Xchunk + X, Y+i, Zchunk + Z, Blocks.sandstone, 0, 2);

                        }
                        break;
                }
            }
        }
        LogHelper.info("took: " + ((System.nanoTime() - StartTime)) + " seconds");
        LogHelper.info("Generated " + SpawnerCount + " number of spawners");
        LogHelper.info("Generated " + ChestCount + " number of chests");
    }
}






