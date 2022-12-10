const fs = require('fs');

const getPriority = (letter) => {
  const alphabet = [...'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ'];

  return alphabet.indexOf(letter) + 1;
};

const data = fs
  .readFileSync('day4input.txt', { encoding: 'utf8', flag: 'r' })
  .split('\n')
  .filter(Boolean);

let sum = 0;

const isAssignmentOverlapped = function (firstAssignment, secondAssignment) {
  lowestSectionFirstAssignment = Number(firstAssignment[0]);
  highestSectionFirstAssignment = Number(firstAssignment[1]);

  lowestSectionSecondAssignment = Number(secondAssignment[0]);
  highestSectionSecondAssignment = Number(secondAssignment[1]);

  const isLowestSectionContained =
    lowestSectionFirstAssignment >= lowestSectionSecondAssignment &&
    lowestSectionFirstAssignment <= highestSectionSecondAssignment;

  const isHighestSectionContained =
    highestSectionFirstAssignment >= lowestSectionSecondAssignment &&
    highestSectionFirstAssignment <= highestSectionSecondAssignment;

  return isLowestSectionContained || isHighestSectionContained;
};

data.forEach((line) => {
  const assignments = line.split(',');

  const firstAssignment = assignments[0].split('-');
  const secondAssignment = assignments[1].split('-');

  if (
    isAssignmentOverlapped(firstAssignment, secondAssignment) ||
    isAssignmentOverlapped(secondAssignment, firstAssignment)
  ) {
    sum++;
  }
});

console.log(sum);
