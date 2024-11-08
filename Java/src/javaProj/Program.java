/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaProj;

import java.util.Scanner;

/**
 *
 * @author The user
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your name please:");
        String name = in.nextLine();
        Game game = new Game(name);
        System.out.println("Enter the number of cards you want to play.:");
        int deckSize = in.nextInt();
        game.startGame(deckSize);
    }

}
