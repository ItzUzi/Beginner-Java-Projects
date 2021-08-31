// Uziel Gaeta
// CS1400
// Assignment 5
// 4/5/2021

import java.util.Scanner;

public class Game {
    public static void main(String[] args){
        Scanner kbInput = new Scanner(System.in);
        String option = "";
        double playerWin = 0.0;
        double totalGames = 0.0;
        int handCounter;
        int counter;
        String hand = "Your hand is: \n";

        System.out.println("\t**********************************" + "\n"
                        + "\t  WELCOME TO THE BLACK JACK TABLE" + "\n" +
                         "\t**********************************" + "\n" + 
                         "\n" + "Rules: Dealer stands on soft 17!" + "\n" + 
                         "       Dealer wins on ties!");

        do {
            counter = 0;
            handCounter = 0;
            totalGames++;

            Hand player = new Hand();

            Deck cardDeck = new Deck();
            cardDeck.shuffle();

            System.out.println(hand);
            player.addCard(cardDeck.drawCard(counter++));
            player.showCard(handCounter++);
            player.addCard(cardDeck.drawCard(counter++));
            player.showCard(handCounter++);
        
            if(player.calculateHandValue() > 21)
                player.aceCheck();

            if (player.calculateHandValue() == 21) {
                System.out.println("\nBlackJack!");
                playerWin++;
                option = playAgain();
                if(option.equals("playagain"))
                    continue;
                else
                    break;
            }

            while (!option.equals("stand")) {
                System.out.println("(You now have " + player.calculateHandValue() + ")");

                System.out.println("Hit or stand");

                option = kbInput.nextLine().toLowerCase();

                if (option.equals("hit")) {
                    player.addCard(cardDeck.drawCard(counter++));
                    System.out.println("\n\n" + hand);
                    player.showCard();
                }

                if(player.calculateHandValue() > 21){
                    player.aceCheck();
                    if(player.calculateHandValue() > 21){
                        System.out.println("(You have: " + player.calculateHandValue() + ")");
                        System.out.println("\n" + "Bust!");
                        break;
                    }
                }
                
            }

            if(player.calculateHandValue() > 21){
                option = playAgain();
                if(option.equals("playagain")){
                    System.out.println();
                    continue;
                }
                else
                    break;
            }
            else{
                System.out.println("\n\nDealer's turn");
                Hand dealer = new Hand();

                handCounter = 0;
                dealer.addCard(cardDeck.drawCard(counter++));
                dealer.showCard(handCounter++);
                dealer.addCard(cardDeck.drawCard(counter++));
                dealer.showCard(handCounter++);

                System.out.println("(Dealer has: " + dealer.calculateHandValue() + ")" + "\n");

                while(dealer.calculateHandValue() <= 17){
            
                    dealer.addCard(cardDeck.drawCard(counter++));
                    dealer.showCard();
                    System.out.println("(Dealer has: " + dealer.calculateHandValue() + ")" + "\n");
                }
        
        
                if(dealer.calculateHandValue() > 21){
                    System.out.println("Dealer Bust!");
                    System.out.println("You Win!");
                    playerWin++;
                }else if(dealer.calculateHandValue() < player.calculateHandValue()){
                    System.out.println("You have " + player.calculateHandValue());
                    System.out.println("You Win!");
                    playerWin++;
                }else{
                    System.out.println("You have " + player.calculateHandValue());
                    System.out.println("Dealer won!");
                }
            }
        
            option = playAgain();
            if(option.equals("playagain"))
                continue;

        }while(!option.equals("exit"));

        double winPercentage = (playerWin/totalGames) * 100;
        System.out.printf("\nYou won %.2f%% of the time", winPercentage);
    }

    private static String playAgain(){
        System.out.println("Please enter 'PlayAgain' or exit");
        Scanner kbInput = new Scanner(System.in);
        String option = kbInput.nextLine().toLowerCase();

        while(!option.equals("playagain") && !option.equals("exit")){
            System.out.println("Please enter either 'playagain' or 'exit'.");
            option = kbInput.nextLine().toLowerCase();
        }
        System.out.println();

        return option;
    }
}
