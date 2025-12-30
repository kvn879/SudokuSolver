package main;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[][] sudokuBoard = new int[9][9];
        System.out.println("Enter your numbers (enter '0' for empty spots). press 'q' to quit");

        System.out.println("Enter the first number starting in the top left corner\n");
        for(int row = 0; row < 9; row++) {
            for(int col = 0; col < 9; col++) {
                String input = scanner.next();
                if (input.equalsIgnoreCase("q")) System.exit(0);

                try {
                    int nextVal = Integer.parseInt(input);
                    if(nextVal < 0 || nextVal > 9) {
                        System.out.println("Invalid Input");
                    }
                    else{
                        sudokuBoard[row][col] = nextVal;
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Not a number");
                    sudokuBoard[row][col] = 0;
                }


            }
        }

        scanner.close();

        Solver solver = new Solver(sudokuBoard);
        if(solver.solve(sudokuBoard) == true) {
            solver.drawBoard(sudokuBoard);
            System.out.println("Puzzle Solved!");
        }

        else {
            System.out.println("This puzzle can not be solved");
        }

    }

}