#include "Card.h"
using namespace std;

// definw the consts values
const string Card::SUITS[4] = { "heart", "diamond", "club", "spade" };
const string Card::COLORS[2] = { "red", "black" };

Card::Card() :number(generateRandomNumber(1,10)),//Get a random number
                    suit(SUITS[generateRandomNumber(0,3)]),//Get a random color from the list
                    color(COLORS[generateRandomNumber(0,1)])//Get a random suit from the list
{}

//Number lottery function
int Card::generateRandomNumber(int min, int max)
{
    return (rand()%(max+1))+min;
}

//Describe the object
string Card::toString() const
{
    return "Card: {" + this->color + ", " + this->suit + ", " + to_string(this->number) + "}\n";;
}

//Draw a card
void Card::drawCard() const
{
    cout << "__________\n  " << this->suit << "\n  " << this->number << "\n  " << this->color << "\n__________" << std::endl;
}

//Getters
int Card::getNumber() const
{
    return this->number;
}

string Card::getSuit() const
{
    return this->suit;
}

string Card::getColor() const
{
    return this->color;
}

Card Card::operator=(const Card& card)
{
    return Card();
}