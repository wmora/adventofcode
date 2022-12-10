// Node.js program to demonstrate the
// fs.readFileSync() method

// Include fs module
const fs = require('fs');

// Calling the readFileSync() method
// to read 'input.txt' file
const data = fs
  .readFileSync('day2input.txt', { encoding: 'utf8', flag: 'r' })
  .split('\n')
  .filter(Boolean);

let totalScore = 0;

// Display the file data
data.forEach((round) => {
  const ROCK = 'A';
  const PAPER = 'B';
  const SCISSORS = 'C';

  const shapePoint = {
    [ROCK]: 1,
    [PAPER]: 2,
    [SCISSORS]: 3,
  };

  const opponentChoice = round[0];

  const LOSE = 'X';
  const DRAW = 'Y';
  const WIN = 'Z';

  const outcome = round[2];

  let roundScore = 0;
  let myChoice;

  if (outcome === LOSE) {
    if (opponentChoice === ROCK) {
      myChoice = SCISSORS;
    } else if (opponentChoice === PAPER) {
      myChoice = ROCK;
    } else if (opponentChoice === SCISSORS) {
      myChoice = PAPER;
    }
  } else if (outcome === DRAW) {
    roundScore += 3;

    myChoice = opponentChoice;
  } else if (outcome === WIN) {
    roundScore += 6;

    if (opponentChoice === ROCK) {
      myChoice = PAPER;
    } else if (opponentChoice === PAPER) {
      myChoice = SCISSORS;
    } else if (opponentChoice === SCISSORS) {
      myChoice = ROCK;
    }
  }

  roundScore += shapePoint[myChoice];

  totalScore += roundScore;
});

console.log(totalScore);
