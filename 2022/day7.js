const fs = require('fs');

const data = fs.readFileSync('day7input.txt', { encoding: 'utf8', flag: 'r' }).split('\n').filter(Boolean);

const isCommand = (line) => line.startsWith('$ ');
const isCdCommand = (command) => command.startsWith('$ cd ');

class Node {
    constructor(name, parent, size, isDirectory = false) {
        this.name = name;
        this.parent = parent;
        this.isDirectory = isDirectory;
        this.size = size;
        this.children = [];
    }

    addChild(child) {
        this.children.push(child);
    }

    setParent(parent) {
        this.parent = parent;
    }

    getName() {
        return this.name;
    }

    getParent() {
        return this.parent;
    }

    getChildren() {
        return this.children;
    }

    toString() {
        return this.name;
    }
    
    reverseTraverse(callback) {
        this.children.forEach(child => child.reverseTraverse(callback));
        callback(this);
    }
}

let node;

data.forEach(line => {
    if (isCommand(line)) {
        if (isCdCommand(line)) {
            const destination = line.substring(5);
            
            if (!node) {
                node = new Node(destination, undefined, 0, true);
            } else if (destination === '..') {
                node = node.getParent();
            } else {
                const child = new Node(destination, node, 0, true);
                node.addChild(child);
                node = child;
            }
        }
    } else if (!line.startsWith('dir')) {
        const size = parseInt(line.substring(0, line.indexOf(' ')));
        const name = line.substring(line.indexOf(' ') + 1);
        const child = new Node(name, node, size);
        node.addChild(child);
    }
});

while (node.getParent()) {
    node = node.getParent();
}

let sum = 0;

node.reverseTraverse(node => {
    if (node.isDirectory) {
        node.getChildren().forEach(child => {
            node.size += child.size;
        });

        if (node.size <= 100000) {
            sum += node.size;
        }
    }
});

console.log(sum);
