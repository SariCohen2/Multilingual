/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaProj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import sun.net.www.http.HttpClient;

/**
 *
 * @author The user
 */
public class Deck {

    private int deckSize;
    private Card cards[];

    public Deck(int deckSize) {
        this.deckSize = deckSize;
        this.cards = new Card[deckSize];
        for (int i = 0; i < deckSize; i++)//Creating cards in a pack as the number received
        {
            this.cards[i] = new Card();
        }
    }

    //Returns a string of the object's properties.
    public String toString() {
        String input = "";
        for (Card c : this.cards) {
            input += c.toString() + "\n";
        }
        return input;
    }

    //Gives a random card and cuts it from the array
    public Card getCard() {
        int randomIndex;
        do {
            randomIndex = (int) (Math.random() * (this.cards.length )) ;//Get random index from the length of the array
        } while (this.cards[randomIndex] == null);
        Card tempCard = this.cards[randomIndex];
        this.cards[randomIndex] = null;
        return tempCard;
    }

    //A function that returns an interesting fact about numbers
    public String fetchRandomSentence() {
        String sentence = "";
        try {
            String url = "http://numbersapi.com/random/trivia";
            URL obj = new URL(url);// Create URL object
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");// Set the request method as GET
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));// Reading the response from the API
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close(); // Close the connection
            sentence = content.toString();// Put the content into a String variable
            System.out.println("💡Fun fact:" + sentence);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sentence;
    }

}
