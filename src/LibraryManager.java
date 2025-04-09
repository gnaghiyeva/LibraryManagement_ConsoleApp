import exception.CategoryNotFoundException;
import model.Book;
import model.Category;

import java.util.ArrayList;
import java.util.List;

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
}
