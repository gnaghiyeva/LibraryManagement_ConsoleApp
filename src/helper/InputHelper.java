package helper;

import java.util.Scanner;

public class InputHelper {
    private static final Scanner scanner = new Scanner(System.in);

    public static String readLine(String propmpt){
        System.out.print(propmpt);
        return scanner.nextLine();
    }

    public static int readInt(String propmpt){
        System.out.println(propmpt);
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a number");
            scanner.next();
        }
        int velue = scanner.nextInt();
        scanner.nextLine();
        return velue;
    }
}
