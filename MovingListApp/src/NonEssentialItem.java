public class NonEssentialItem extends Item {
    
    public NonEssentialItem(String name) {
        super(name);
    }

    @Override
    public String getImportanceLevel() {
        return "Non-Essential";
    }
}
