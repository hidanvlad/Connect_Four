package com.connectfour;

import java.util.Scanner;

/**
 * Main game logic for Connect Four.
 */
public class Game {
    private Board board;
    private char currentPlayer;
    private boolean isAIGame;
    private AIPlayer ai;
    private Scanner scanner;
    
    public Game(boolean isAIGame) {
        this.board = new Board();
        this.currentPlayer = 'X';
        this.isAIGame = isAIGame;
        this.scanner = new Scanner(System.in);
        
        if (isAIGame) {
            this.ai = new AIPlayer('O', 'X');
        }
    }
    
    public void play() {
        System.out.println("\n=== Welcome to Connect Four! ===");
        System.out.println("Player X goes first.");
        if (isAIGame) {
            System.out.println("You are X, AI is O.");
        } else {
            System.out.println("Player 1 is X, Player 2 is O.");
        }
        
        boolean gameOver = false;
        
        while (!gameOver) {
            board.display();
            
            int col;
            if (currentPlayer == 'X' || !isAIGame) {
                col = getPlayerMove();
            } else {
                col = ai.makeMove(board);
                System.out.println("AI plays column " + (col + 1));
            }
            
            if (col == -1) {
                System.out.println("Invalid move. Try again.");
                continue;
            }
            
            if (!board.dropPiece(col, currentPlayer)) {
                System.out.println("Column is full! Choose another column.");
                continue;
            }
            
            if (board.checkWin(currentPlayer)) {
                board.display();
                if (isAIGame && currentPlayer == 'O') {
                    System.out.println("\nAI wins! Better luck next time.");
                } else {
                    System.out.println("\nPlayer " + currentPlayer + " wins! Congratulations!");
                }
                gameOver = true;
            } else if (board.isFull()) {
                board.display();
                System.out.println("\nIt's a draw! The board is full.");
                gameOver = true;
            } else {
                // Switch player
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
        
        System.out.println("\nThanks for playing!");
    }
    
    private int getPlayerMove() {
        System.out.print("Player " + currentPlayer + ", enter column (1-7): ");
        try {
            if (!scanner.hasNextInt()) {
                scanner.nextLine(); // Clear invalid input
                return -1;
            }
            int col = scanner.nextInt() - 1;
            if (col >= 0 && col < board.getCols()) {
                return col;
            } else {
                return -1;
            }
        } catch (Exception e) {
            scanner.nextLine(); // Clear invalid input
            return -1;
        }
    }
}
