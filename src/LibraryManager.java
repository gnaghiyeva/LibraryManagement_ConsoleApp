import exception.BookNotFoundException;
import exception.CategoryNotFoundException;
import model.Book;
import model.Category;

import java.util.ArrayList;
import java.util.List;

import static helper.Colors.TEXT_RED;

public class LibraryManager {
    private final List<Book> books = new ArrayList<>();
    private final List<Category> categories = new ArrayList<>();
    private int bookIdCounter = 1;
    private int categoryIdCounter = 1;

    public void createCategory(String name){
        categories.add(new Category(categoryIdCounter++, name));
    }

    public void allCategories(){
        for(Category c : categories){
            System.out.println(c.getId()+". "+c.getCategoryName());
        }
    }
    public List<Category> getAllCategories(){
        return categories;
    }

    public Category getCategoryById(int id){
        for (Category category: categories){
            if(category.getId() == id){
                return category;
            }
        }
        return null;
    }

    public void deleteCategory(int id) throws CategoryNotFoundException {
        Category category = getCategoryById(id);
        if(category == null){
           throw new CategoryNotFoundException("Category not found");
        }
        categories.remove(category);
        System.out.println("Deleted Category: " + category.getCategoryName());
    }

    public void updateCategory(int id, String newName) throws CategoryNotFoundException {
        Category category = getCategoryById(id);
        if(category == null){
            throw new CategoryNotFoundException("Category not found");
        }
        category.setCategoryName(newName);
        System.out.println("Updated Category: " + category.getCategoryName());
    }

//    ***********************  BOOK SECTION  ***********************

    public void addBook(String title, String author, double price, int categoryId){
        Category category = getCategoryById(categoryId);
        if(category == null){
            throw new IllegalArgumentException("Category not found");
        }
        books.add(new Book(bookIdCounter++,title,author,price,category));
    }

    public void allBook(){
        for(Book b : books){
            System.out.println(b.getId()+ ". " +b.getTitle()+"-"+b.getPrice()+" - "+b.getCategory().getCategoryName());
        }
    }

    public Book getBookById(int id){
        for (Book book: books){
            if(book.getId() == id){
                return book;
            }
        }
        return null;
    }

    public void deleteBook(int id) throws BookNotFoundException {
        Book book = getBookById(id);
        if(book == null){
            throw new BookNotFoundException("Book not found");
        }
        books.remove(getBookById(id));
        System.out.println("Deleted Book: " + book.getTitle());
    }

    public void updateBook(int id, String title, String author, double price, int categoryId) throws BookNotFoundException {
        Book book = getBookById(id);
        Category category = getCategoryById(categoryId);
        if(book == null){
            throw new BookNotFoundException("Book not found");
        }
        book.setTitle(title);
        book.setAuthor(author);
        book.setPrice(price);
        book.setCategory(category);
    }

    public void searchBook(String keyword){
        boolean found = false;
        for(Book b : books){
            if(b.getTitle().toLowerCase().contains(keyword.toLowerCase())){
                System.out.println(b.getId()+ ". " +b.getTitle());
                found = true;
            }

        }
        if(!found){
            System.out.println(TEXT_RED+ "No book found"+TEXT_RED);
        }
    }
}
