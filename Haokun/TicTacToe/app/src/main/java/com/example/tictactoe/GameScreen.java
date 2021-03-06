package com.example.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameScreen extends AppCompatActivity {

    Button r0c0, r0c1, r0c2, r1c0, r1c1, r1c2, r2c0, r2c1, r2c2;
    TextView playerDisplay;

    boolean player1Turn = true;
    String[][] board = new String[3][3];
    int filled = 1;
    GameScreen view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        r0c0 = (Button)findViewById(R.id.r0c0);
        r0c1 = (Button)findViewById(R.id.r0c1);
        r0c2 = (Button)findViewById(R.id.r0c2);
        r1c0 = (Button)findViewById(R.id.r1c0);
        r1c1 = (Button)findViewById(R.id.r1c1);
        r1c2 = (Button)findViewById(R.id.r1c2);
        r2c0 = (Button)findViewById(R.id.r2c0);
        r2c1 = (Button)findViewById(R.id.r2c1);
        r2c2 = (Button)findViewById(R.id.r2c2);
        playerDisplay = (TextView)findViewById(R.id.playerDisplay);

        for(int i = 0; i<3; i++){
            for(int v = 0; v<3; v++){
                board[i][v] = "";
            }
        }
    }

    public void makeMove(View view){
        switch (view.getId()) {
            case R.id.r0c0:
                if (board[0][0] == "") {
                    if (player1Turn) {
                        board[0][0] = "X";
                    } else {
                        board[0][0] = "O";
                    }
                    r0c0.setText(board[0][0]);
                    player1Turn = !player1Turn;
                }
                checkWinner(0, 0);
                break;
            case R.id.r0c1:
                if (board[0][1] == "") {
                    if (player1Turn) {
                        board[0][1] = "X";
                    } else {
                        board[0][1] = "O";
                    }
                    r0c1.setText(board[0][1]);
                    player1Turn = !player1Turn;
                }
                checkWinner(0, 1);
                break;
            case R.id.r0c2:
                if (board[0][2] == "") {
                    if (player1Turn) {
                        board[0][2] = "X";
                    } else {
                        board[0][2] = "O";
                    }
                    r0c2.setText(board[0][2]);
                    player1Turn = !player1Turn;
                }
                checkWinner(0, 2);
                break;
            case R.id.r1c0:
                if (board[1][0] == "") {
                    if (player1Turn) {
                        board[1][0] = "X";
                    } else {
                        board[1][0] = "O";
                    }
                    r1c0.setText(board[1][0]);
                    player1Turn = !player1Turn;
                }
                checkWinner(1, 0);
                break;
            case R.id.r1c1:
                if (board[1][1] == "") {
                    if (player1Turn) {
                        board[1][1] = "X";
                    } else {
                        board[1][1] = "O";
                    }
                    r1c1.setText(board[1][1]);
                    player1Turn = !player1Turn;
                }
                checkWinner(1, 1);
                break;
            case R.id.r1c2:
                if (board[1][2] == "") {
                    if (player1Turn) {
                        board[1][2] = "X";
                    } else {
                        board[1][2] = "O";
                    }
                    r1c2.setText(board[1][2]);
                    player1Turn = !player1Turn;
                }
                checkWinner(1, 2);
                break;
            case R.id.r2c0:
                if (board[2][0] == "") {
                    if (player1Turn) {
                        board[2][0] = "X";
                    } else {
                        board[2][0] = "O";
                    }
                    r2c0.setText(board[2][0]);
                    player1Turn = !player1Turn;
                }
                checkWinner(2, 0);
                break;
            case R.id.r2c1:
                if (board[2][1] == "") {
                    if (player1Turn) {
                        board[2][1] = "X";
                    } else {
                        board[2][1] = "O";
                    }
                    r2c1.setText(board[2][1]);
                    player1Turn = !player1Turn;
                }
                checkWinner(2, 1);
                break;
            case R.id.r2c2:
                if (board[2][2] == "") {
                    if (player1Turn) {
                        board[2][2] = "X";
                    } else {
                        board[2][2] = "O";
                    }
                    r2c2.setText(board[2][2]);
                    player1Turn = !player1Turn;
                }
                checkWinner(2, 2);
                break;
        }
        if (player1Turn){
            playerDisplay.setText("Player 1's turn");
        }else{
            playerDisplay.setText("Player 2's turn");
        }
        filled++;
        System.out.println(filled);
    }

    public void checkWinner(int row, int col){
        int count = 1;
        //check the row
        for (int i = 0; i<2; i++){
            if (board[row][i].equals(board[row][i+1])) {
                count++;
            }
        }
        if (count == 3){
            winnerAlert(row, col);
        }else {
            System.out.println("a");
            count = 1;
            for (int i = 0; i < 2; i++) {
                if (board[i][col].equals(board[i + 1][col])) {
                    count++;
                }
            }
            if (count == 3) {
                winnerAlert(row, col);
            }else if (col == 1 && row == 1){
                if (diagonalDown() || diagonalUp()){
                    System.out.println("b");
                    winnerAlert(row, col);
                }else{
                    onNine();
                }
            }else if (col == row){
                if (diagonalDown()){
                    System.out.println("c");
                    winnerAlert(row, col);
                }else{
                    onNine();
                }
            }else if (Math.max(row, col) - 2 == col){
                if (diagonalUp()){
                    System.out.println("d");
                    winnerAlert(row, col);
                }else{
                    onNine();
                }
            }else{
                onNine();
            }
        }
    }

    public boolean diagonalDown(){
        return (board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]));
    }

    public boolean diagonalUp(){
        return (board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0]));
    }

    public void winnerAlert(int row, int col){
        Intent GameScreen = new Intent(this, GameScreen.class);

        AlertDialog.Builder winner = new AlertDialog.Builder(GameScreen.this);
        if (board[row][col].equals("X")){
            winner.setTitle("Player 1 won!");
        }else{
            winner.setTitle("Player 2 won!");
        }
        winner.setNegativeButton("Restart", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(GameScreen);
            }
        });
        winner.setCancelable(false);
        AlertDialog alert = winner.create();
        alert.show();
    }

    public void onNine(){
        if(filled == 9){
            Intent GameScreen = new Intent(this, GameScreen.class);

            AlertDialog.Builder draw = new AlertDialog.Builder(GameScreen.this);
            draw.setTitle("It's a draw!");
            draw.setNegativeButton("Restart", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    startActivity(GameScreen);
                }
            });
            draw.setCancelable(false);
            AlertDialog alert = draw.create();
            alert.show();
        }
    }

}