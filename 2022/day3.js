const fs = require('fs');

const getPriority = letter => {
    const alphabet = [...'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ'];

    return alphabet.indexOf(letter) + 1;
}

const rucksacks = fs.readFileSync('day3input.txt', {encoding:'utf8', flag:'r'}).split('\n').filter(Boolean);

let sum = 0;

rucksacks.forEach(rucksack => {
    const half = Math.floor(rucksack.length / 2);
    const firstCompartment = rucksack.substring(0, half);
    const secondCompartment = rucksack.substring(half);

    const sharedItem = firstCompartment.split('').find(letter => secondCompartment.indexOf(letter) > -1);

    sum += getPriority(sharedItem);
});

console.log(sum);