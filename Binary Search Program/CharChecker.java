import java.util.Scanner;

public class CharChecker {

        public static char charCheck(){
            Scanner kbInput = new Scanner(System.in);
            char option = kbInput.nextLine().toLowerCase().charAt(0);
            if (option != 'y' && option != 'n'){
                System.out.println("You must use either y or n");
                return charCheck();
            }else
                return option;
        }
}