import java.util.Scanner;
import java.util.Set;

public class HashSet {

    public static void main(String[] args) {
        // Initialize a HashSet of integers
        Set<Integer> set = new java.util.HashSet<>();
        Scanner scanner = new Scanner(System.in);
        int choice, element;

        // Menu-driven approach for HashSet operations
        do {
            System.out.println("\n--- HashSet Operations ---");
            System.out.println("1. Add element");
            System.out.println("2. Remove element");
            System.out.println("3. Display all elements");
            System.out.println("4. Search for an element");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add an element
                    System.out.print("Enter the element to add: ");
                    element = scanner.nextInt();
                    if (set.add(element)) {
                        System.out.println("Element " + element + " added.");
                    } else {
                        System.out.println("Element " + element + " already exists!");
                    }
                    break;

                case 2:
                    // Remove an element
                    System.out.print("Enter the element to remove: ");
                    element = scanner.nextInt();
                    if (set.remove(element)) {
                        System.out.println("Element " + element + " removed.");
                    } else {
                        System.out.println("Element " + element + " not found in the set.");
                    }
                    break;

                case 3:
                    // Display all elements
                    System.out.println("Elements in the HashSet:");
                    if (set.isEmpty()) {
                        System.out.println("Set is empty.");
                    } else {
                        for (Integer e : set) {
                            System.out.println(e);
                        }
                    }
                    break;

                case 4:
                    // Search for an element
                    System.out.print("Enter the element to search: ");
                    element = scanner.nextInt();
                    if (set.contains(element)) {
                        System.out.println("Element " + element + " is present in the set.");
                    } else {
                        System.out.println("Element " + element + " is not present in the set.");
                    }
                    break;

                case 5:
                    // Exit
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);

        // Close the scanner
        scanner.close();
    }
}



/* 

Algorithm:

Initialize a HashSet to store elements.
Switch Case Menu:
    Add Element:
        Take the element as input and add it to the HashSet.
        The add() method is used, which ensures no duplicates are inserted.
    Delete Element:
        Take the element as input and remove it from the set using the remove() method.
    Display All Elements:
        Iterate through the HashSet and print all elements.
    Search for an Element:
        Use the contains() method to check if the element exists in the set.
Repeat the operations until the user chooses to exit.

 */