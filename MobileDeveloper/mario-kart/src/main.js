import { Character } from './character.js';
import { RaceEngine } from './raceEngine.js';

const mario = new Character('Mario', 4, 3, 3);
const luigi = new Character('Luigi', 3, 4, 4);
const peach = new Character('Peach', 3, 4, 2);
const yoshi = new Character('Yoshi', 2, 4, 3);
const donkeyKong = new Character('Donkey Kong', 2, 2, 5);
const bowser = new Character('Bowser', 5, 2, 5);

const player1 = mario; // Select player 1
const player2 = luigi; // Select player 2

for (let i = 0; i < 5; i++) {
    console.log(`Round ${i + 1}!`);
    RaceEngine.startRace(player1, player2);
    console.log(`Score: ${player1.score} | ${player2.score}`);
    console.log('-----------------------------------');
}

console.log(`Final Score: ${player1.name} : ${player1.score}, ${player2.name} : ${player2.score}`);
if (player1.score > player2.score) {
    console.log(`${player1.name} wins!`);
} else if (player2.score > player1.score) {
    console.log(`${player2.name} wins!`);
} else {
    console.log("It's a tie!");
}
