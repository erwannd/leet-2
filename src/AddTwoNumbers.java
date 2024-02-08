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

public class AddTwoNumbers {
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

    public void insertNewNode(ListNode l1, ListNode l2, ListNode result, int carry_over) {
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
     * @param arr the array
     * @return the head of the created ListNode
     */
    ListNode getNode(int[] arr) {
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
        ListNode n1 = atn.getNode(new int[]{5,6});
        ListNode n2 = atn.getNode(new int[]{5,4,9});
        ListNode result = atn.addTwoNumbers(n1,n2);
        System.out.println(result);

//        new int[]{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1}
//        new int[]{5,6,4}
    }
}
