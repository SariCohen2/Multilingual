#include "Game.h"
#include <iostream>
#include <string>
#include <algorithm>
#include <map>
using namespace std;

Game::Game(string playerName):playerName(playerName),totalScore(0),colorScore(0),suitScore(0),numberScore(0)
{}

//A function that manages the game
void Game::startGame(int deckSize)
{
    cout<<"Welcome To The Guess Game...\n";
    cout << this->playerName << " , Please follow the instructions.\n";
    Deck deck =Deck(deckSize);
    for (int i = 0; i < deckSize; i++) {
        Card card = deck.getCard();
        turn(card.getColor(), card.getNumber(), card.getSuit());
        cout << "The real card is:\n";
        card.drawCard();
        if (i % 2 == 1) {
            deck.fetchRandomSentence();
        }
    }
    cout << "Champion!! You finished the game. \n";
    cout << ("________________________\n");
    cout << "Color Score: " << this->colorScore << "/" << deckSize<<endl;
    cout << "Suit Score: " << this->suitScore <<"/" << deckSize<<endl;
    cout << "Number Score: " << this->numberScore << "/" << deckSize<<endl;
    cout << "________________________\n";
    cout << "Total Score:" <<this->totalScore <<"/" << deckSize * 3<<endl;
    cout << "________________________\n";
}

//For each turn, it receives the necessary inputs, compares them to the real card, and responds accordingly.
void Game::turn(const string& Ccolor, int Cnumber, const string& Csuit) {
    string color, suit;
    int number;
    cin.ignore();  // To clear the remaining character in the buffer
    cout << "Guess the color: ";
    getline(cin, color);
    transform(color.begin(), color.end(), color.begin(), ::tolower);

    cout << "Guess the suit: ";
    getline(cin, suit);
    transform(suit.begin(), suit.end(), suit.begin(), ::tolower);

    cout << "Guess the number: ";
    cin >> number;
    cin.ignore();  // To clear the remaining character in the buffer

    map<string, bool> results;// Create a results map
    results["color"] = (Ccolor == color);
    results["suit"] = (Csuit == suit);
    results["number"] = (Cnumber == number);

    int correctCount = count_if(results.begin(), results.end(),
        [](const auto& pair) { return pair.second; });// Calculate the number of matches

    // Output results based on correct guesses
    if (correctCount == 3) {
        cout << "You beat it!! All the guesses are correct\n";
        totalScore += 3;
        colorScore++;
        suitScore++;
        numberScore++;
    }
    else if (correctCount == 2) {
        string correctItems;
        for (auto it = results.begin(); it != results.end(); ++it) {
            if (it->second) {
                if (!correctItems.empty()) correctItems += " and ";
                correctItems += it->first;
            }
        }
       cout << "You almost beat it!! " << correctItems << " are correct\n";
        totalScore += 2;
        if (results["color"]) {
            colorScore++;
        }
        if (results["suit"]) {
            suitScore++;
        }
        if (results["number"]) {
            numberScore++;
        }
    }
    else if (correctCount == 1) {
        for (auto it = results.begin(); it != results.end(); ++it) {
            if (it->second) {
                cout << "You almost beat it!! " << it->first << " is correct\n";
                break;
            }
        }
            totalScore += 1;
            if (results["color"]) {
                colorScore++;
            }
            if (results["suit"]) {
                suitScore++;
            }
            if (results["number"]) {
                numberScore++;
            }
        }
    else {
        cout << "What a loser, everything was wrong.\n";
    }
    }
