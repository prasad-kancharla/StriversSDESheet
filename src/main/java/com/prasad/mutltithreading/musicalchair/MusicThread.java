package com.prasad.mutltithreading.musicalchair;

import java.util.Random;

class MusicThread extends Thread {
    private final Object lock;

    public MusicThread(Object lock) {
        this.lock = lock;
    }

    public void run() {
        synchronized (lock) {
            System.out.println("Music playing...");
            try {
                int duration = new Random().nextInt(5000) + 1000; // Random duration between 1 to 5 seconds
                lock.wait(duration); // Wait for random duration
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Music stopped...");
            lock.notify(); // Notify the game thread that music has stopped
        }
    }
}