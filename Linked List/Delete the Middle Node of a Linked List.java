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

class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;

        if (fast.next != null) {
            fast = fast.next.next;
        }

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;
        return head;
    }
}

// Time Complexity = O(n/2)
// Space Complexity = O(1)