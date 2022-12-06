const fs = require('fs');

const data = fs.readFileSync('day6input.txt', { encoding: 'utf8', flag: 'r' }).split('\n').filter(Boolean);

let startOfMessageMarker = -1;

data.forEach(line => {
    for (let index = 13; index < line.length; index++) {
        const lastThirteen = [...new Set(line.substring(index - 13, index).split(''))].join('');

        if (lastThirteen.length === 13 && lastThirteen.indexOf(line.charAt(index)) < 0) {
            startOfMessageMarker = index + 1;
            break;
        }
    }
});

console.log(startOfMessageMarker);