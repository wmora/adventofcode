const fs = require('fs');

const data = fs
  .readFileSync('day10input.txt', { encoding: 'utf8', flag: 'r' })
  .split('\n')
  .filter(Boolean);

const INSTRUCTION_CYCLES = {
  noop: 1,
  addx: 2,
};

let spritePosition = 1;
let currentCycle = 0;
let nextCycleCheck = 40;
let crt = [''];

data.forEach((line) => {
  const instruction = line.split(' ');

  for (let index = 0; index < INSTRUCTION_CYCLES[instruction[0]]; index++) {
    const isPixelLit =
      currentCycle >= spritePosition - 1 && currentCycle <= spritePosition + 1;

    crt[crt.length - 1] += isPixelLit ? '#' : '.';

    currentCycle++;

    if (currentCycle === nextCycleCheck) {
      currentCycle = 0;
      crt.push('');
    }
  }

  if (instruction[0] === 'addx') {
    spritePosition += Number(instruction[1]);
  }
});

console.log(crt);
