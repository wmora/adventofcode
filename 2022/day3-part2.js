const fs = require('fs');

const getPriority = (letter) => {
  const alphabet = [...'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ'];

  return alphabet.indexOf(letter) + 1;
};

const rucksacks = fs
  .readFileSync('day3input.txt', { encoding: 'utf8', flag: 'r' })
  .split('\n')
  .filter(Boolean);

let sum = 0;

let firstRucksack;
let secondRucksack;
let thirdRucksack;

rucksacks.forEach((rucksack) => {
  if (!firstRucksack) {
    firstRucksack = rucksack;
  } else if (!secondRucksack) {
    secondRucksack = rucksack;
  } else if (!thirdRucksack) {
    thirdRucksack = rucksack;

    const sharedItem = firstRucksack.split('').find((letter) => {
      return (
        secondRucksack.indexOf(letter) > -1 &&
        thirdRucksack.indexOf(letter) > -1
      );
    });

    sum += getPriority(sharedItem);

    firstRucksack = undefined;
    secondRucksack = undefined;
    thirdRucksack = undefined;
  }
});

console.log(sum);
