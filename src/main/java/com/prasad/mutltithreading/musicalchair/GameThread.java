package com.prasad.mutltithreading.musicalchair;

import java.util.Random;
import java.util.Scanner;

class GameThread extends Thread {
    private final Object lock;
    private Player head;
    private int numPlayers;

    public GameThread(Object lock, Player head, int numPlayers) {
        this.lock = lock;
        this.head = head;
        this.numPlayers = numPlayers;
    }

    public void run() {
        synchronized (lock) {
            try {
                lock.wait(); // Wait for music to start
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Scanner scanner = new Scanner(System.in);

        // Main game loop
        while (numPlayers > 1) {
            // Simulate passing of the ball while music is playing
            System.out.println("Pass the ball...");
            Random random = new Random();
            int numPasses = random.nextInt(numPlayers); // Random number of passes
            for (int i = 0; i < numPasses; i++) {
                head = head.getNext(); // Move to the next player
            }

            // Player holding the ball is out
            Player eliminatedPlayer = head;
            head.getPrev().setNext(head.getNext());
            head.getNext().setPrev(head.getPrev());
            head = head.getNext(); // Move to the next player
            numPlayers--;

            System.out.println(eliminatedPlayer.getName() + " is out!");

            // Wait for input to continue the game
            System.out.println("Press Enter to continue...");
            scanner.nextLine(); // Consume newline left-over
            scanner.nextLine(); // Wait for Enter key press
        }

        // Declare the winner
        System.out.println("Winner: " + head.getName());
    }
}