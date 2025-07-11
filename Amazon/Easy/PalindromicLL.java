package Amazon.Easy;

public class PalindromicLL {

    static class ListNode {
        int val;
        ListNode next;
    }

    static ListNode newNode(int key) {
        ListNode temp = new ListNode();
        temp.val = key;
        temp.next = null;
        return temp;
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // while (fast != null) {
        // slow = slow.next;
        // }

        slow = reverse(slow);
        fast = head;

        while (fast != null && slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = newNode(1);
        head.next = newNode(2);
        head.next.next = newNode(2);
        head.next.next.next = newNode(1);

        System.out.println(isPalindrome(head));
    }
}
