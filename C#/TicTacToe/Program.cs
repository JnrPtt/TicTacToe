using System;

class TicTacToe
{
    private static readonly int rows = 4;
    private static readonly int columns = 4;
    private static readonly char empty = '-';
    private static readonly char[,] board = new char[rows, columns];
    private static readonly char playerMarker = 'o';
    private static readonly char iaMarker = 'x';
    private static bool gameFinished = false;
    
    public static void initializeBoard()
    {
        for (int i = 1; i < rows; i++) 
        {
            for (int j = 1; j < columns; j++) 
            {
                board[i, j] = empty;
            }
        }
    }

    public static void printBoard() 
    {
        for (int i = 1; i < rows; i++)
        {
            for (int j = 1; j < columns; j++) 
            {
                Console.Write(board[i, j]);
            }
            Console.WriteLine();   
        }
    }

    public static void player()
    {
        bool validMove = false;

        while (!validMove)
        {
            Console.WriteLine("Seleccione una linea");
            int playerRow = int.Parse(Console.ReadLine());
            Console.WriteLine("Selecciones una columan");
            int playerColumn = int.Parse(Console.ReadLine());

            if (board[playerRow, playerColumn] == empty)
            {
                board[playerRow, playerColumn] = playerMarker;
                validMove = true;
            }
            else
            {
                Console.WriteLine("Movimiento no valido el espacio ya esta ocupado");            
            }
        }
    }

    public static void checkPlayerWin()
    {
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns - 2; j++)
            {
                if (board[i, j] == playerMarker && board[i, j + 1] == playerMarker && board[i, j + 2] == playerMarker)
                {
                    Console.WriteLine("El jugador ha ganado la partida.");
                    gameFinished = true;
                }
            }
        }
    }


    public static void iaPlayer()
    {
        Random random = new Random();
        bool validMove=false;

        while(!validMove) 
        {
            int min = 1;
            int max = 3;
            int randomRow = random.Next(min, max + 1);
            int randomColumn = random.Next(min, max + 1);

            if (board[randomRow, randomColumn] == empty)
            {
                board[randomRow, randomColumn] = iaMarker;
                validMove = true;
            }
        }
    }

    public static void checkIa()
    {
        for (int i = 1;i < rows; i++) 
        {
            for (int j = 1; j < columns - 2; j++) 
            {
                if (board[i, j] == iaMarker && board[i, j+1] == iaMarker && board[i, j+2] == iaMarker) 
                {
                    Console.WriteLine("La IA ha ganado la partida");
                    gameFinished=true;
                }
            }
        }
    }

    public static void Main(String[] args) 
    {
    initializeBoard();
    printBoard();

        while (!gameFinished) 
        {
            player();
            checkPlayerWin();
            iaPlayer();
            checkIa();
            printBoard();  
        }
        Console.WriteLine("El juego ha terminado");
    }
}