#pragma once

#include "Card.h"
#include <vector>
using namespace std;

class Deck
{
private:
	int deckSize;
	vector<Card*> cards;

public:
	Deck(int deckSize);
	~Deck();
	string toString() const;
	Card getCard();
	string fetchRandomSentence() const;
};

