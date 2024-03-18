package com.prasad.linkedlist;

class DeleteNode {

    public static void main(String[] args) {
        ListNode head = getInput();
        new DeleteNode().deleteNode(head.next);
        System.out.println(2);
    }

    public void deleteNode(ListNode node) {
        ListNode nextNode = node.next;
        node.val = nextNode.val;
        node.next = nextNode.next;
    }

    private static ListNode getInput() {
        ListNode listNode = new ListNode(4);
        listNode.next = new ListNode(5);
        listNode.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(9);
        return listNode;
    }

}