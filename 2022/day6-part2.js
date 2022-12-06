const fs = require('fs');

const data = fs.readFileSync('day6input.txt', { encoding: 'utf8', flag: 'r' }).split('\n').filter(Boolean);

data.forEach(line => {
    for (let index = 14; index < line.length; index++) {
        const lastFourteen = new Set(line.substring(index - 14, index));

        if (lastFourteen.size === 14) {
            console.log(index);
            break;
        }
    }
});