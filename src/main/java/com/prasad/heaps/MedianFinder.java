package com.prasad.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(4);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(5);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(7);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(8);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(9);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(10);
        System.out.println(medianFinder.findMedian());
    }

    private final PriorityQueue<Double> leftHeap;
    private final PriorityQueue<Double> rightHeap;

    public MedianFinder() {
        leftHeap = new PriorityQueue<>(Collections.reverseOrder());
        rightHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        leftHeap.offer((double) num);
        if (!rightHeap.isEmpty() && leftHeap.peek() > rightHeap.peek()) {
            rightHeap.offer(leftHeap.poll());
        }
        if (leftHeap.size() > rightHeap.size() + 1) {
            double i = leftHeap.poll();
            rightHeap.offer(i);
        } else if (rightHeap.size() > leftHeap.size() + 1) {
            double i = rightHeap.poll();
            leftHeap.offer(i);
        }
    }

    public double findMedian() {
        int n = leftHeap.size();
        int m = rightHeap.size();
        int size = n + m;
        if (size % 2 == 1) {
            return n > m ? leftHeap.peek() : rightHeap.peek();
        }
        return (leftHeap.peek() + rightHeap.peek()) / 2;
    }

}
