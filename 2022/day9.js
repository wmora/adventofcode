const fs = require('fs');

const data = fs.readFileSync('day9input.txt', { encoding: 'utf8', flag: 'r' }).split('\n').filter(Boolean);

const positionsTravelled = new Set();

const headPosition = [0, 0];
const tailPosition = [0, 0];

const moveTailPosition = () => {
    if (headPosition === tailPosition) {
        return;
    }

    if (Math.abs(headPosition[0] - tailPosition[0]) <= 1 && Math.abs(headPosition[1] - tailPosition[1]) <= 1) {
        return;
    }

    if (Math.abs(headPosition[0] - tailPosition[0]) >= 1 && Math.abs(headPosition[1] - tailPosition[1]) >= 1) {
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

data.forEach(line => {
    const DIRECTION = line.charAt(0);
    const DISTANCE = parseInt(line.slice(2));

    for (let index = 0; index < DISTANCE; index++) {
        
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

        moveTailPosition();

        positionsTravelled.add(tailPosition.join(','));
    }
});

console.log(positionsTravelled.size);