import exception.CategoryNotFoundException;
import helper.InputHelper;

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
            System.out.println("6. Create New Book");
            System.out.println("7. Show All Books");
            System.out.println("8. Delete Book");
            System.out.println("9. Update Book");
            System.out.println("10. Exit");


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

            }
        }
    }
}