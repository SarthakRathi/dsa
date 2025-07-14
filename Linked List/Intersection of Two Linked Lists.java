class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

// Better
// class Solution {
// public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
// int n1 = 0;
// int n2 = 0;
// ListNode t1 = headA;
// ListNode t2 = headB;

// while (t1 != null) {
// t1 = t1.next;
// n1++;
// }
// while (t2 != null) {
// t2 = t2.next;
// n2++;
// }

// if (n1 < n2) {
// return collisionPoint(headA, headB, n2 - n1);
// } else {
// return collisionPoint(headB, headA, n1 - n2);
// }
// }

// public static ListNode collisionPoint(ListNode t1, ListNode t2, int distance)
// {
// for (int i = 0; i < distance; i++) {
// t2 = t2.next;
// }

// while (t1 != null) {
// if (t1 == t2) {
// return t1;
// }
// t1 = t1.next;
// t2 = t2.next;
// }
// return null;
// }
// }

// Time Complexity = O(n)
// Space Complexity = O(1)

// Optimal
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode t1 = headA;
        ListNode t2 = headB;

        while (t1 != t2) {

            t1 = t1.next;
            t2 = t2.next;

            if (t1 == t2)
                return t1;

            if (t1 == null)
                t1 = headB;
            if (t2 == null)
                t2 = headA;
        }
        return t1;
    }
}

// Time Complexity = O(n)
// Space Complexity = O(1)