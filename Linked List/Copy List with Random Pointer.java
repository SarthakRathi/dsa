class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        Node curr = head;
        while (curr != null) {
            Node copied = new Node(curr.val);
            copied.next = curr.next;
            curr.next = copied;
            curr = copied.next;
        }

        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        Node dummy = new Node(0);
        Node copiedCurr = dummy;
        curr = head;

        while (curr != null) {
            copiedCurr.next = curr.next;
            copiedCurr = copiedCurr.next;

            curr.next = curr.next.next;
            curr = curr.next;
        }

        return dummy.next;
    }
}

// Time Complexity = O(3n)
// Space Complexity = O(n)