package com.connectfour;

import java.util.Scanner;

/**
 * Main entry point for Connect Four game.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n╔════════════════════════════════╗");
        System.out.println("║   CONNECT FOUR GAME            ║");
        System.out.println("╚════════════════════════════════╝");
        System.out.println("\nSelect game mode:");
        System.out.println("1. Two Players (local)");
        System.out.println("2. Player vs AI");
        System.out.print("\nEnter your choice (1 or 2): ");
        
        int choice = 0;
        try {
            choice = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input. Exiting.");
            scanner.close();
            return;
        }
        
        Game game;
        if (choice == 1) {
            game = new Game(false);
        } else if (choice == 2) {
            game = new Game(true);
        } else {
            System.out.println("Invalid choice. Exiting.");
            scanner.close();
            return;
        }
        
        game.play();
        scanner.close();
    }
}
