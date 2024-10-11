import java.util.InputMismatchException;
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

    public static void initializeBoard() {
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                board[i][j] = empty;
            }
        }
    }

    public static void printBoard() {
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void player() {
        Scanner scanner = new Scanner(System.in);
        boolean validMove = false;

        while (!validMove) {
            try {
                System.out.println("Seleccione una línea:");
                int playerRow = scanner.nextInt();

                if (playerRow < 1 || playerRow > 3) {
                    System.out.println("Introduzca una línea válida.");
                    continue;
                }

                System.out.println("Seleccione una columna:");
                int playerColumn = scanner.nextInt();

                if (playerColumn < 1 || playerColumn > 3) {
                    System.out.println("Introduzca una columna válida.");
                    continue;
                }

                if (board[playerRow][playerColumn] == empty) {
                    board[playerRow][playerColumn] = playerMarker;
                    validMove = true;
                } else {
                    System.out.println("Movimiento no válido, el espacio ya está ocupado.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Introduzca una entrada válida.");
                scanner.next();
            }
        }
    }

    public static void checkPlayerWin() {
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns - 2; j++) {
                if (board[i][j] == playerMarker && board[i][j + 1] == playerMarker && board[i][j + 2] == playerMarker) {
                    System.out.println("El jugador ha ganado la partida.");
                    gameFinished = true;
                }
            }
        }

        for (int i = 1; i < rows - 2; i++) {
            for (int j = 1; j < columns; j++) {
                if (board[i][j] == playerMarker && board[i + 1][j] == playerMarker && board[i + 2][j] == playerMarker) {
                    System.out.println("El jugador ha ganado la partida.");
                    gameFinished = true;
                }
            }
        }

        for (int i = 1; i < rows - 2; i++) {
            for (int j = 1; j < columns - 2; j++) {
                if (board[i][j] == playerMarker && board[i + 1][j + 1] == playerMarker && board[i + 2][j + 2] == playerMarker) {
                    System.out.println("El jugador ha ganado la partida.");
                    gameFinished = true;
                }
            }
        }

        for (int i = 1; i < rows - 2; i++) {
            for (int j = 2; j < columns; j++) {
                if (board[i][j] == playerMarker && board[i + 1][j - 1] == playerMarker && board[i + 2][j - 2] == playerMarker) {
                    System.out.println("El jugador ha ganado la partida.");
                    gameFinished = true;
                }
            }
        }
    }

    public static void iaPlayer() {
        Random random = new Random();
        boolean validMove = false;

        while (!validMove) {
            int min = 1;
            int max = 3;
            int randomRow = random.nextInt((max - min) + 1) + min;
            int randomColumn = random.nextInt((max - min) + 1) + min;

            if (board[randomRow][randomColumn] == empty) {
                board[randomRow][randomColumn] = iaMarker;
                validMove = true;
            }
        }
    }

    public static void checkIa() {
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns - 2; j++) {
                if (board[i][j] == iaMarker && board[i][j + 1] == iaMarker && board[i][j + 2] == iaMarker) {
                    System.out.println("La IA ha ganado la partida.");
                    gameFinished = true;
                }
            }
        }

        for (int i = 1; i < rows - 2; i++) {
            for (int j = 1; j < columns; j++) {
                if (board[i][j] == iaMarker && board[i + 1][j] == iaMarker && board[i + 2][j] == iaMarker) {
                    System.out.println("La IA ha ganado la partida.");
                    gameFinished = true;
                }
            }
        }

        for (int i = 1; i < rows - 2; i++) {
            for (int j = 1; j < columns - 2; j++) {
                if (board[i][j] == iaMarker && board[i + 1][j + 1] == iaMarker && board[i + 2][j + 2] == iaMarker) {
                    System.out.println("La IA ha ganado la partida.");
                    gameFinished = true;
                }
            }
        }

        for (int i = 1; i < rows - 2; i++) {
            for (int j = 2; j < columns; j++) {
                if (board[i][j] == iaMarker && board[i + 1][j - 1] == iaMarker && board[i + 2][j - 2] == iaMarker) {
                    System.out.println("La IA ha ganado la partida.");
                    gameFinished = true;
                }
            }
        }
    }

    public static void RestartGame() {
        initializeBoard();
        printBoard();
        while (!gameFinished) {
            player();
            checkPlayerWin();
            if (gameFinished) break;
            iaPlayer();
            checkIa();
            printBoard();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int restart = 0;
        boolean exit = false;

        RestartGame();
        while (!exit) {
            while (gameFinished) {
                System.out.println("""
                    ¿Quieres jugar de nuevo?
                    1 - Sí
                    2 - No""");

                try {
                    restart = 0;
                    restart = scanner.nextInt();

                    if (restart == 1 || restart == 2) {
                        break;
                    } else {
                        System.out.println("""
                            ¿Quieres jugar de nuevo?
                            1 - Sí
                            2 - No""");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada no válida.");
                    scanner.next();
                }
            }

            switch (restart) {
                case 1:
                    gameFinished = false;
                    RestartGame();
                    break;
                case 2:
                    exit = true;
                    break;
                default:
                    System.out.println("Entrada no válida.");
            }
        }

        System.out.println("El juego ha terminado.");
    }
}
