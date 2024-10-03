import java.util.Scanner;
import java.util.Random;

public class TicTacToe {
    private static final int rows = 4;
    private static final int columns = 4;
    private static final char empty = '-';
    private static final char[][] board = new char[rows][columns];
    private static final char playerMarker = 'x';
    private static final char iaMarker = 'o';
    private static boolean gameFinished = false;

    public static void initializeBoard(){
        for (int i = 1; i < rows; i++){
            for (int j = 1; j < columns; j++){
                board[i][j]= empty;
            }
        }
    }

    public static void printBoard(){
        for (int i = 1; i < rows; i++){
            for (int j = 1; j < columns; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void player(){
        Scanner scanner = new Scanner(System.in);
        boolean validMove = false;

        while(!validMove){
            System.out.println("Seleccione una linea");
            int playerRow = scanner.nextInt();
            System.out.println("Seleccione una columna");
            int playerColumn = scanner.nextInt();

            if(board[playerRow][playerColumn] == empty){
                board[playerRow][playerColumn] = playerMarker;
                validMove = true;
            }   else {
                System.out.println("Movimiento no valido el espacio ya esta ocupado");
            }
        }
    }

    public static void checkPlayerWin(){
        for (int i = 1; i < rows; i++){
            for (int j = 1; j < columns - 2; j++){
                if (board[i][j] == playerMarker && board[i][j+1] == playerMarker && board[i][j+2] == playerMarker){
                    System.out.println("El jugador ha ganado la partida.");
                    gameFinished = true;
                }
            }
        }

        for (int i = 1; i < rows - 2; i++){
            for (int j = 1; j < columns; j++){
                if (board[i][j] == playerMarker && board[i+1][j] == playerMarker && board[i+2][j] == playerMarker){
                    System.out.println("El jugador ha ganado la partida.");
                    gameFinished = true;
                }
            }
        }

        for (int i = 1; i < rows - 2; i++){
            for (int j = 1; j < columns - 2; j++){
                if (board[i][j] == playerMarker && board[i+1][j+1] == playerMarker && board[i+2][j+2] == playerMarker){
                    System.out.println("El jugador ha ganado la partida.");
                    gameFinished = true;
                }
            }
        }

        for (int i = 1; i < rows - 2; i++){
            for (int j = 2; j < columns; j++){
                if (board[i][j] == playerMarker && board[i+1][j-1] == playerMarker && board[i+2][j-2] == playerMarker){
                    System.out.println("El jugador ha ganado la partida.");
                    gameFinished = true;
                }
            }
        }
    }

    public static void iaPlayer(){
        Random random = new Random();
        boolean validMove = false;

        while(!validMove){
            int min = 1;
            int max = 3;
            int randomRow = random.nextInt((max - min)+ 1) + min;
            int randomColumn = random.nextInt((max - min)+ 1) + min;

            if(board[randomRow][randomColumn] == empty){
                board[randomRow][randomColumn] = iaMarker;
                validMove = true;
            }
        }
    }

    public static void checkIa(){
        for (int i = 1; i < rows; i++){
            for (int j = 1; j < columns - 2; j++){
                if (board[i][j] == iaMarker && board[i][j+1] == iaMarker && board[i][j+2] == iaMarker){
                    System.out.println("La IA ha ganado la partida.");
                    gameFinished = true;
                }
            }
        }

        for (int i = 1; i < rows - 2; i++){
            for (int j = 1; j < columns; j++){
                if (board[i][j] == iaMarker && board[i+1][j] == iaMarker && board[i+2][j] == iaMarker){
                    System.out.println("La IA ha ganado la partida.");
                    gameFinished = true;
                }
            }
        }

        for (int i = 1; i < rows - 2; i++){
            for (int j = 1; j < columns - 2; j++){
                if (board[i][j] == iaMarker && board[i+1][j+1] == iaMarker && board[i+2][j+2] == iaMarker){
                    System.out.println("La IA ha ganado la partida.");
                    gameFinished = true;
                }
            }
        }

        for (int i = 1; i < rows - 2; i++){
            for (int j = 2; j < columns; j++){
                if (board[i][j] == iaMarker && board[i+1][j-1] == iaMarker && board[i+2][j-2] == iaMarker){
                    System.out.println("La IA ha ganado la partida.");
                    gameFinished = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        initializeBoard();
        printBoard();
        while (!gameFinished){
            player();
            checkPlayerWin();
            if (gameFinished) break;
            iaPlayer();
            checkIa();
            printBoard();
        }
        System.out.println("El juego ha terminado");
    }
}
