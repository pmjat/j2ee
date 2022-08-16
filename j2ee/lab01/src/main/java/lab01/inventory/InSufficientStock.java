package lab01.inventory;

public class InSufficientStock extends java.lang.Exception {
	private static final long serialVersionUID = 1L;
	public InSufficientStock() {
        super("Error: Insufficient Stock");
    }
    public InSufficientStock(String message) {
        super(message);
    }    
}
