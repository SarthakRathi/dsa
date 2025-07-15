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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1)
            return head;

        ListNode temp = head;
        ListNode prev = null;

        while (temp != null) {
            ListNode kNode = findKNode(temp, k);

            if (kNode == null) {
                if (prev != null)
                    prev.next = temp;
                break;
            }

            ListNode nextNode = kNode.next;
            kNode.next = null;

            ListNode reversedHead = reverseList(temp);

            if (temp == head) {
                head = reversedHead;
            } else {
                prev.next = reversedHead;
            }

            prev = temp;
            temp = nextNode;
        }

        return head;
    }

    public ListNode findKNode(ListNode temp, int k) {
        k -= 1;
        while (temp != null && k > 0) {
            k--;
            temp = temp.next;
        }
        return temp;
    }

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

// Time Complexity = O(2n)
// Space Complexity = O(1)