const fs = require('fs');

const data = fs.readFileSync('day6input.txt', { encoding: 'utf8', flag: 'r' }).split('\n').filter(Boolean);

let startOfMessageMarker = -1;

data.forEach(line => {
    for (let index = 14; index < line.length; index++) {
        const lastFourteen = [...new Set(line.substring(index - 14, index).split(''))].join('');

        if (lastFourteen.length === 14 && lastFourteen.indexOf(line.charAt(index)) < 0) {
            startOfMessageMarker = index;
            console.log(startOfMessageMarker);
            break;
        }
    }
});