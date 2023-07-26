import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
    }


    class Solution {
        public boolean isPalindrome(ListNode head) {
            ListNode slow = head, fast = head, prev, temp;
            // find middle where slow = middl and fast = end
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            prev = slow; // prev = middle node
            slow = slow.next; // slow = one to the right of the middle
            prev.next = null; // cuts the first half of list off from back half

            //starts with slow on first node in back half and reverses the point directoin of the back half of list
            while (slow != null) {
                temp = slow.next;
                slow.next = prev; // slow is to the right of middle and points to the middle. the middle does not point
                // left to a node so is therefor null to the left
                prev = slow;
                slow = temp;
            }

            fast = head;
            slow = prev; // slow previously null when while loop terminated, reset to prev (last node in back half)
            while (slow != null) { // once slow incremenetd past middlee nodee, loop terminated
                if (fast.val != slow.val) return false;
                fast = fast.next;
                slow = slow.next;
            }
            return true; // if no inequalities found, then true
        }
    }
}


//attempt
//    class Solution {
//        public boolean isPalindrome(ListNode head) {
//            ListNode reverse = // how to actually make a copy?
//                    LinkedList.
//            ListNode pre = null;
//            ListNode temp = head;
//            ListNode after = head.next;
//            while(after != null){
//                temp.next = pre;
//                pre = temp;
//                temp = after;
//                after = after.next;
//            }
//            reverse = temp;
//
//            while(head)
//        }
//    }

// reverse then compare. O(2n) solution
// pre = null, temp = head, after = head.next
// temp.next = pre,  pre = temp, temp = after, after = temp.next while after.next != null.
// head = after. compare lists
