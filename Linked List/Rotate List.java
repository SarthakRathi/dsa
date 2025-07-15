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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int len = 1;
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        if (k % len == 0)
            return head;
        k = k % len;
        tail.next = head;

        ListNode newLast = findNode(head, len - k);
        head = newLast.next;
        newLast.next = null;

        return head;
    }

    public ListNode findNode(ListNode temp, int k) {
        int cnt = 1;
        while (temp != null) {
            if (cnt == k)
                return temp;
            cnt++;
            temp = temp.next;
        }
        return temp;
    }
}

// Time Complexity = O(n)
// Space Complexity = O(1)