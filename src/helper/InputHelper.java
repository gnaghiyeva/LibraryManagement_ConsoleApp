package helper;

import java.util.Scanner;

public class InputHelper {
    private static final Scanner scanner = new Scanner(System.in);

    public static String readLine(String prompt){
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static int readInt(String prompt){
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a number");
            scanner.next();
        }
        int velue = scanner.nextInt();
        scanner.nextLine();
        return velue;
    }
}
