package lab01.inventory;

public class ItemNotFound extends Exception {
	private static final long serialVersionUID = 1L;
	public ItemNotFound() {
        super("Error: Item Not Found");
    }    
    public ItemNotFound(String message) {
        super(message);
    }
}
