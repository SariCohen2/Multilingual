import { Card } from "./card.js";
class Deck {

    constructor(deckSize) {
        this.deckSize = deckSize;
        this.cards = [];
        for (let i = 0; i < deckSize; i++) {//Creating cards in a pack as the number received
            this.cards[i] = new Card();
        }
    }

    //Returns a string of the object's properties.
    toString() {
        let output = "";
        for (let i = 0; i < this.deckSize; i++) {
            output += this.cards[i].toString() + "\n";
        }
        return output;
    }

    //Gives a random card and cuts it from the array
    getCard() {
        let randomIndex = Math.floor(Math.random() * this.cards.length);
        let card = this.cards[randomIndex];
        this.cards.splice(randomIndex, 1);
        return card;
    }
}
//A function that returns an interesting fact about numbers
async function fetchRandomSentence() {
    try {
        const response = await fetch('http://numbersapi.com/random/trivia');
        const fact = await response.text();  // Get the text from the response
        console.log(fact);
        return fact;
    } catch (error) {
        console.error("Error fetching data:", error);
    }
}
export { Deck, fetchRandomSentence };