const fs = require('fs');

const data = fs
  .readFileSync('day6input.txt', { encoding: 'utf8', flag: 'r' })
  .split('\n')
  .filter(Boolean);

data.forEach((line) => {
  for (let index = 4; index < line.length; index++) {
    const lastFour = new Set(line.substring(index - 4, index));

    if (lastFour.size === 4) {
      console.log(index);
      break;
    }
  }
});
