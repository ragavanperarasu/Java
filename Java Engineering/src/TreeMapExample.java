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
/*
Algorithm:
Start.
Create a TreeMap object to store the key-value pairs.
Present a menu with the following options:
    Add an element (key-value pair).
    Delete an element by key.
    Display all elements.
    Search for a specific key.
    Exit the program.
Depending on the user's choice:
    Add: Prompt the user to enter a key and a value, then insert the pair into the TreeMap.
    Delete: Prompt the user to enter a key, then remove the corresponding entry from the TreeMap.
    Display: Print all key-value pairs in the TreeMap.
    Search: Prompt the user to enter a key, and check if the key exists in the TreeMap.
Exit: Terminate the program.
Loop until the user chooses to exit.
End.

Explanation:
TreeMap:

TreeMap<Integer, String> is used to store key-value pairs where the key is an integer, and the value is a string.
The TreeMap automatically sorts elements based on the key.
Switch-Case Structure:

Add Element: Prompts the user for a key and a value, then adds the key-value pair to the TreeMap using put().
Delete Element: Prompts the user for a key and removes the corresponding entry using remove().
Display Elements: Iterates through the TreeMap using a for-each loop and prints all key-value pairs.
Search for a Key: Prompts the user for a key and checks if it exists using containsKey(). If found, it displays the corresponding value.
User Interaction:

The user interacts with the program via the console, choosing actions from the menu.
The loop continues until the user selects the exit option (choice == 5).
*/