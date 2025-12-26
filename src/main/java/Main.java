import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[][] sudokuBoard = new int[9][9];
        System.out.println("Enter your numbers (enter '0' for empty spots). press 'q' to quit");

        System.out.println("Enter the first number starting in the top left corner\n");
        for(int row = 0; row < 9; row++) {
            for(int col = 0; col < 9; col++) {
                if(scanner.next() == "q") System.exit(0);
                int nextInt = scanner.nextInt();
                //if(nextInt < 0 || nextInt > 9) System.out.println("Invalid Input");
                sudokuBoard[row][col] = nextInt;

            }
        }

        scanner.close();
        Board board = new Board(sudokuBoard);
        board.drawBoard(sudokuBoard);



    }

}