import java.util.Random;

public class Main {
    public static void main(String[] args){
        Random rdm = new Random();

        Double num = Math.pow(2, 4);
        int max = num.intValue();

        int number = rdm.nextInt(max) + 1;

        int guesses = Guess.guessOption(1, max);
        
        if(guesses == 1){
            System.out.println("It took 1 attempt to guess the number");
        }else
            System.out.printf("It took %d attempts to guess the number", guesses);
    }
}
