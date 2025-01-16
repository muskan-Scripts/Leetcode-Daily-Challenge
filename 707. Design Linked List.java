class Node {
    int val;
    Node next;

    public Node(int cv) {
        this.val = cv;
        this.next = null;
    }
}

class MyLinkedList {
    Node head;
    Node tail;
    int size;

    public MyLinkedList() {
        this.head = new Node(-1);
        this.tail = this.head;
        this.size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= this.size) return -1; // Fixed boundary condition
        Node temp = this.head.next;
        int cnt = 0;
        while (cnt != index) {
            temp = temp.next;
            cnt++;
        }
        return temp.val;
    }

    public void addAtHead(int val) {
        Node newnode = new Node(val);
        newnode.next = this.head.next;
        this.head.next = newnode;
        if (this.size == 0) this.tail = newnode; // Update tail if list was empty
        this.size++;
    }

    public void addAtTail(int val) {
        Node newnode = new Node(val);
        this.tail.next = newnode;
        this.tail = newnode;
        this.size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > this.size) return; // Corrected condition

        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == this.size) { // Add at tail if index == size
            addAtTail(val);
            return;
        }

        Node temp = this.head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        Node newnode = new Node(val);
        newnode.next = temp.next;
        temp.next = newnode;
        this.size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= this.size) return; // Corrected boundary condition

        Node temp = this.head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        if (index == this.size - 1) { // Update tail if last element is deleted
            this.tail = temp;
        }
        this.size--;
    }
}
