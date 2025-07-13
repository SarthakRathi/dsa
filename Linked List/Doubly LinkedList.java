class LinkedList {
    Node head;
    private int size;

    LinkedList() {
        this.size = 0;
    }

    class Node {
        String data;
        Node prev;
        Node next;

        Node(String data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }

        Node(String data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    // Add first
    public void addFirst(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    // Add last
    public void addLast(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node currNode = head;
            while (currNode.next != null) {
                currNode = currNode.next;
            }
            currNode.next = newNode;
            newNode.prev = currNode;
        }
        size++;
    }

    // Delete First
    public void deleteFirst() {
        if (head == null) {
            return;
        }
        size--;
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
    }

    // Delete Last
    public void deleteLast() {
        if (head == null) {
            return;
        }

        size--;
        if (head.next == null) {
            head = null;
            return;
        }

        Node currNode = head;
        while (currNode.next.next != null) {
            currNode = currNode.next;
        }
        currNode.next = null;
    }

    // Size
    public int getSize() {
        return size;
    }

    // Print
    public void print() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node currNode = head;
        while (currNode != null) {
            System.out.println(currNode.data);
            currNode = currNode.next;
        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.print();
        ll.addFirst("5");
        ll.addLast("10");
        ll.print();
    }
}
