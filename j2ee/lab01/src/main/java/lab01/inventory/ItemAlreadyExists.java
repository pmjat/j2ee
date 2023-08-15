package lab01.inventory;

public class ItemAlreadyExists extends java.lang.Exception {
	private static final long serialVersionUID = 1L;
	public ItemAlreadyExists() {
        super("Error: Item Already Exists");
    }
    public ItemAlreadyExists(String message) {
        super(message);
    }
    
}
