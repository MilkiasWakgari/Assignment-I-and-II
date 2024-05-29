package DSA.assignment2;

public class LinkedList {
    private Node head;

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // 1. Insert a Node at Any Given Position
    public void insertAtPos(int data, int position) {
        Node newNode = new Node(data);
        if (position == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Position out of bounds");
            return;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    // 2. Delete a Node at Any Given Position
    public void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (position == 1) {
            head = head.next;
            return;
        }
        Node current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null || current.next == null) {
            System.out.println("Position out of bounds");
            return;
        }
        current.next = current.next.next;
    }

    // 3. Delete a Node After a Given Node
    public void deleteAfterNode(int data) {
        Node current = head;
        while (current != null && current.data != data) {
            current = current.next;
        }
        if (current == null || current.next == null) {
            System.out.println("Node not found or no node after the given node");
            return;
        }
        current.next = current.next.next;
    }

    // 4. Search for a Node
    public boolean searchNode(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Method to display the LinkedList
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtPos(1, 1);
        list.insertAtPos(2, 2);
        list.insertAtPos(3, 3);
        list.display();

        list.deleteAtPosition(2);
        list.display();

        list.insertAtPos(4, 2);
        list.display();

        list.deleteAfterNode(1);
        list.display();

        System.out.println("Search 4: " + list.searchNode(4));
        System.out.println("Search 5: " + list.searchNode(5));
    }
}
