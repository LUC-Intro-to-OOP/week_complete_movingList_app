import java.util.ArrayList;
import java.util.List;

public class MoveListManager implements MoveListOperations {
    private List<Item> itemList;

    public MoveListManager() {
        itemList = new ArrayList<>();
    }

    @Override
    public void addItem(Item item) {
        itemList.add(item);
        System.out.println(item.getName() + " added to the list.");
    }

    @Override
    public void deleteItem(String itemName) {
        itemList.removeIf(item -> item.getName().equalsIgnoreCase(itemName));
        System.out.println(itemName + " removed from the list.");
    }

    @Override
    public void modifyItem(String oldItemName, String newItemName) {
        for (Item item : itemList) {
            if (item.getName().equalsIgnoreCase(oldItemName)) {
                item.setName(newItemName);
                System.out.println(oldItemName + " updated to " + newItemName);
                return;
            }
        }
        System.out.println(oldItemName + " not found.");
    }

    @Override
    public void displayList() {
        if (itemList.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            System.out.println("Moving List:");
            for (Item item : itemList) {
                System.out.println(item);
            }
        }
    }


    public static List<String> loadSuggestedItems(String filePath) {
        return CSVReader.readCSV(filePath);
    }
}
