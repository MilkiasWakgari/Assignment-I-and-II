package DSA.assignment1;

public class ToDoList {
    private Node head;

    public ToDoList() {
        this.head = null;
    }

    public void addToDo(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void markToDoAsCompleted(String title) {
        Node current = head;
        while (current != null) {
            if (current.task.getTitle().equals(title)) {
                current.task.markCompleted();
                return;
            }
            current = current.next;
        }
        System.out.println("Task with title '" + title + "' not found.");
    }

    public void viewToDoList() {
        Node current = head;
        while (current != null) {
            Task task = current.task;
            System.out.println("Title: " + task.getTitle());
            System.out.println("Description: " + task.getDescription());
            System.out.println("Completed: " + (task.isCompleted() ? "Yes" : "No"));
            System.out.println();
            current = current.next;
        }
    }

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();

        Task task1 = new Task("Buy groceries", "Buy milk, eggs, and bread");
        Task task2 = new Task("Clean house", "Vacuum and dust all rooms");
        Task task3 = new Task("Finish project", "Complete the Java project");

        toDoList.addToDo(task1);
        toDoList.addToDo(task2);
        toDoList.addToDo(task3);

        System.out.println("To-Do List:");
        toDoList.viewToDoList();

        toDoList.markToDoAsCompleted("Clean house");

        System.out.println("Updated To-Do List:");
        toDoList.viewToDoList();
    }
}

