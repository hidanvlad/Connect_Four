package com.connectfour;

/**
 * AI player implementation with basic strategy.
 */
public class AIPlayer {
    private char aiPiece;
    private char opponentPiece;
    
    public AIPlayer(char aiPiece, char opponentPiece) {
        this.aiPiece = aiPiece;
        this.opponentPiece = opponentPiece;
    }
    
    /**
     * Makes a move using a simple strategy:
     * 1. Try to win
     * 2. Block opponent from winning
     * 3. Make a strategic move (prefer center columns)
     */
    public int makeMove(Board board) {
        // Try to win
        for (int col = 0; col < board.getCols(); col++) {
            if (!board.isColumnFull(col)) {
                Board tempBoard = copyBoard(board);
                tempBoard.dropPiece(col, aiPiece);
                if (tempBoard.checkWin(aiPiece)) {
                    return col;
                }
            }
        }
        
        // Block opponent from winning
        for (int col = 0; col < board.getCols(); col++) {
            if (!board.isColumnFull(col)) {
                Board tempBoard = copyBoard(board);
                tempBoard.dropPiece(col, opponentPiece);
                if (tempBoard.checkWin(opponentPiece)) {
                    return col;
                }
            }
        }
        
        // Prefer center columns
        int[] preferredColumns = {3, 2, 4, 1, 5, 0, 6};
        for (int col : preferredColumns) {
            if (!board.isColumnFull(col)) {
                return col;
            }
        }
        
        // Fallback: find any available column
        for (int col = 0; col < board.getCols(); col++) {
            if (!board.isColumnFull(col)) {
                return col;
            }
        }
        
        return -1; // Board is full
    }
    
    private Board copyBoard(Board original) {
        Board copy = new Board();
        for (int i = 0; i < original.getRows(); i++) {
            for (int j = 0; j < original.getCols(); j++) {
                char cell = original.getCell(i, j);
                if (cell != ' ') {
                    copy.setCell(i, j, cell);
                }
            }
        }
        return copy;
    }
}
