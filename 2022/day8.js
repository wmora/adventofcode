const fs = require('fs');

const data = fs.readFileSync('day8input.txt', { encoding: 'utf8', flag: 'r' }).split('\n').filter(Boolean);

const map = [];

data.forEach(line => {
    map.push(line.split('').map(char => parseInt(char)));
});

let visibleTrees = map[0].length * 2 + map.length * 2 - 4;

for (let i = 1; i < map.length - 1; i++) {
    const row = map[i];

    for (let j = 1; j < row.length - 1; j++) {
        const treeHeight = row[j];
        if (row.slice(0, j).findIndex(height => height >= treeHeight) < 0) {
            visibleTrees++;
        } else if (row.slice(j + 1).findIndex(height => height >= treeHeight) < 0) {
            visibleTrees++;
        } else {
            const column = map.map(row => row[j]);

            if (column.slice(0, i).findIndex(height => height >= treeHeight) < 0) {
                visibleTrees++;
            } else if (column.slice(i + 1).findIndex(height => height >= treeHeight) < 0) {
                visibleTrees++;
            }   
        }
    }
}

console.log(visibleTrees);