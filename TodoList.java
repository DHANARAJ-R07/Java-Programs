import java.util.*;

class TodoList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] tasks = new String[3];

        // Input
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter task " + (i + 1) + ": ");
            tasks[i] = sc.nextLine();
        }

        // Output
        System.out.println("\nYour To-Do List:");
        for (int i = 0; i < 3; i++) {
            System.out.println((i + 1) + ". " + tasks[i]);
        }
    }
}