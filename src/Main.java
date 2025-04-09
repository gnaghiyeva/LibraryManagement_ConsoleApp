import exception.BookNotFoundException;
import exception.CategoryNotFoundException;
import helper.InputHelper;
import model.Category;

import static helper.Colors.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LibraryManager libraryManager = new LibraryManager();
//        libraryManager.createCategory("Fiction");
//        libraryManager.createCategory("Animal");

        boolean running = true;
        while (running){
            System.out.println(TEXT_RED+" L I B R A R Y     M A N A G E M E N T     S Y S T E M "+TEXT_WHITE);
            System.out.println(TEXT_PURPLE+ "1. Add Category");
            System.out.println(TEXT_CYAN + "2. List Categories");
            System.out.println(TEXT_YELLOW +"3. Delete Category");
            System.out.println(TEXT_BRIGHT_CYAN + "4. Update Category");
            System.out.println(TEXT_GREEN + "5. Create New Book");
            System.out.println(TEXT_BLUE + "6. Show All Books");
            System.out.println(TEXT_BRIGHT_PURPLE + "7. Delete Book");
            System.out.println(TEXT_BRIGHT_YELLOW + "8. Update Book");
            System.out.println(TEXT_BRIGHT_GREEN+ "9. Exit");


            int choice = InputHelper.readInt(TEXT_RESET+ "Choice: " + TEXT_RESET);
            switch(choice){
                case 1:
                    String categoryName = InputHelper.readLine("Enter the category Name: ");
                    libraryManager.createCategory(categoryName);
                    break;

                case 2:
                    System.out.println(TEXT_BRIGHT_BLUE + "Category List: " + TEXT_RESET);
                    libraryManager.allCategories();
                    break;

                case 3:
                    System.out.print(TEXT_RED + "Which category do you want to delete?" + TEXT_RED);
                    if(libraryManager.getAllCategories().isEmpty()){
                        System.out.println("No categories found");
                        break;
                    }
                    while (true){
                        int categoryID = InputHelper.readInt("Category ID: ");
                        try {
                            libraryManager.deleteCategory(categoryID);
                            break;
                        }catch (CategoryNotFoundException e){
                            System.out.println(TEXT_BRIGHT_RED + "Category not found write right id" + TEXT_BRIGHT_RED);
                        }

                    }
                    break;

                case 4:
                    System.out.print(TEXT_YELLOW + "Which category do you want to update?" + TEXT_YELLOW);
                    if (libraryManager.getAllCategories().isEmpty()) {
                        System.out.println("No categories found");
                        break;
                    }
                    while (true){
                        int updatedCategoryID = InputHelper.readInt("Category ID: ");
                        try{
                            String newCategoryName = InputHelper.readLine("New Category Name: ");
                            libraryManager.updateCategory(updatedCategoryID,newCategoryName);
                            break;
                        }catch (CategoryNotFoundException e){
                            System.out.println(TEXT_BRIGHT_YELLOW + "Category not found write right id" + TEXT_BRIGHT_YELLOW);
                        }

                    }
                    break;

                case 5:
                    String bookName = InputHelper.readLine("Book Name: ");
                    String author = InputHelper.readLine("Author: ");
                    int price = InputHelper.readInt("Price: ");

                    int categoryId;

                    while (true){
                       categoryId = InputHelper.readInt("Category ID: ");

                       if (libraryManager.getCategoryById(categoryId) == null){
                           System.out.println("Category not found write right id");
                       }
                       else {
                           break;
                       }
                    }
                    libraryManager.addBook(bookName,author,price, categoryId);
                    break;

                case 6:
                    System.out.println("All Books: ");
                    libraryManager.allBook();
                    break;

                case 7:
                    System.out.println(TEXT_RED+"Which book do you want to delete?"+TEXT_RED);
                    while (true){
                        int bookID = InputHelper.readInt("Book ID: ");
                        try {
                            libraryManager.deleteBook(bookID);
                            break;
                        }catch (BookNotFoundException e){
                            System.out.println(TEXT_BRIGHT_RED+"Book not found write right id"+TEXT_BRIGHT_RED);
                        }

                    }
                    break;

                case 8:
                    System.out.println(TEXT_YELLOW+"Which book do you want to update?"+TEXT_YELLOW);
                    while(true){
                        int updatedBookID = InputHelper.readInt("Book ID: ");

                        try {
                            String updatedBookName = InputHelper.readLine("New Book Name: ");
                            String updatedAuthor = InputHelper.readLine("New Author: ");
                            int updatedPrice = InputHelper.readInt("New Price: ");
                            int updatedCategoryID = InputHelper.readInt("Category ID: ");

                            libraryManager.updateBook(updatedBookID,updatedBookName,updatedAuthor,updatedPrice,updatedCategoryID);
                            break;
                        }catch (BookNotFoundException e){
                            System.out.println("Book not found write right id");
                        }
                    }
                    break;
            }
        }
    }
}