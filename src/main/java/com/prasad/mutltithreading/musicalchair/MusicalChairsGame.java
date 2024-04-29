package com.prasad.mutltithreading.musicalchair;

import java.util.Scanner;

public class MusicalChairsGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of players: ");
        int numPlayers = scanner.nextInt();

        Player head = createPlayers(numPlayers);
        Object lock = new Object();

        // Start the music thread
        MusicThread musicThread = new MusicThread(lock);
        musicThread.start();

        // Start the game thread
        GameThread gameThread = new GameThread(lock, head, numPlayers);
        gameThread.start();
    }

    private static Player createPlayers(int numPlayers) {
        Player head = null;
        Player prev = null;

        for (int i = 1; i <= numPlayers; i++) {
            Player player = new Player("Player " + i);
            if (head == null) {
                head = player;
                prev = player;
            } else {
                prev.setNext(player);
                player.setPrev(prev);
                prev = player;
            }
        }

        // Connect the last player to the first player to form a circular linked list
        head.setPrev(prev);
        prev.setNext(head);

        return head;
    }

}
