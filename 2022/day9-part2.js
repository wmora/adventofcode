const fs = require('fs');

const data = fs
  .readFileSync('day9input.txt', { encoding: 'utf8', flag: 'r' })
  .split('\n')
  .filter(Boolean);

const positionsTravelled = new Set();

const NUMBER_OF_KNOTS = 10;

const knots = [];

for (let index = 0; index < NUMBER_OF_KNOTS; index++) {
  knots.push([0, 0]);
}

const moveTailPosition = (headPosition, tailPosition) => {
  if (headPosition === tailPosition) {
    return;
  }

  if (
    Math.abs(headPosition[0] - tailPosition[0]) <= 1 &&
    Math.abs(headPosition[1] - tailPosition[1]) <= 1
  ) {
    return;
  }

  if (
    Math.abs(headPosition[0] - tailPosition[0]) >= 1 &&
    Math.abs(headPosition[1] - tailPosition[1]) >= 1
  ) {
    if (headPosition[0] < tailPosition[0]) {
      tailPosition[0]--;
    } else {
      tailPosition[0]++;
    }

    if (headPosition[1] < tailPosition[1]) {
      tailPosition[1]--;
    } else {
      tailPosition[1]++;
    }
  } else if (Math.abs(headPosition[1] - tailPosition[1]) > 1) {
    if (headPosition[1] < tailPosition[1]) {
      tailPosition[1]--;
    } else {
      tailPosition[1]++;
    }
  } else if (Math.abs(headPosition[0] - tailPosition[0]) > 1) {
    if (headPosition[0] < tailPosition[0]) {
      tailPosition[0]--;
    } else {
      tailPosition[0]++;
    }
  }
};

data.forEach((line) => {
  const DIRECTION = line.charAt(0);
  const DISTANCE = parseInt(line.slice(2));

  for (let index = 0; index < DISTANCE; index++) {
    const headPosition = knots[0];

    switch (DIRECTION) {
      case 'U':
        headPosition[1]++;
        break;
      case 'D':
        headPosition[1]--;
        break;
      case 'R':
        headPosition[0]++;
        break;
      case 'L':
        headPosition[0]--;
        break;
    }

    for (let index = 1; index < knots.length; index++) {
      moveTailPosition(knots[index - 1], knots[index]);
    }

    positionsTravelled.add(knots[knots.length - 1].join(','));
  }
});

console.log(positionsTravelled.size);
