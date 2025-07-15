/* Leetcode -> 206. Reverse Linked List
 * Given the head of a singly linked list, reverse the list, and return 
 * the reversed list.
 */
public class ReverseLL {
    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode reverseList(ListNode head) { // using recursion
        if (head == null || head.next == null)
            return head; // Base case

        // sub problems
        ListNode Next = head.next;
        ListNode revNode = reverseList(head.next);
        head.next = null;
        Next.next = head;
        return revNode;
    }

    public static ListNode reverseList1(ListNode head) { // using iteration
        ListNode curr=head;
        ListNode Next=null;
        ListNode Prev=null;
        while(curr!=null){
            Next=curr.next;
            curr.next=Prev;
            Prev=curr;
            curr=Next;
        }
        return Prev;
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
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(4);
        list1.next.next.next.next = null;
        ListNode ans = reverseList(list1);
        ListNode ans1 = reverseList1(list1);
        printList(ans);
        printList(ans1);
    }
}
