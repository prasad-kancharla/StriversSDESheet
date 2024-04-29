package com.prasad.mutltithreading.musicalchair;

class Player {

    private String name;
    private Player prev;
    private Player next;

    public Player(String name) {
        this.name = name;
        this.prev = null;
        this.next = null;
    }

    public String getName() {
        return name;
    }

    public Player getPrev() {
        return prev;
    }

    public void setPrev(Player prev) {
        this.prev = prev;
    }

    public Player getNext() {
        return next;
    }

    public void setNext(Player next) {
        this.next = next;
    }

}