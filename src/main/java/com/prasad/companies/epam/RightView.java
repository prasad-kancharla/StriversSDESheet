package com.prasad.companies.epam;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class RightView {

    public static ArrayList<Integer> printRightView(BinaryTreeNode<Integer> root) {
        ArrayList<Integer> rightView = new ArrayList<>();
        if (root == null) {
            return rightView;
        }
        Queue<BinaryTreeNode> queue = new LinkedList();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                BinaryTreeNode<Integer> temp = queue.poll();
                if (i == size - 1) {
                    rightView.add(temp.data);
                }
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
        }
        return rightView;
    }

}
