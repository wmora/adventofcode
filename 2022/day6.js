const fs = require('fs');

const data = fs.readFileSync('day6input.txt', { encoding: 'utf8', flag: 'r' }).split('\n').filter(Boolean);

let startOfPacketMarker = -1;

data.forEach(line => {
    for (let index = 3; index < line.length; index++) {
        const lastThree = [...new Set(line.substring(index - 3, index).split(''))].join('');

        if (lastThree.length === 3 && lastThree.indexOf(line.charAt(index)) < 0) {
            startOfPacketMarker = index + 1;
            break;
        }
    }
});

console.log(startOfPacketMarker);