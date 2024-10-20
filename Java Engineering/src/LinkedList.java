import java.util.Scanner;

public class LinkedList {

    public static void main(String[] args) {
        // Initialize LinkedList
        java.util.LinkedList<Integer> list = new java.util.LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int choice, element, index;

        // Menu for LinkedList Operations
        do {
            System.out.println("\n--- Linked List Operations ---");
            System.out.println("1. Add element at specific index");
            System.out.println("2. Delete element from specific index");
            System.out.println("3. Display all elements");
            System.out.println("4. Search for an element");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add element at specific index
                    System.out.print("Enter the index where you want to add the element: ");
                    index = scanner.nextInt();
                    System.out.print("Enter the element to add: ");
                    element = scanner.nextInt();
                    if (index >= 0 && index <= list.size()) {
                        list.add(index, element);
                        System.out.println("Element " + element + " added at index " + index);
                    } else {
                        System.out.println("Invalid index!");
                    }
                    break;

                case 2:
                    // Delete element from specific index
                    System.out.print("Enter the index of the element to remove: ");
                    index = scanner.nextInt();
                    if (index >= 0 && index < list.size()) {
                        element = list.remove(index);
                        System.out.println("Element " + element + " removed from index " + index);
                    } else {
                        System.out.println("Invalid index!");
                    }
                    break;

                case 3:
                    // Display all elements
                    System.out.println("Elements in the LinkedList:");
                    if (list.isEmpty()) {
                        System.out.println("List is empty.");
                    } else {
                        for (int i = 0; i < list.size(); i++) {
                            System.out.println("Index " + i + ": " + list.get(i));
                        }
                    }
                    break;

                case 4:
                    // Search for an element
                    System.out.print("Enter the element to search: ");
                    element = scanner.nextInt();
                    if (list.contains(element)) {
                        System.out.println("Element " + element + " found in the list.");
                    } else {
                        System.out.println("Element " + element + " not found in the list.");
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

Initialize a LinkedList to store elements.

Switch Case Menu:
    Add at Specific Index:
        Take the index and element as input.
        Add the element to the LinkedList at the specified index.
    Delete from Specific Index:
        Take the index as input.
        Remove the element at the specified index.
    Display Elements:
        Iterate over the LinkedList and print all elements.
    Search for an Element:
        Take the element to search as input.
    Use the contains() method to check if the element exists in the list.
Repeat the operations until the user chooses to exit.

 */