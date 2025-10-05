package todo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TodoRepository repo = new TodoRepository();
        Scanner in = new Scanner(System.in);
        boolean running = true;

        System.out.println("To-Do ready. Database is todo_db");

        while (running) {
            System.out.println("\n1) Add  2) List  3) Complete  4) Delete  5) Exit");
            System.out.print("Choose: ");
            if (!in.hasNextInt()) { in.nextLine(); continue; }
            int choice = in.nextInt(); in.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Task: ");
                    String task = in.nextLine();
                    repo.add(task);
                    System.out.println("Saved");
                }
                case 2 -> repo.findAll().forEach(System.out::println);
                case 3 -> {
                    System.out.print("Id to complete: ");
                    long id = in.nextLong(); in.nextLine();
                    repo.setCompleted(id, true);
                    System.out.println("Updated");
                }
                case 4 -> {
                    System.out.print("Id to delete: ");
                    long id = in.nextLong(); in.nextLine();
                    repo.deleteById(id);
                    System.out.println("Deleted");
                }
                case 5 -> running = false;
                default -> System.out.println("Invalid");
            }
        }
    }
}
