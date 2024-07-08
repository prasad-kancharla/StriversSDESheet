package com.prasad.companies.google;

import java.util.LinkedList;
import java.util.List;

class MRUQueue {

    public static void main(String[] args) {
        MRUQueue mruQueue = new MRUQueue(8);
        System.out.println(mruQueue.fetch(3));
        System.out.println(mruQueue.fetch(5));
        System.out.println(mruQueue.fetch(2));
        System.out.println(mruQueue.fetch(8));
    }

    List<Integer> list;

    public MRUQueue(int n) {
        list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
    }

    public int fetch(int k) {
        Integer fetchedElement = list.get(k - 1);
        list.remove(fetchedElement);
        list.add(fetchedElement);
        return fetchedElement;
    }

}

