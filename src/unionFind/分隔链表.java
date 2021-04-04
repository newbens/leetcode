package unionFind;

public class 分隔链表 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(2);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode partition = new 分隔链表().partition(head, 3);
        while (partition != null) {
            System.out.println(partition.val);
            partition = partition.next;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode big = new ListNode(0);
        ListNode min = new ListNode(0);
        ListNode temp1 = big;
        ListNode temp2 = min;
        while (head != null ) {
            if (head.val >= x) {
                temp1.next = head;
                temp1 = temp1.next;
            }else {
                temp2.next = head;
                temp2 = temp2.next;
            }
            head = head.next;
        }
        temp2.next = big.next;
        temp1.next = null;
        return min.next;
    }
}
 class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
