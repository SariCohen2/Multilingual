#include "Deck.h"
#include <fstream>
#include <cstdlib>

Deck::Deck(int deckSize):deckSize(deckSize),cards(deckSize, nullptr)
{
	for (int i = 0; i < deckSize; i++)
		this->cards[i] =new Card(); //Allocate memory or each card in the vector
}

// Destructor to clean up allocated memory
Deck::~Deck() {
	for (Card* card : cards) {
		delete card;
	}
}

//Returns a string of the object's properties.
string Deck::toString() const
{
	string input ="";
	for (int i = 0; i < this->deckSize; i++)
		input += (*cards[i]).toString() + ", ";
	return input;
}

//Gives a random card and cuts it from the array
Card Deck::getCard()
{

	int randomIndex;
	do {
		randomIndex = rand() % this->deckSize;//Get random index from the length of the array
	} while (cards[randomIndex] == nullptr);
	Card tempCard = *cards[randomIndex];
	delete cards[randomIndex];           // Delete the card from memory
	cards[randomIndex] = nullptr; // Mark the place as empty
	return tempCard;
}



string Deck::fetchRandomSentence() const {
    // Temporary file to store the response
    const string tempFile = "temp_response.txt";

    // Using system to call curl and save the output in a temporary file
    string command = "curl -s http://numbersapi.com/random/trivia -o " + tempFile;
    system(command.c_str());

    // Read the contents of the temporary file
    ifstream file(tempFile);
    string sentence;

    if (file) {
        getline(file, sentence, '\0'); // Read entire file content
        file.close();

       remove(tempFile.c_str());// Delete the temporary file after reading
    }
    else {
        cerr << "Error fetching sentence." << endl;
    }

    cout << " Fun fact: " << sentence << endl;
    return sentence;
}