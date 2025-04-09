import exception.BookNotFoundException;
import exception.CategoryNotFoundException;
import helper.InputHelper;
import model.Category;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LibraryManager libraryManager = new LibraryManager();
//        libraryManager.createCategory("Fiction");
//        libraryManager.createCategory("Animal");

        boolean running = true;
        while (running){
            System.out.println("Library Management System");
            System.out.println("1. Add Category");
            System.out.println("2. List Categories");
            System.out.println("3. Delete Category");
            System.out.println("4. Update Category");
            System.out.println("5. Create New Book");
            System.out.println("6. Show All Books");
            System.out.println("7. Delete Book");
            System.out.println("8. Update Book");
            System.out.println("9. Exit");


            int choice = InputHelper.readInt("Choice: ");
            switch(choice){
                case 1:
                    String categoryName = InputHelper.readLine("Category Name: ");
                    libraryManager.createCategory(categoryName);
                    break;

                case 2:
                    System.out.println("Category List: ");
                    libraryManager.allCategories();
                    break;
                case 3:
                    System.out.println("Which category do you want to delete?");
                    while (true){
                        int categoryID = InputHelper.readInt("Category ID: ");
                        try {
                            libraryManager.deleteCategory(categoryID);
                            break;
                        }catch (CategoryNotFoundException e){
                            System.out.println("Category not found write right id");
                        }

                    }
                    break;

                case 4:
                    System.out.println("Which category do you want to update?");
                    while (true){
                        int updatedCategoryID = InputHelper.readInt("Category ID: ");
                        try{
                            String newCategoryName = InputHelper.readLine("New Category Name: ");
                            libraryManager.updateCategory(updatedCategoryID,newCategoryName);
                            break;
                        }catch (CategoryNotFoundException e){
                            System.out.println("Category not found write right id");
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
                    System.out.println("Which book do you want to delete?");
                    while (true){
                        int bookID = InputHelper.readInt("Book ID: ");
                        try {
                            libraryManager.deleteBook(bookID);
                            break;
                        }catch (BookNotFoundException e){
                            System.out.println("Book not found write right id");
                        }

                    }
                    break;

                case 8:
                    System.out.println("Which book do you want to update?");
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