export class RaceEngine {
    static startRace(player1, player2) {
        let block = RaceEngine.#generateRandomBlock();

        if (block === 'straight') {
            console.log(`A straight block is generated! ${player1.name} and ${player2.name} are speeding up!`);
            console.log(`${player1.name}'s Speed:  ${player1.speed}\n${player2.name}'s Speed: ${player2.speed}`);
            if (player1.speed > player2.speed) {
                player1.score += 1;
                console.log(`${player1.name} wins this round!`);
            } else if (player2.speed > player1.speed) {
                player2.score += 1;
                console.log(`${player2.name} wins this round!`);
            } else {
                console.log("It's a tie in this round!");
            }

        } else if (block === 'curve') {
            console.log(`A curve block is generated! ${player1.name} and ${player2.name} need to handle their vehicles carefully!`);
            console.log(`${player1.name}'s Handling:  ${player1.handling}\n${player2.name}'s Handling: ${player2.handling}`);
            if (player1.handling > player2.handling) {
                player1.score += 1;
                console.log(`${player1.name} navigates the curve better and wins this round!`);
            } else if (player2.handling > player1.handling) {
                player2.score += 1;
                console.log(`${player2.name} navigates the curve better and wins this round!`);
            } else {
                console.log("Both players handled the curve equally well, it's a tie!");
            }

        } else if (block === 'confrontation') {
            console.log(`A confrontation block is generated! ${player1.name} and ${player2.name} are facing off!`);
            console.log(`${player1.name}'s Power:  ${player1.power}\n${player2.name}'s Power: ${player2.power}`);
            if (player1.power > player2.power) {
                player2.score -= 1;
                player2.score = Math.max(player2.score, 0); // Ensure score doesn't go negative
                console.log(`${player1.name} overpowers ${player2.name} and wins this round!`);
            } else if (player2.power > player1.power) {
                player1.score -= 1;
                player1.score = Math.max(player1.score, 0); // Ensure score doesn't go negative
                console.log(`${player2.name} overpowers ${player1.name} and wins this round!`);
            } else {
                console.log("Both players are equally powerful, no score change this round!");
            }
        }


    }

    static #generateRandomBlock(){
        const randomNumber = Math.random();
        let block;

        if (randomNumber < 0.33)
            block = 'straight';
        else if (randomNumber < 0.66)
            block = 'curve';
        else
            block = 'confrontation';
        
        return block;
    }
}