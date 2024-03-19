package com.prasad.linkedlistii;

public class ReverseNodesInKGroupCodingNinjas {

	public static void main(String[] args) {
		int[] b = {1, 0, 2};
		Node input = getInput();
		Node output = getListAfterReverseOperation(input, 3, b);
		System.out.println(output);
	}

    public static Node getListAfterReverseOperation(Node head, int n, int b[]) {
        Node temp = head;
        int i = 0;
        Node nextNode = null;
		Node prevGroupLastNode = null;

        while (temp != null) {
			if (i >= n) {
				if (prevGroupLastNode != null) prevGroupLastNode.next = temp;
				break;
			}
			if (b[i] == 0) {
				i++;
				continue;
			}
            Node kthNode = getKthNode(temp, b[i]);
			if (kthNode == null) {
				Node reversedHead = reverseLinkedList(temp);
				if (prevGroupLastNode != null) {
					prevGroupLastNode.next = reversedHead;
				} else {
					head = reversedHead;
				}
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

    private static Node reverseLinkedList(Node head) {
        Node curr = head;
        Node prev = null;

        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
		return prev;
    }

    private static Node getKthNode(Node head, int k) {
        Node temp = head;
        int i = 1;
        while (temp != null && i < k) {
            temp = temp.next;
            i++;
        }
        return temp;
    }

	public static Node getInput() {
		Node node = new Node(5);
		node.next = new Node(7);
		node.next.next = new Node(8);
		node.next.next.next = new Node(2);
		node.next.next.next.next = new Node(4);
		return node;
	}

}