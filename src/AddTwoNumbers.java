/**
 * Definition for singly-linked list, given in the problem statement.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return val + "->" + next;
    }
}

/**
 * Problem description:
 * Given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * Assume the two numbers do not contain any leading zero,
 * except the number 0 itself.

 * Example1:
 * list1    = 2 -> 4 -> 3
 * list2    = 5 -> 6 -> 4
 * result   = 7 -> 0 -> 8

 * Example2:
 * list1    = 9 -> 9 -> 9 -> 9 -> 9 -> 9 -> 9
 * list2    = 9 -> 9 -> 9 -> 9
 * result   = 8 -> 9 -> 9 -> 9 -> 0 -> 0 -> 0 -> 1
 */
public class AddTwoNumbers {

    /**
     * Given two linked list, this method returns
     * a new linked list with their total values.
     * @return the head of the new linked list
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry_over = 0;
        int total = l1.val + l2.val;

        if (total >= 10) {
            carry_over = total / 10;
            total = total - 10;
        }

        ListNode result = new ListNode(total);
        insertNewNode(l1.next,l2.next,result,carry_over);
        return result;
    }

    /**
     * Recursive helper method for addTwoNumbers(l1, l2).
     * This method creates a node and appends it
     * at the end of the new linked list.
     * @param l1 the linked list
     * @param l2 the other linked list
     * @param result the resulting linked list
     * @param carry_over value to be added to the next recursive call
     */
    private void insertNewNode(ListNode l1, ListNode l2, ListNode result, int carry_over) {
        if (l1 == null && l2 == null && carry_over == 0) return;

        int val1 = 0, val2 = 0;
        boolean l1Null = true;
        boolean l2Null = true;

        if (l1 != null) {
            val1 = l1.val;
            l1Null = false;
        }

        if (l2 != null) {
            val2 = l2.val;
            l2Null = false;
        }

        int total = val1 + val2 + carry_over;
        carry_over = 0;

        if (total >= 10) {
            carry_over = total / 10;
            total = total - 10;
        }

        result.next = new ListNode(total);

        insertNewNode(l1Null ? null : l1.next, l2Null ? null : l2.next, result.next, carry_over);
    }

    /**
     * Parse an array of integers to a ListNode object.
     * Use this method for testing.
     * @param arr the array
     * @return the head of the created ListNode
     */
    ListNode parseArray(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode tmp = head;
        for (int i = 1; i < arr.length; i++) {
            tmp.next = new ListNode(arr[i]);
            tmp = tmp.next;
        }
        return head;
    }


    public static void main(String[] args) {
        AddTwoNumbers atn = new AddTwoNumbers();
        ListNode n1 = atn.parseArray
                (new int[]{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1});
        ListNode n2 = atn.parseArray(new int[]{5,6,4});
        ListNode result = atn.addTwoNumbers(n1,n2);
        System.out.println(result);
    }
}
