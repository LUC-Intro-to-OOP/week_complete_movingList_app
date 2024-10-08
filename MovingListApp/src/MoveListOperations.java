
public interface MoveListOperations {
    void addItem(Item item);
    void deleteItem(String itemName);
    void modifyItem(String oldItemName, String newItemName);
    void displayList();
}
