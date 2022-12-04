// Node.js program to demonstrate the 
// fs.readFileSync() method

// Include fs module
const fs = require('fs');

const data = fs.readFileSync('day2input.txt', {encoding:'utf8', flag:'r'}).split('\n').filter(Boolean);

let totalScore = 0;

data.forEach(round => {
    const opponentChoice = round[0];
    const myChoice = round[2];

    const isOpponentRock = opponentChoice === 'A';
    const isOpponentPaper = opponentChoice === 'B';
    const isOpponentScissors = opponentChoice === 'C';

    let roundScore = 0;

    if (myChoice === 'X') {
        roundScore += 1;

        if (isOpponentRock) {
            roundScore += 3;
        } else if (isOpponentScissors) {
            roundScore += 6;
        }
    } else if (myChoice === 'Y') {
        roundScore += 2;

        if (isOpponentPaper) {
            roundScore += 3;
        } else if (isOpponentRock) {
            roundScore += 6
        }
    } else if (myChoice === 'Z') {
        roundScore += 3;

        if (isOpponentScissors) {
            roundScore += 3;
        } else if (isOpponentPaper) {
            roundScore += 6;
        }
    }

    totalScore += roundScore;
});

console.log(totalScore);