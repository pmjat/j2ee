package pjava.ch03.book;

public class Book {
    public Book() {
        this(null, null, 0);
    }     
    public Book(String isbn, String title, double price) {
        this.isbn = isbn;
        this.title = title;
        this.price = price;
    }
    public String getIsbn() {
        return this.isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public double getPrice() {
        return this.price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String new_title) {
        this.title = new_title;
    }
    @Override
    public String toString() {
        return "Book{" + "isbn=" + isbn 
                + ", title=" + title 
                + ", price=" + price 
                + '}';
    }
//Field Declarations
    private String isbn;
    private String title;
    private double price;
}