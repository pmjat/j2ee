package j2ee.lab02.item;

public class ItemTester {

    public static void main(String[] args) {        
        Item[] inventory = new Item[10];
        int n = 0;
        inventory[n++] = new Item(101, "USB Mouse", 10, 5, 450 ); 
        inventory[n++] = new Item(102, "DVD Drive", 2, 3, 2100 ); 
        inventory[n++] = new Item(103, "500 GB Hard Disk", 0, 3, 3500 );
        Item x = inventory[2];
        x.addStock(2);
        try {
            x = inventory[1];
            x.withdrawStock(3);
        }
        catch(Exception e) {
            System.out.println( e.getMessage() );
        }
        
        //List All Items in Inventory
        System.out.println("All Items in Inventory:");
        for ( int i = 0; i < n; i++ ) {
        	x = inventory[i];
            System.out.println("       " + x.getItemCode()
                    +"," + x.getItemDescription()
                    +"," + x.getMinQty()
                    +"," + x.getStock()
                    +"," + x.getCost()
            );
        }

        //List Items under stock
        System.out.println("Items below required Stock:");
        for ( int i = 0; i < n; i++ ) {
        	x = inventory[i];
        	if ( x.isUnderStock() )
            System.out.println("       " + x.getItemCode()
                    +"," + x.getItemDescription()
                    +"," + x.getMinQty()
                    +"," + x.getStock()
                    +"," + x.getCost()
            );
        }
    }
}
