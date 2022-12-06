const fs = require('fs');

const data = fs.readFileSync('day6input.txt', { encoding: 'utf8', flag: 'r' }).split('\n').filter(Boolean);

let startOfPacketMarker = -1;

data.forEach(line => {
    for (let index = 4; index < line.length; index++) {
        const lastFour = [...new Set(line.substring(index - 4, index).split(''))].join('');

        if (lastFour.length === 4) {
            startOfPacketMarker = index;
            console.log(startOfPacketMarker);
            break;
        }
    }
});