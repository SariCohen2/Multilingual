import readline from 'readline';
import { Deck,fetchRandomSentence } from "./deck.js";


//Create interface for an input from user
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

// A function for get input from user
function askQuestion(question) {
    return new Promise((resolve) => {
        rl.question(question, (answer) => {
            resolve(answer);
        });
    });
}
 
class Game {
    constructor(playerName) {
        this.playerName = playerName;
        this.totalScore = 0;
        this.colorScore = 0;
        this.suitScore = 0;
        this.numberScore = 0;
    }
    //A function that manages the game
 async startGame(deckSize) {
    console.log("Welcome To The Guess Game...");
    console.log(`${this.playerName}, Please follow the instructions.`);
    let deck = new Deck(deckSize);
    for (let i = 0; i < deck.deckSize; i++) {
        let card = deck.getCard();
        await this.turn(card.color, card.number, card.suit);
        console.log('The real card is:');
        card.drawCard();
        if (i % 2 == 1)
            await fetchRandomSentence();
    }
    console.log('Champion!! You finished the game. Your score is:');
    console.log('________________________');
    console.log(`Color Score: ${this.colorScore}/${deck.deckSize}`);
    console.log(`Suit Score: ${this.suitScore}/${deck.deckSize}`);
    console.log(`Number Score: ${this.numberScore}/${deck.deckSize}`);
    console.log('________________________');
    console.log(`Total Score: ${this.totalScore}/${deck.deckSize * 3}`);
    console.log('________________________');

}

//For each turn, it receives the necessary inputs, compares them to the real card, and responds accordingly.
async turn(Ccolor, Cnumber, Csuit) {
    var color = await askQuestion('Guess the color: ');
    color=color.toLowerCase();
    var suit = await askQuestion('Guess the suit: ');
    suit=suit.toLowerCase();
    var number = await askQuestion('Guess the number: ');
    // Create an object that contains the results
    const results = {
        color: Ccolor === color,
        suit: Csuit === suit,
        number: Cnumber === number
    };
    const correctCount = Object.values(results).filter(Boolean).length;

    if (correctCount === 3) {
        console.log('You beat it!! All the guesses are correct');
        this.totalScore += 3;
        this.colorScore++;
        this.suitScore++;
        this.numberScore++;
    } else if (correctCount === 2) {
        console.log(`You almost beat it!! ${Object.keys(results).filter(key => results[key]).join(' and ')} are correct`);
        this.totalScore += 2;
        if (results.color) this.colorScore++;
        if (results.suit) this.suitScore++;
        if (results.number) this.numberScore++;
    } else if (correctCount === 1) {
        console.log(`You almost beat it!! ${Object.keys(results).find(key => results[key])} is correct`);
        this.totalScore += 1;
        if (results.color) this.colorScore++;
        if (results.suit) this.suitScore++;
        if (results.number) this.numberScore++;
    } else {
        console.log('What a loser, everything was wrong.');
    }
}
}
export { Game,askQuestion };
