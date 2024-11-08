using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace C_
{
    internal class Card
    {
        private static readonly string[] Suits = { "heart", "diamond", "club", "spade" };
        private static readonly string[] Colors = { "red", "black" };
        private static Random random = new Random();
        private int number;
        private string color;
        private string suit;

        public Card()
        {
            this.number = this.GenerateRandomNumber(1, 10);//Get a random number
            this.color = Colors[this.GenerateRandomNumber(0, 2)];//Get a random color from the list
            this.suit = Suits[this.GenerateRandomNumber(0, 4)];//Get a random suit from the list
        }

        //Number lottery function
        private int GenerateRandomNumber(int min, int max)
        {
            return random.Next(min, max);
        }

        //Describe the object
        public override string ToString()
        {
            return $"Card{{ number={number}, color={color}, suit={suit} }}";
        }

        //Draw a card
        public void DrawCard()
        {
            Console.WriteLine("__________\n  " + this.suit + "\n  " + this.number + "\n  " + this.color + "\n__________");
        }

        //Getters 
        public int GetNumber()
        {
            return number;
        }

        public string GetColor()
        {
            return color;
        }

        public string GetSuit()
        {
            return suit;
        }

    }
}
