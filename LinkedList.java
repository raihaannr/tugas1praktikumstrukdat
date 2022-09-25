public class LinkedList {
    class Node {
        int val;
        Node next;
 
        Node(int val){
            this.val = val;
        }
    }
 
    private Node head;
    private Node tail;
 
    // methode add dikolom 
    public void addFirst(int val){
        if(isEmpty()) {
            head = new Node(val);
            tail = head;
            return;
        }
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }
 
    public void addLast(int val){
        if(isEmpty()) {
            head = new Node(val);
            tail = head;
            return;
        }
        Node newNode = new Node(val);
        tail.next = newNode;
        tail = newNode;
    }
 
    public void insert(int ind, int val){
        if( ind == 0 ){
            addFirst(val);
            return;
        }
        Node current = head;
        int count = 0;
        while(count < ind-1) {
            count++;
            current = current.next;
        }
        Node newNode = new Node(val);
        newNode.next = current.next;
        current.next = newNode;
    }
 
    public int deleteFirst(){
        if(isEmpty()) {
            throw new RuntimeException("List is Empty");
        }
        Node current = head;
        head = head.next;
        current.next = null;
        if(isEmpty()) {
            tail = null;
        }
        return current.val;
    }
 
    public int deleteLast() {
        if(isEmpty()) {
            throw new RuntimeException("List is Empty");
        }
        if(head == tail) {
            int val = head.val;
            head = null;
            tail = null;
            return val;
        }
        Node current = head;
        Node prev = null;
 
        while (current.next != null){
            prev = current;
            current = current.next;
        }
        prev.next = null;
        tail = prev;
        return current.val;
    }
 
    public int remove(int ind){
        if(isEmpty()) {
            throw new RuntimeException("List is Empty");
        }
        if(ind == 0) {
            deleteFirst();
        }
        Node current = head;
        int count = 0;
 
        while(count < ind-1) {
            count++;
            current = current.next;
        }
        return current.val;
    }

    public void deleteNode(int val){
        Node temp = head, prev = null;
  
        while (temp != null && temp.val == val) 
        {
            head = temp.next;
            temp = head;
        }
  
        while (temp != null) 
        {
            while (temp != null && temp.val != val) 
            {
                prev = temp;
                temp = temp.next;
            }
  
            if (temp == null)
                return;
  
            prev.next = temp.next;
  
            temp = prev.next;
        }
    }

    public void removeDuplicate() {  
        //Node current will point to head  
        Node current = head, index = null, temp = null;  
  
        if(head == null) {  
            return;  
        }  
        else {  
            while(current != null){  
                temp = current;  
                index = current.next;  
  
                while(index != null) {  
                    if(current.val == index.val) {  
                        temp.next = index.next;  
                    }  
                    else {  
                        temp = index;  
                    }  
                    index = index.next;  
                }  
                current = current.next;  
            }  
        }  
    }  

    public void tailToHead() {
        if (head == null || head.next == null)
            return;
 
        Node secLast = null;
        Node last = head;
 
        while (last.next != null) {
            secLast = last;
            last = last.next;
        }
 
        secLast.next = null;
 
        last.next = head;
 
        head = last;

    }

    public void swap(int n1, int n2){  
        Node prevNode1 = null, prevNode2 = null, node1 = head, node2 = head;  
          
 
        if(head == null) {  
            return;  
        }  
          
        if(n1 == n2)  
            return;  
          
        while(node1 != null && node1.val != n1){  
            prevNode1 = node1;  
            node1 = node1.next;  
        }  
          
        while(node2 != null && node2.val != n2){  
            prevNode2 = node2;  
            node2 = node2.next;  
        }  
          
        if(node1 != null && node2 != null) {  
              
            if(prevNode1 != null)  
                prevNode1.next = node2;          
            else  
                head  = node2;  
              
            if(prevNode2 != null)  
                prevNode2.next = node1;  
            else  
                head  = node1;  
              
            Node temp = node1.next;   
            node1.next = node2.next;   
            node2.next = temp;       
        }      
        else {  
            System.out.println("Swapping is not possible");  
        }  
    }

    public void display() {  
        Node current = head;  
          
        if(head == null) {  
            System.out.println("List is empty");  
            return;  
        }  
        while(current != null) {  
            System.out.print(current.val + " ");  
            current = current.next;  
        }  
        System.out.println();  
    }  
 
    public boolean find(int val){
        Node current = head;
        while(current != null){
            if(val == current.val) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
 
    public boolean isEmpty(){
        return head == null ;
    }
 
 
    public void print(){
        Node current = head;
        while(current != null){
            System.out.print(current.val +"  ");
            current = current.next;
        }
        System.out.println("");
    }
 
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
 
        ll.addFirst(4);
        System.out.print("(1)   ");
        ll.print();
 
        ll.addFirst(6);
        System.out.print("(2)   ");
        ll.print();
 
        ll.addLast(2);
        System.out.print("(3)   ");
        ll.print();
 
        ll.addLast(9);
        System.out.print("(4)   ");
        ll.print();
 
        ll.addFirst(1);
        System.out.print("(5)   ");
        ll.print();
 
        ll.insert(0, 5);
        System.out.print("(6)   ");
        ll.print();
 
        ll.deleteFirst();
        System.out.print("(7)   ");
        ll.print();
 
        ll.deleteLast();
        System.out.print("(8)   ");
        ll.print();
 
        ll.remove(1);
        System.out.print("(9)   ");
        ll.print();

        ll.addLast(2);
        System.out.print("(10)  ");
        ll.print();

        ll.addLast(8);
        System.out.print("(11)  ");
        ll.print();

        ll.addFirst(1);
        System.out.print("(12)  ");
        ll.print();

        ll.swap(4, 6);
        System.out.print("(10)  ");
        ll.print();

        ll.swap(4, 2);
        System.out.print("(11)  ");
        ll.print();


        ll.deleteNode( 6);
        System.out.print("(13)  ");
        ll.print();

        ll.removeDuplicate();
        System.out.print("(14)  ");
        ll.print();

        ll.tailToHead();
        System.out.print("(15)  ");
        ll.print();
 
    }
}
