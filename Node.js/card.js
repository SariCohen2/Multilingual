class Card {
    static SUITS = ['heart', 'diamond', 'club', 'spade'];
    static COLORS = ['red', 'black'];
    constructor() {
        this.number = this.generateRandomNumber(0, 9);//Get a random number
        this.suit = Card.SUITS[this.generateRandomNumber(0, 3)];//Get a random suit from the list
        this.color = Card.COLORS[this.generateRandomNumber(0, 1)];//Get a random color from the list
    }
    //Number lottery function
    generateRandomNumber(min, max) {
        return Math.floor(Math.random() * (max - min + 1)) + min;
    }

    //Describe the object
    toString() {
        return `Card [number:${this.number}, suit:${this.suit}, color:${this.color}]`;
    }
    //Draw a card
    drawCard() {
        console.log(`______\n   ${this.suit}\n   ${this.number}\n   ${this.color}   \n______`);
    }
}
export { Card }
