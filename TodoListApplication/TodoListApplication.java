package TodoListApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TodoListApplication {

    public static void main(String[] args) {
        TodoList todoList = new TodoList();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Welcome to To-Do List Application");
            System.out.println("1. Add a Task");
            System.out.println("2. Mark a Task as Completed");
            System.out.println("3. Remove a Task");
            System.out.println("4. View All Tasks");
            System.out.println("5. Exit");
            System.out.println("Enter your choice:");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline after nextInt()

            switch (choice) {
                case 1:
                    System.out.println("Enter task description:");
                    String description = scanner.nextLine();
                    todoList.addTask(new Task(description));
                    System.out.println("Task added successfully.");
                    break;
                case 2:
                    System.out.println("Enter task number to mark as completed:");
                    int completeIndex = scanner.nextInt();
                    scanner.nextLine();
                    if (todoList.markTaskAsCompleted(completeIndex)) {
                        System.out.println("Task marked as completed.");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;
                case 3:
                    System.out.println("Enter task number to remove:");
                    int removeIndex = scanner.nextInt();
                    scanner.nextLine();
                    if (todoList.removeTask(removeIndex)) {
                        System.out.println("Task removed successfully.");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;
                case 4:
                    todoList.displayAllTasks();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting To-Do List Application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    break;
            }

            System.out.println();
        }

        scanner.close();
    }
}

class Task {
    private String description;
    private boolean completed;

    public Task(String description) {
        this.description = description;
        this.completed = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}

class TodoList {
    private List<Task> tasks;

    public TodoList() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public boolean markTaskAsCompleted(int index) {
        if (index >= 1 && index <= tasks.size()) {
            tasks.get(index - 1).setCompleted(true);
            return true;
        }
        return false;
    }

    public boolean removeTask(int index) {
        if (index >= 1 && index <= tasks.size()) {
            tasks.remove(index - 1);
            return true;
        }
        return false;
    }

    public void displayAllTasks() {
        System.out.println("Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            System.out.println((i + 1) + ". " + task.getDescription() + " - " + (task.isCompleted() ? "Completed" : "Pending"));
        }
    }
}
