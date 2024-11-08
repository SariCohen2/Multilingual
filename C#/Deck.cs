using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace C_
{
    internal class Deck
    {
        private int deckSize;
        private Card [] cards;

        public Deck(int deckSize)
        {
            this.deckSize = deckSize;
            this.cards = new Card[deckSize];
            for (int i = 0; i < deckSize; i++)//Creating cards in a pack as the number received
            {
                this.cards[i] = new Card();
            }
        }

        //Returns a string of the object's properties.
        public override string ToString()
        {
            String input = "";
            foreach (Card c in this.cards)
            {
                input += c.ToString() + "\n";
            }
            return input;
        }

        //Gives a random card and cuts it from the array
        public Card GetCard()
        {
            Random random = new Random();
            int randomIndex;
            do
            {
                randomIndex = random.Next(this.cards.Length);//Get random index from the length of the array
            } while (this.cards[randomIndex] == null);
            Card tempCard = this.cards[randomIndex];
            this.cards[randomIndex] = null;
            return tempCard;
        }

        //A function that returns an interesting fact about numbers
        private static readonly HttpClient client = new HttpClient();
        public async Task<string> FetchRandomSentenceAsync()
        {
            string sentence = string.Empty;
            try
            {
                string url = "http://numbersapi.com/random/trivia";
                HttpResponseMessage response = await client.GetAsync(url);
                response.EnsureSuccessStatusCode(); // Check if the request succeeded

                sentence = await response.Content.ReadAsStringAsync(); // Read the string conyent
                Console.WriteLine("💡Fun fact: " + sentence);
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }
            return sentence;
        }
    }
}
