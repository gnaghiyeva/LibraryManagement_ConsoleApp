package model;

public class Book {
    private int id;
    private String title;
    private String author;
    private double price;
    private Category category;

   public Book(int id, String title, String author, double price, Category category){
       this.id = id;
       this.title = title;
       this.author = author;
       this.price = price;
       this.category = category;

   }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
