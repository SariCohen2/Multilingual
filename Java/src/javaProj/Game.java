/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaProj;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author The user
 */
public class Game {

    Scanner in = new Scanner(System.in);

    private String playerName;
    private static int totalScore = 0;
    private static int colorScore = 0;
    private static int suitScore = 0;
    private static int numberScore = 0;

    public Game(String playerName) {
        this.playerName = playerName;
    }

    //A function that manages the game
    public void startGame(int deckSize) {
        System.out.println("Welcome To The Guess Game...");
        System.out.println(this.playerName + " , Please follow the instructions.");
        Deck deck = new Deck(deckSize);
        for (int i = 0; i < deckSize; i++) {
            Card card = deck.getCard();
            this.turn(card.getColor(), card.getNumber(), card.getSuit());
            System.out.println("The real card is:");
            card.drawCard();
            if (i % 2 == 1) {
                deck.fetchRandomSentence();
            }
        }
        System.out.println("Champion!! You finished the game. ");
        System.out.println("________________________");
        System.out.println("Color Score: " + this.colorScore +"/"+ deckSize);
        System.out.println("Suit Score: " + this.suitScore +"/"+ deckSize);
        System.out.println("Number Score: " + this.numberScore +"/"+ deckSize);
        System.out.println("________________________");
        System.out.println("Total Score:" + this.totalScore +"/"+ deckSize * 3);
        System.out.println("________________________");
    }

    //For each turn, it receives the necessary inputs, compares them to the real card, and responds accordingly.
    public void turn(String Ccolor, int Cnumber, String Csuit) {
        System.out.print("Guess the color: ");
        String color = in.nextLine().toLowerCase();

        System.out.print("Guess the suit: ");
        String suit = in.nextLine().toLowerCase();

        System.out.print("Guess the number: ");
        int number = in.nextInt();
        in.nextLine();// To clear the remaining character in the buffer

        Map<String, Boolean> results = new HashMap<>();// Create a results map
        results.put("color", Ccolor.equalsIgnoreCase(color));
        results.put("suit", Csuit.equalsIgnoreCase(suit));
        results.put("number", Cnumber == number);

        long correctCount = results.values().stream().filter(Boolean::booleanValue).count();// Calculate the number of matches

        if (correctCount == 3) {
            System.out.println("You beat it!! All the guesses are correct");
            totalScore += 3;
            colorScore++;
            System.out.println("color++");
            suitScore++;
            System.out.println("suit++");
            numberScore++;
            System.out.println("number++");
        } else if (correctCount == 2) {
            String correctItems = results.entrySet().stream()
                    .filter(Map.Entry::getValue)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.joining(" and "));
            System.out.println("You almost beat it!! " + correctItems + " are correct");
            totalScore += 2;
            if (results.get("color")) {
                colorScore++;
                System.out.println("color++");
            }
            if (results.get("suit")) {
                suitScore++;
                System.out.println("suit++");
            }
            if (results.get("number")) {
                numberScore++;
                            System.out.println("number++");

            }
        } else if (correctCount == 1) {
            String correctItem = results.entrySet().stream()
                    .filter(Map.Entry::getValue)
                    .map(Map.Entry::getKey)
                    .findFirst().orElse("");
            System.out.println("You almost beat it!! " + correctItem + " is correct");
            totalScore += 1;
            if (results.get("color")) {
                colorScore++;
                System.out.println("color++");
            }
            if (results.get("suit")) {
                suitScore++;
                System.out.println("suit++");

            }
            if (results.get("number")) {
                numberScore++;
                            System.out.println("number++");

            }
        } else {
            System.out.println("What a loser, everything was wrong.");
        }
    }

}
