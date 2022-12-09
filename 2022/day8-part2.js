const fs = require('fs');

const data = fs.readFileSync('day8input.txt', { encoding: 'utf8', flag: 'r' }).split('\n').filter(Boolean);

const map = [];

data.forEach(line => {
    map.push(line.split('').map(char => parseInt(char)));
});

let highestScenicScore = 0;

for (let i = 0; i < map.length; i++) {
    const row = map[i];

    for (let j = 0; j < row.length; j++) {
        const treeHeight = row[j];
        
        let leftFirstBlockingTreeIndex = row.slice(0, j).reverse().findIndex(height => height >= treeHeight) + 1;

        if (leftFirstBlockingTreeIndex === 0) {
            leftFirstBlockingTreeIndex = j;
        }

        const rightRow = row.slice(j + 1);
        let rightFirstBlockingTreeIndex = rightRow.findIndex(height => height >= treeHeight) + 1;

        if (rightFirstBlockingTreeIndex === 0) {
            rightFirstBlockingTreeIndex = rightRow.length;
        }

        const column = map.map(row => row[j]);

        let topFirstBlockingTreeIndex = column.slice(0, i).reverse().findIndex(height => height >= treeHeight) + 1;

        if (topFirstBlockingTreeIndex === 0) {
            topFirstBlockingTreeIndex = i;
        }

        const bottomColumn = column.slice(i + 1);

        let bottomFirstBlockingTreeIndex = bottomColumn.findIndex(height => height >= treeHeight) + 1;

        if (bottomFirstBlockingTreeIndex === 0) {
            bottomFirstBlockingTreeIndex = bottomColumn.length;
        }

        const scenicScore = leftFirstBlockingTreeIndex * rightFirstBlockingTreeIndex * topFirstBlockingTreeIndex * bottomFirstBlockingTreeIndex;

        if (scenicScore > highestScenicScore) {
            highestScenicScore = scenicScore;
        }
    }
}

console.log(highestScenicScore);