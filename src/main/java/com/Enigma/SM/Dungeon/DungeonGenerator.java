package com.Enigma.SM.Dungeon;

import java.util.Random;


public class DungeonGenerator
{
    private static void printCharArray(char[][] Array)
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

    private static char[][] genSquare(char Char, int x, int z)
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
    private static char[][] genStartingSquare(char Char, int x, int z)
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

    private static char[][] genRoom(char[][] Map, Random random)
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
        char[][] Room = genSquare('#', X1, Z1);

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

    private static char[][] check(char[][] Map)
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

    private static char[][] checkDoors(char[][] Map, Random random)
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
                        else if(Map[z+1][x-2] == 'w' && Map[z-1][x-2] == 'w' && Map[z+1][x+2] == 'w' && Map[z-1][x+2] == 'w')
                        {
                            Map[z][x-2] = 'f';
                            Map[z][x+2] = 'f';
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
                        else if(Map[z-1][x+1] == 'w' && Map[z-1][x-1] == 'w' && Map[z+1][x-1] == 'w' && Map[z+1][x+1] == 'w')
                        {
                            Map[z-1][x] = 'f';
                            Map[z+1][x] = 'f';
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
                        else if(Map[z+1][x-2] == 'w' && Map[z-1][x-2] == 'w' && Map[z+1][x+2] == 'w' && Map[z-1][x+2] == 'w')
                        {
                            Map[z][x-2] = 'f';
                            Map[z][x+2] = 'f';
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
                        else if(Map[z-2][x+1] == 'w' && Map[z-2][x-1] == 'w' && Map[z+2][x-1] == 'w' && Map[z+2][x+1] == 'w')
                        {
                            Map[z-2][x] = 'f';
                            Map[z+2][x] = 'f';
                        }
                    }
                }

            }
        }



        return Map;
    }

    private static char[][] genDecor(char[][] Map, Random random)
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
                    if(Map[z][x] == '#' && Map[z][x-1] == 'w' && Map[z+1][x-1] == 'w' && Map[z+1][x] == 'w' && random.nextInt(4) == 0)
                    {
                        Map[z][x] ='c';
                    }

                    else if(Map[z][x] == '#' && Map[z][x+1] == 'w' && Map[z+1][x+1] == 'w' && Map[z+1][x] == 'w' && random.nextInt(4) == 0)
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


    private static char[][] genEnterance(char[][] Map, Random random, int X, int Z)
    {

        boolean RoomFound = false;
        double nSteps = 0;
        double maxSteps = Math.sqrt(X*X + Z*Z);

        int Count = 0;

        while (!(RoomFound) && nSteps < maxSteps)
        {
            if (Map[Count][Count] == '#')
            {
                RoomFound = true;
            }
            else
            {
                Count ++;
                nSteps ++;
            }
        }

        // creates a square towards the #
        Map[0][0] = '#';
        Map[0][1] = '#';
        Map[1][0] = '#';

        Map[1][1] = 'i';
        Map[1][2] = 'i';
        Map[2][1] = 'i';
        for (int i = 2; i < Count; i++)
        {
            Map[i][i] = '#';
            Map[i][i+1] = '#';
            Map[i+1][i] = '#';
        }


        return Map;
    }

    public static char[][] genMap(Random random, int X, int Z, int roomAttempts)
    {
        char[][] Map = genStartingSquare('+', X, Z);
        for (int i = 0; i < roomAttempts; i++)
        {
            Map = genRoom(Map, random);
        }
        Map = checkDoors(Map, random);
        Map = check(Map);
        Map = genDecor(Map, random);
        Map = genEnterance(Map, random, X, Z);
        return Map;
    }

}
