// Uziel Gaeta
// CS1400
// Assignment 5
// 4/5/2021

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> handOfcards = new ArrayList<Card>(1);

    public Hand(){
        handOfcards.clear();
    }

    public void addCard(Card inputCard){
        handOfcards.add(inputCard);
    }

    public int calculateHandValue(){
        int totalValue = 0;

        for (int i = 0; i < handOfcards.size(); i++) {
            totalValue += handOfcards.get(i).getValue();
        }

        return totalValue;
    }

    public void showCard(int i){
        System.out.println(handOfcards.get(i).getFace() + " of "
                        + handOfcards.get(i).getSuit());

    }

    public void showCard(){
        for (int i = 0; i < handOfcards.size(); i++) {
            if(i == handOfcards.size() - 1)
                System.out.println(handOfcards.get(i).getFace()
                        + " of " + handOfcards.get(i).getSuit()
                        + " **");
            else            
                System.out.println(handOfcards.get(i).getFace()
                        + " of " + handOfcards.get(i).getSuit());
        }
    }

    public void aceCheck(){
        
        for (int i = 0; i < handOfcards.size(); i++) {
            
            if(handOfcards.get(i).getFace().equals("Ace")){
                handOfcards.get(i).aceSetValue();
                break;
            }

        }
    }

}
