package DSA.assignment2;

public class Stack {
    private Node top;

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Stack() {
        this.top = null;
    }

    // Push operation
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    // Pop operation
    public int pop() {
        if (top == null) {
            System.out.println("Stack is empty");
            return -1;
        }
        int poppedData = top.data;
        top = top.next;
        return poppedData;
    }

    // Peek operation
    public int peek() {
        if (top == null) {
            System.out.println("Stack is empty");
            return -1;
        }
        return top.data;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element is: " + stack.peek());

        System.out.println("Popped element is: " + stack.pop());
        System.out.println("Popped element is: " + stack.pop());

        System.out.println("Top element is: " + stack.peek());
    }
}
