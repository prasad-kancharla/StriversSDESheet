package com.prasad.linkedlistii;

public class ReverseNodesKGroupOptimal {

    public static void main(String[] args) {
        ListNode input = getInput();
        ListNode output = new ReverseNodesKGroupOptimal().reverseKGroup(input, 2);
        System.out.println(2);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        int i = 0;
        ListNode nextNode = null;
        ListNode prevGroupLastNode = null;

        while (temp != null) {
            ListNode kthNode = getKthNode(temp, k);
            if (kthNode == null) {
                if (prevGroupLastNode != null) prevGroupLastNode.next = temp;
                break;
            }

            nextNode = kthNode.next;
            kthNode.next = null;
            reverseLinkedList(temp);
            if (i == 0) {
                head = kthNode;
            } else {
                prevGroupLastNode.next = kthNode;
            }
            prevGroupLastNode = temp;
            temp = nextNode;
            i++;
        }

        return head;
    }

    private ListNode reverseLinkedList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    private ListNode getKthNode(ListNode head, int k) {
        int i = 1;
        while (head != null && i < k) {
            head = head.next;
            i++;
        }
        return head;
    }

    public static ListNode getInput() {
        ListNode node = new ListNode(1);
        ListNode current = node;
        for (int i = 2; i <= 5; i++) {
            current.next = new ListNode(i);
            current = current.next;
        }
        return node;
    }

}
