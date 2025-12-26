public class Board {

    private int[][] board;

    public Board(int[][] board) {

        this.board = board;

    }

    public void drawBoard(int[][] board) {
        for(int row = 0; row < 9; row++) {
            for(int col = 0; col < 9; col++) {
                System.out.print(board[row][col] + " ");
                if((col + 1) % 3 == 0 && (col != 8)) {
                    System.out.print("| ");
                }
            }
            System.out.println();
            if((row + 1) % 3 == 0 && (row != 8)) {
                System.out.println("--------------------");
            }
        }
    }

    private void isValid(int[][] board, int row, int column, int number) {

        //checking each row


        //checking column


        //checking 3x3 grid

    }




}