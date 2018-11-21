package com.ds.saggi;

public class LinkedListImpl {
    
    public class LinkedListImpl {

    private static class LinkedList {
        Node head;
        
        public LinkedList() {
            head = null;
        }
        
        public LinkedList(int value) {
            head = new Node(value);
        }
    }
    
    private static class Node {
        int value;
        Node next;
        
        public Node(int val, Node next) {
            this.value = value;
            this.next = next;
        }
        
        public Node(int value) {
            this.value = value;
            this.next = null;
        }
        
        public Node getNext() {
            return this.next;
        }
        
        public void setNext(Node next) {
            this.next = next;
        }
        
        public boolean hasNext() {
            return (this.next != null);
        }
    }
    
    private static int[] arr = {1,4,7,3,6,0,9};
    
    /**
     * 1,4,7,3,6,0,9
     */
    public static void main(String args[]) {
        LinkedList list = new LinkedList();
        list.head = new Node(arr[0]);
        createLinkedListFromArray(list.head, 0);
        System.out.println("\nTotal number of nodes : "+ getCount(list.head));
        System.out.println("Search for a position - 4 : " + search(list.head, 8));
    }
    
    private static int getCount(Node node) {
        int count = 0;
        
        if(node == null) return count;
        
        while(node != null) {
            count++;
            System.out.print(node.value + " ");
            node = node.getNext();
        }
        
        return count;
    }
    
    private static void createLinkedListFromArray(Node node, int index) {
        
        if(node == null) return;
        
        if(index < arr.length -1) {
            Node nextNode = new Node(arr[index+1]);
            node.setNext(nextNode);
            createLinkedListFromArray(nextNode, index+1);
        }
    }
    
    private static int search(Node head, int position) {
        if(head == null) {
            return -1;
        }
        if(position == 1) {
            return head.value;
        } else {
            int i = 1;
            while(i < position) {
                if(head == null || head.getNext() == null) return -1;
                head = head.getNext();
                i++;
            }
            return head.value;
        }
    }
    
}
