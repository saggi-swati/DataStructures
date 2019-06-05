package ds.saggi.in.datastructures;


import java.util.List;

public class LinkedListImpl {

    private static class LinkedList {
        ListNode head;

        public LinkedList() {
            head = null;
        }

        public LinkedList(int value) {
            head = new ListNode(value);
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }

        public ListNode getNext() {
            return this.next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        public boolean hasNext() {
            return (this.next != null);
        }
    }

    private static int[] arr = {1, 4, 7, 3, 6, 0, 9};

    /**
     * 1,4,7,3,6,0,9
     */
    public static void main1(String args[]) {
        LinkedList list = new LinkedList();
        /*list.head = new ListNode(arr[0]);
        createLinkedListFromArray(list.head, 0);
        System.out.println("\nTotal number of nodes : " + getCount(list.head));
        System.out.println("Search for a position - 4 : " + search(list.head, 8));*/

        ListNode head = new ListNode(9);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(9);

        ListNode listNode = addTwoNumbers(head, head2);

        System.out.println("LinkedListImpl.main" + listNode.val);

        while(listNode != null) {
            System.out.print( listNode.val);
            listNode = listNode.next;
        }

    }

    private static int getCount(ListNode listNode) {
        int count = 0;

        if (listNode == null) return count;

        while (listNode != null) {
            count++;
            System.out.print(listNode.val + " ");
            listNode = listNode.getNext();
        }

        return count;
    }

    private static void createLinkedListFromArray(ListNode listNode, int index) {

        if (listNode == null) return;

        if (index < arr.length - 1) {
            ListNode nextListNode = new ListNode(arr[index + 1]);
            listNode.setNext(nextListNode);
            createLinkedListFromArray(nextListNode, index + 1);
        }
    }

    private static int search(ListNode head, int position) {
        if (head == null) {
            return -1;
        }
        if (position == 1) {
            return head.val;
        } else {
            int i = 1;
            while (i < position) {
                if (head == null || head.getNext() == null) return -1;
                head = head.getNext();
                i++;
            }
            return head.val;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int num1 = 0, num2 = 0;
        int p = 0;
        while(l1 != null) {
            num1 = num1 + l1.val * (int)Math.pow(10, p);
            p++;
            l1 = l1.next;
        }

        p = 0;
        while(l2 != null) {
            num2 = num2 + l2.val * (int)Math.pow(10, p);
            p++;
            l2 = l2.next;
        }

        int n =( num1 + num2);
        int x = n%10;
        ListNode listNode = new ListNode(x);
        ListNode temp = listNode;
        n = n/10;
        while(n > 0) {
            x = n%10;
            temp.next = new ListNode(x);
            n = n/10;
            temp = temp.next;
        }

        return listNode;

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode result = new ListNode(0);
        ListNode prev = result;

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        if(l1 != null) {
            prev.next = l1;
        }

        if(l2 != null) {
            prev.next = l2;
        }

        return result.next;
    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {

        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

    /**
     * Input: 1->2->4, 1->3->4
     * Output: 1->1->2->3->4->4
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(2);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode head1 = mergeTwoLists(l1, l2);
        ListNode head2 = mergeTwoLists2(l1, l2);

        System.out.println("LinkedListImpl.main : " + head1 + " " + head2);
    }
}

