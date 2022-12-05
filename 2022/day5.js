const fs = require('fs');

const data = fs.readFileSync('day5input.txt', { encoding: 'utf8', flag: 'r' }).split('\n').filter(Boolean);

const stacks = [[], [], [], [], [], [], [], [], []];

let stacksBuilt = false;

data.forEach(line => {
    if (!stacksBuilt) {
        if (line.startsWith(' 1')) {
            stacksBuilt = true;
        } else {
            for (let i = 0; i < stacks.length; i++) {
                const crateIndex = i * 4 + 1;
                const crate = line.charAt(crateIndex).trim();
                if (crate) {
                    stacks[i].push(crate);
                }
            }
        }
    } else {
        const instructions = line.match(/\d+/gi).map(Number);

        const HOW_MANY = instructions[0];
        const FROM = instructions[1] - 1;
        const TO = instructions[2] - 1;

        const cratesMoved = stacks[FROM].splice(0, HOW_MANY).reverse();

        stacks[TO] = cratesMoved.concat(stacks[TO]);
    }
});

console.log(stacks);