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

    private boolean isValid(int[][] board, int row, int column, int number) {


        for(int i = 0; i < 9; i++) {
            if(board[row][i] == number) return false;
            if(board[i][column] == number) return false;
        }


        int gridRowStart = row - row % 3;
        int gridColStart = column - column % 3;

        for(int r = gridRowStart; r < gridRowStart + 3; r++) {
            for(int c = gridColStart; c < gridColStart + 3; c++) {
                if(board[r][c] == number) return false;
            }
        }
        return true;

    }

    public boolean solve(int[][] board) {
        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++) {
                if(board[row][col] == 0) {

                }
            }
        }
    }




}