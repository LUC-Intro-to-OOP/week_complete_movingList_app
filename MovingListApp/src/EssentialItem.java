public class EssentialItem extends Item {
    
    public EssentialItem(String name) {
        super(name);
    }

    @Override
    public String getImportanceLevel() {
        return "Essential";
    }
}
