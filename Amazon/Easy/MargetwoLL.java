package Amazon.Easy;

public class MargetwoLL {
    /*
     * Leetcod -> 21. Merge Two Sorted Lists
     * You are given the heads of two sorted linked lists list1 and list2.
     * 
     * Merge the two lists into one sorted list.
     * The list should be made by splicing together the nodes of the first two
     * lists.
     * 
     * Return the head of the merged linked list.
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode ans = list1;
        while (list1 != null && list2 != null) {
            ListNode temp = list1;
            while (list1 != null && list1.val <= list2.val) {
                temp = list1;
                list1 = list1.next;
            }
            temp.next = list2;
            ListNode t = list1;
            list1 = list2;
            list2 = t;
        }

        return ans;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(2);
        list2.next.next = new ListNode(3);

        ListNode ans = mergeTwoLists(list1, list2);
        printList(ans);
    }
}
