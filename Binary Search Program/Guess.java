import java.util.Scanner;

public class Guess {

    private static Scanner kbInput = new Scanner(System.in);

    public static int guessOption(int number, int max){
        System.out.printf("The number is between %d and %d\n", 0, max);
        System.out.println("Would you like the binary search to find the number? (Y/N)");

        char option = CharChecker.charCheck();

        if(option == 'y'){
            System.out.printf("The number is %d.\n" , number);
            return binarySearch(number, 0, max);
        }else
            return guess(number);
    }

    private static int binarySearch(int number, int min, int max){
        
        int guess = (max + min + 1)>>1;
        
        System.out.printf("The guess is %d.\n", guess);

        if(guess < number)
            min = guess;

        if(guess > number)
            max = guess;

        if(guess == number)
            return 1;
        else 
            return 1 + binarySearch(number, min, max);
        
    }
    
    private static int guess(int number){
        int guess = kbInput.nextInt();

        if(guess > number)
            System.out.println("Your guess is too high!");

        if(guess < number)
            System.out.println("Your guess is too low!");

        if (guess == number)
            return 1;
        else
            return 1 + guess(number);
    }
}
