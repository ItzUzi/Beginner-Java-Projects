// Uziel Gaeta
// CS1400
// Assignment 5
// 4/5/2021

public class Card {
    
    private String face;
    private String suit;
    private int value;

    public Card(String face, String suit, int value){
        this.face = face;
        this.suit = suit;
        this.value = value;
    }

    public void aceSetValue(){
        this.value = 1;
        this.face += " ";
    }

    public String getFace(){
        return face;
    }

    public String getSuit(){
        return suit;
    }

    public int getValue(){
        return value;
    }

}
