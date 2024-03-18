package com.prasad.linkedlist;

class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode out = new AddTwoNumbers().addTwoNumbers(getInput1(), getInput2());
        System.out.println(2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carryForward = 0;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        ListNode temp1 = l1;
        ListNode temp2 = l2;

        while (temp1 != null || temp2 != null) {
            int i1 = temp1 != null ? temp1.val : 0;
            int i2 = temp2 != null ? temp2.val : 0;

            int sum = i1 + i2 + carryForward;
            curr.next = new ListNode(sum % 10);
            carryForward = sum / 10;

            curr = curr.next;
            if (temp1 != null) {
                temp1 = temp1.next;
            }
            if (temp2 != null) {
                temp2 = temp2.next;
            }
        }
        if (carryForward != 0) {
            curr.next = new ListNode(carryForward);
        }
        return dummy.next;
    }

    private static ListNode getInput1() {
        ListNode node = new ListNode(2);
        node.next = new ListNode(4);
        node.next.next = new ListNode(3);
        //        node.next.next.next = new ListNode(9);
        //        node.next.next.next.next = new ListNode(9);
        //        node.next.next.next.next.next= new ListNode(9);
        //        node.next.next.next.next.next.next = new ListNode(9);

        return node;
    }

    private static ListNode getInput2() {
        ListNode node = new ListNode(5);
        node.next = new ListNode(6);
        node.next.next = new ListNode(4);
        //        node.next.next.next = new ListNode(9);
        return node;
    }

}