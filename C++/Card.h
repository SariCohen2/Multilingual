#pragma once
#include <iostream>
#include <string>

using namespace std;
class Card
{
    private:
        static const string SUITS[4];
        static const string COLORS[2];
        int number=0;
        string color;
        string suit;

        int generateRandomNumber(int min, int max);

    public:
        Card();
        string toString() const;
        void drawCard() const;
        int getNumber() const;
        string getColor() const;
        string getSuit() const;
        Card operator=(const Card& card);

};
