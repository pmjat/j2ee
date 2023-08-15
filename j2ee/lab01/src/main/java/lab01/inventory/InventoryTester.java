package lab01.inventory;

import java.util.ArrayList;

public class InventoryTester {

    public static void main(String[] args) {
        
        Inventory inventory = new Inventory();
        
        Item x = null;
        
        try {
	        x = new Item(101, "USB Mouse", 5, 10, 450 ); 
	        inventory.addItem(x);
	
	        x = new Item(102, "DVD Drive", 5, 5, 2100 ); 
	        inventory.addItem(x);
	        
	        x = new Item(103, "Hard Disk", 0, 2, 3500 ); 
	        inventory.addItem(x);
        }
        catch(ItemAlreadyExists e) {
        	System.out.println("Item: " + x.getItemCode() + " already exists!!");
        }
        try {
        
            inventory.addStock(103, 1);
            inventory.withdrawStock(102, 3);
        
        }
        catch(ItemNotFound e) {
        	System.out.println("Item: " + x.getItemCode() + " already exists!!");            
        }
        catch(InSufficientStock e) {
            
        }

        ArrayList<Item> ius = inventory.itemsUnderStock();
        
        for ( Item i : ius )
            System.out.println(i.getItemCode()+","+i.getItemDescription());     
        
    }
    
}
