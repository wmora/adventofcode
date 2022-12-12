const fs = require('fs');

const data = fs
  .readFileSync('day11input.txt', { encoding: 'utf8', flag: 'r' })
  .split('\n')
  .filter(Boolean);

let monkeys = {};
let currentMonkey;

data.forEach((line) => {
  if (line.match(/^Monkey/)) {
    currentMonkey = Number(line.match(/\d+/)[0]);
    if (!monkeys[currentMonkey]) {
      monkeys[currentMonkey] = {
        items: [],
        operation: [],
        testValue: false,
        monkeyIfTrue: '',
        monkeyIfFalse: '',
        inspections: 0,
      };
    }
  } else if (line.match(/Starting items/)) {
    monkeys[currentMonkey].items = line
      .match(/\d+/g)
      .map((value) => Number(value));
  } else if (line.match(/Operation/)) {
    monkeys[currentMonkey].operation = line
      .match(/(\+|\*)|(old|\d+)/g)
      .splice(1);
  } else if (line.match(/Test/)) {
    monkeys[currentMonkey].testValue = Number(line.match(/\d+/g)[0]);
  } else if (line.match(/true/)) {
    monkeys[currentMonkey].monkeyIfTrue = line.match(/\d+/)[0];
  } else if (line.match(/false/)) {
    monkeys[currentMonkey].monkeyIfFalse = line.match(/\d+/)[0];
  }
});

const leastCommonDenominator = Object.entries(monkeys)
  .map((monkey) => monkey[1].testValue)
  .reduce((a, b) => a * b, 1);

for (let rounds = 0; rounds < 10000; rounds++) {
  for (const [, monkey] of Object.entries(monkeys)) {
    while (monkey.items.length > 0) {
      let worryLevel = monkey.items.shift();
      const worryLevelChange =
        monkey.operation[1] === 'old'
          ? worryLevel
          : Number(monkey.operation[1]);

      if (monkey.operation[0] === '+') {
        worryLevel = worryLevel + worryLevelChange;
      } else if (monkey.operation[0] === '*') {
        worryLevel = worryLevel * worryLevelChange;
      }

      worryLevel = worryLevel % leastCommonDenominator;

      const testPassed = worryLevel % monkey.testValue === 0;
      const destinationMonkey = testPassed
        ? monkey.monkeyIfTrue
        : monkey.monkeyIfFalse;

      monkeys[destinationMonkey].items.push(worryLevel);
      monkey.inspections++;
    }
  }
}

const mostActive = Object.entries(monkeys)
  .sort(([, a], [, b]) => b.inspections - a.inspections)
  .slice(0, 2);

console.log(mostActive[0][1].inspections * mostActive[1][1].inspections);
