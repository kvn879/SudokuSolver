package main;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class SudokuGUI extends Application {
    private TextField[][] cells = new TextField[9][9];
    Label errorLabel = new Label();

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gridPane = new GridPane();

        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++) {
                TextField tf = new TextField();
                String style = "-fx-pref-width: 50; -fx-pref-height: 50; -fx-alignment: center; -fx-font-size: 18;";
                String top = (r % 3 == 0) ? "2px" : "1px";
                String bottom = (r == 8) ? "2px" : "1px";
                String left = (c % 3  == 0) ? "2px" : "1px";
                String right = (c == 8) ? "2px" : "1px";

                tf.setStyle(style + "-fx-border-color: black; -fx-border-width: " + top + " " + right + " " + bottom + " " + left + ";");
                cells[r][c] = tf;
                gridPane.add(tf, c, r);
            }
        }

        Button solveButton = new Button("Solve");
        Button clearButton = new Button("Clear Board");
        solveButton.setOnAction(e -> solve());
        clearButton.setOnAction(e -> clearBoard());


        errorLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");


        VBox buttonContainer = new VBox(10);
        buttonContainer.getChildren().addAll(solveButton, clearButton);
        buttonContainer.setAlignment(Pos.BOTTOM_CENTER);
        buttonContainer.setPadding(new Insets(20));

        VBox root = new VBox(10, gridPane, errorLabel, buttonContainer);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Sudoku Solver");
        primaryStage.show();
    }

    private void clearBoard() {
        for(int r = 0; r < 9; r++) {
            for(int c = 0; c < 9; c++) {
                cells[r][c].clear();
            }
        }

    }
    private void solve() {
        int[][] board = new int[9][9];
        errorLabel.setText("");
        for(int r = 0; r < 9; r++) {
            for(int c = 0; c < 9; c++) {
                String cellNumText = cells[r][c].getText();
                if(!cellNumText.isEmpty()) {
                    if(!cellNumText.matches("[1-9]")) {
                        errorLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold");
                        errorLabel.setText("Error: Invalid input at " + (r+1) + ", " + (c+1));
                        return;
                    }
                    board[r][c] = Integer.parseInt(cellNumText);

                } else {
                    board[r][c] = 0;
                }
            }
        }

        Solver solver = new Solver(board);
        if(solver.solve(board)) {
            for(int r = 0; r < 9; r++) {
                for(int c = 0; c< 9; c++) {
                    cells[r][c].setText(String.valueOf(board[r][c]));
                }
            }
            errorLabel.setStyle("-fx-text-fill: green; -fx-font-weight: bold");
            errorLabel.setText("Puzzle Solved!");
        } else {
            errorLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold");
            errorLabel.setText("puzzle is unsolvable");
        }
    }
    public static void main(String args[]){
        launch(args);
    }
} 