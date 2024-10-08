import java.util.Scanner;

public class MovingListApp {
    public static void main(String[] args) throws Exception {
        MoveListManager manager = new MoveListManager();
        Scanner scanner = new Scanner(System.in);
        
        // Pre-load suggested items from a CSV file (dynamic array)
        String csvFilePath = "src\\suggested_items.csv"; // Ensure this file exists in your project
        System.out.println("Loading suggested items...");
        MoveListManager.loadSuggestedItems(csvFilePath).forEach(item -> {
            manager.addItem(new EssentialItem(item));
        });
        
        
        String option;
        do {
            System.out.println("\nApartment Moving List - Options:");
            System.out.println("1. Add Item");
            System.out.println("2. Delete Item");
            System.out.println("3. Modify Item");
            System.out.println("4. Display List");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            option = scanner.nextLine();
            
            switch (option) {
                case "1":
                    System.out.print("Enter the item name: ");
                    String newItem = scanner.nextLine();
                    System.out.print("Is this item essential? (yes/no): ");
                    String essential = scanner.nextLine();
                    Item itemToAdd = essential.equalsIgnoreCase("yes") ? 
                        new EssentialItem(newItem) : new NonEssentialItem(newItem);
                    manager.addItem(itemToAdd);
                    break;
                case "2":
                    System.out.print("Enter the name of the item to delete: ");
                    String itemToDelete = scanner.nextLine();
                    manager.deleteItem(itemToDelete);
                    break;
                case "3":
                    System.out.print("Enter the current name of the item: ");
                    String oldName = scanner.nextLine();
                    System.out.print("Enter the new name: ");
                    String newName = scanner.nextLine();
                    manager.modifyItem(oldName, newName);
                    break;
                case "4":
                    manager.displayList();
                    break;
                case "5":
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (!option.equals("5"));
        
        scanner.close();
    }
}
