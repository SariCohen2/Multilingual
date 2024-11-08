import { Game,askQuestion } from './game.js';
const name=await askQuestion("Please enter your name: ")
const game = new Game(name);//Create a Game instance
const number=await askQuestion("Please enter number of cards: ")
game.startGame(number);

