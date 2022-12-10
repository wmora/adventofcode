const fs = require('fs');

const data = fs
  .readFileSync('day10input.txt', { encoding: 'utf8', flag: 'r' })
  .split('\n')
  .filter(Boolean);

const INSTRUCTION_CYCLES = {
  noop: 1,
  addx: 2,
};

let registerValue = 1;
let currentCycle = 0;
let nextCycleCheck = 20;
let signalStrength = 0;

data.forEach((line) => {
  const instruction = line.split(' ');

  for (let index = 0; index < INSTRUCTION_CYCLES[instruction[0]]; index++) {
    currentCycle++;

    if (currentCycle === nextCycleCheck) {
      signalStrength += currentCycle * registerValue;
      nextCycleCheck += 40;
    }
  }

  if (instruction[0] === 'addx') {
    registerValue += Number(instruction[1]);
  }
});

console.log(signalStrength);
