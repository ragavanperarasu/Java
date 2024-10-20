import java.util.Scanner;
import java.util.TreeMap;

public class TreeMapExample {


    public static void main(String[] args) {
        // Create a TreeMap to store Integer-String pairs
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("\n--- TreeMap Operations ---");
        System.out.println("1. Add Element (Key-Value)");
        System.out.println("2. Delete Element by Key");
        System.out.println("3. Display All Elements");
        System.out.println("4. Search for a Key");
        System.out.println("5. Exit");

        do {
            System.out.print("\nEnter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Key (Integer): ");
                    int key = scanner.nextInt();
                    System.out.print("Enter Value (String): ");
                    scanner.nextLine(); // Consume newline character
                    String value = scanner.nextLine();
                    treeMap.put(key, value);
                    System.out.println("Element added successfully!");
                    break;

                case 2:
                    // Delete element by key from TreeMap
                    System.out.print("Enter Key to Delete: ");
                    key = scanner.nextInt();
                    if (treeMap.remove(key) != null) {
                        System.out.println("Element deleted successfully!");
                    } else {
                        System.out.println("Key not found!");
                    }
                    break;

                case 3:
                    // Display all elements in TreeMap
                    if (!treeMap.isEmpty()) {
                        System.out.println("TreeMap Elements:");
                        for (Integer k : treeMap.keySet()) {
                            System.out.println("Key: " + k + ", Value: " + treeMap.get(k));
                        }
                    } else {
                        System.out.println("TreeMap is empty.");
                    }
                    break;

                case 4:
                    // Search for a specific key in TreeMap
                    System.out.print("Enter Key to Search: ");
                    key = scanner.nextInt();
                    if (treeMap.containsKey(key)) {
                        System.out.println("Key found! Value: " + treeMap.get(key));
                    } else {
                        System.out.println("Key not found!");
                    }
                    break;

                case 5:
                    // Exit the program
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
