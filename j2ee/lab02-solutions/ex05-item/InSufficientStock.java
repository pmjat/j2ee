package j2ee.lab02.item;

public class InSufficientStock extends java.lang.Exception {
	public InSufficientStock() {
        super("Error: Insufficient Stock");
    }
    public InSufficientStock(String message) {
        super(message);
    }    
}
