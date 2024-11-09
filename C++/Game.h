#pragma once
#include <string>
#include "Deck.h"

using namespace std;

class Game
{
private:
    string playerName="";
    int totalScore = 0;
    int colorScore = 0;
    int suitScore = 0;
    int numberScore = 0;

public:
    Game(string playerName);
    void startGame(int deckSize);
    void turn(const string& Ccolor, int Cnumber, const string& Csuit);
};

