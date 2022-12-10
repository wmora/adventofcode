const fs = require('fs');
const readline = require('readline');

const run = async function () {
  const data = readline.createInterface({
    input: fs.createReadStream('day1input.txt'),
    // output: process.stdout,
    console: false,
  });

  let maxCalories = 0;
  let elfCalories = 0;

  for await (const line of data) {
    if (!line) {
      if (elfCalories > maxCalories) {
        maxCalories = elfCalories;
      }
      elfCalories = 0;
    } else {
      elfCalories += Number(line);
    }
  }

  if (elfCalories > maxCalories) {
    maxCalories = elfCalories;
  }

  console.log(maxCalories);
};

run();
