/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaProj;

/**
 *
 * @author The user
 */
public class Card {

    private static String[] suits = {"heart", "diamond", "club", "spade"};
    private static String[] colors = {"red", "black"};
    private int number;
    private String color;
    private String suit;

    public Card() {
        this.number = this.getRandomNumber(1, 10);//Get a random number
        this.color = colors[this.getRandomNumber(0, 2)];//Get a random color from the list
        this.suit = suits[this.getRandomNumber(0, 4)];//Get a random suit from the list
    }

    //Number lottery function
    private int getRandomNumber(int min, int max) {
        return (int) (Math.random() * max) + min;
    }

    //Describe the object
    @Override
    public String toString() {
        return "Card{" + "number=" + number + ", color=" + color + ", suit=" + suit + '}';
    }

    //Draw a card
    public void drawCard() {
        System.out.println("__________\n  " + this.suit + "\n  " + this.number + "\n  " + this.color + "\n__________");
    }

    //Getters 
    public int getNumber() {
        return number;
    }

    public String getColor() {
        return color;
    }

    public String getSuit() {
        return suit;
    }

}
