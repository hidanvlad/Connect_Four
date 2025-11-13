package com.connectfour;

/**
 * Represents the Connect Four game board.
 */
public class Board {
    private static final int ROWS = 6;
    private static final int COLS = 7;
    private char[][] grid;
    
    public Board() {
        grid = new char[ROWS][COLS];
        initializeBoard();
    }
    
    private void initializeBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                grid[i][j] = ' ';
            }
        }
    }
    
    public void display() {
        System.out.println("\n 1 2 3 4 5 6 7");
        System.out.println("---------------");
        for (int i = 0; i < ROWS; i++) {
            System.out.print("|");
            for (int j = 0; j < COLS; j++) {
                System.out.print(grid[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println("---------------");
    }
    
    public boolean dropPiece(int col, char piece) {
        if (col < 0 || col >= COLS) {
            return false;
        }
        
        for (int i = ROWS - 1; i >= 0; i--) {
            if (grid[i][col] == ' ') {
                grid[i][col] = piece;
                return true;
            }
        }
        return false; // Column is full
    }
    
    public boolean isColumnFull(int col) {
        if (col < 0 || col >= COLS) {
            return true;
        }
        return grid[0][col] != ' ';
    }
    
    public boolean isFull() {
        for (int j = 0; j < COLS; j++) {
            if (grid[0][j] == ' ') {
                return false;
            }
        }
        return true;
    }
    
    public boolean checkWin(char piece) {
        // Check horizontal
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS - 3; j++) {
                if (grid[i][j] == piece && grid[i][j+1] == piece && 
                    grid[i][j+2] == piece && grid[i][j+3] == piece) {
                    return true;
                }
            }
        }
        
        // Check vertical
        for (int i = 0; i < ROWS - 3; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == piece && grid[i+1][j] == piece && 
                    grid[i+2][j] == piece && grid[i+3][j] == piece) {
                    return true;
                }
            }
        }
        
        // Check diagonal (bottom-left to top-right)
        for (int i = 3; i < ROWS; i++) {
            for (int j = 0; j < COLS - 3; j++) {
                if (grid[i][j] == piece && grid[i-1][j+1] == piece && 
                    grid[i-2][j+2] == piece && grid[i-3][j+3] == piece) {
                    return true;
                }
            }
        }
        
        // Check diagonal (top-left to bottom-right)
        for (int i = 0; i < ROWS - 3; i++) {
            for (int j = 0; j < COLS - 3; j++) {
                if (grid[i][j] == piece && grid[i+1][j+1] == piece && 
                    grid[i+2][j+2] == piece && grid[i+3][j+3] == piece) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public int getRows() {
        return ROWS;
    }
    
    public int getCols() {
        return COLS;
    }
    
    public char getCell(int row, int col) {
        if (row >= 0 && row < ROWS && col >= 0 && col < COLS) {
            return grid[row][col];
        }
        return ' ';
    }
    
    public void setCell(int row, int col, char piece) {
        if (row >= 0 && row < ROWS && col >= 0 && col < COLS) {
            grid[row][col] = piece;
        }
    }
}
