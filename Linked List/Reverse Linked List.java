class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

// Iterative Solution
// class Solution {
// public ListNode reverseList(ListNode head) {
// ListNode temp = head;
// ListNode prev = null;
// ListNode front;

// while (temp != null) {
// front = temp.next;
// temp.next = prev;
// prev = temp;
// temp = front;
// }
// head = prev;
// return head;
// }
// }

// Time Complexity = O(n)
// Space Complexity = O(1)

// Recursive Solution
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);

        ListNode front = head.next;
        front.next = head;
        head.next = null;

        return newHead;
    }
}

// Time Complexity = O(n)
// Space Complexity = O(1)