using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace C_
{
    internal class Game
    {
        private string playerName;
        private static int totalScore = 0;
        private static int colorScore = 0;
        private static int suitScore = 0;
        private static int numberScore = 0;

        public Game(String playerName)
        {
            this.playerName = playerName;
        }

        //A function that manages the game
        public async Task StartGame(int deckSize)
        {
            Console.WriteLine("Welcome To The Guess Game...");
            Console.WriteLine(this.playerName + " , Please follow the instructions.");
            Deck deck = new Deck(deckSize);
            for (int i = 0; i < deckSize; i++)
            {
                Card card = deck.GetCard();
                this.turn(card.GetColor(), card.GetNumber(), card.GetSuit());
                Console.WriteLine("The real card is:");
                card.DrawCard();
                if (i % 2 == 1)
                {
                    Console.WriteLine("here before");
                   await deck.FetchRandomSentenceAsync();
                    Console.WriteLine("here after");
                }
            }
            Console.WriteLine("Champion!! You finished the game. ");
            Console.WriteLine("________________________");
            Console.WriteLine("Color Score: " + colorScore + "/" + deckSize);
            Console.WriteLine("Suit Score: " + suitScore + "/" + deckSize);
            Console.WriteLine("Number Score: " + numberScore + "/" + deckSize);
            Console.WriteLine("________________________");
            Console.WriteLine("Total Score:" + totalScore + "/" + deckSize * 3);
            Console.WriteLine("________________________");
        }

        //For each turn, it receives the necessary inputs, compares them to the real card, and responds accordingly.
        public void turn(String Ccolor, int Cnumber, String Csuit)
        {
            Console.WriteLine("Guess the color: ");
            String color = Console.ReadLine().ToLower();

            Console.WriteLine("Guess the suit: ");
            String suit = Console.ReadLine().ToLower();

            Console.WriteLine("Guess the number: ");
            int number = int.Parse(Console.ReadLine());

            var results = new Dictionary< string, bool> ();// Create a results map
            results["color"]= Ccolor.Equals(color, StringComparison.OrdinalIgnoreCase);
            results["suit"]= Csuit.Equals(suit,StringComparison.OrdinalIgnoreCase);
            results["number"]= Cnumber == number;

            long correctCount = results.Values.Count(value => value);

            if (correctCount == 3)
            {
                Console.WriteLine("You beat it!! All the guesses are correct");
                totalScore += 3;
                colorScore++;
                Console.WriteLine("color++");
                suitScore++;
                Console.WriteLine("suit++");
                numberScore++;
                Console.WriteLine("number++");
            }
            else if (correctCount == 2)
            {
                string correctItems = string.Join(" and ", results.Where(entry => entry.Value)
                                                  .Select(entry => entry.Key));

                Console.WriteLine("You almost beat it!! " + correctItems + " are correct");
                totalScore += 2;
                if (results["color"])
                {
                    colorScore++;
                }
                if (results["suit"])
                {
                    suitScore++;
                }
                if (results["number"])
                {
                    numberScore++;

                }
            }
            else if (correctCount == 1)
            {
                string correctItem = results.FirstOrDefault(entry => entry.Value).Key ?? "";
                Console.WriteLine("You almost beat it!! " + correctItem + " is correct");
                totalScore += 1;
                if (results["color"])
                {
                    colorScore++;
                }
                if (results["suit"])
                {
                    suitScore++;
                }
                if (results["number"])
                {
                    numberScore++;
                }
            }
            else
            {
                Console.WriteLine("What a loser, everything was wrong.");
            }
        }
    }
}
