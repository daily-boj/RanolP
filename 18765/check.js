const fs = require('fs');
const path = require('path');

const data = fs.readFileSync(path.join(__dirname, 'solution.txt')).toString().split('\n');

let validLines = [];
let tooLongForHard = [];
let failures = 0;

let rangeStart = null;

const printRange = (index) => {
  if (rangeStart.index >= index) {
    return;
  }
  console.log(
    '\x1B[1m\x1B[30m',
    rangeStart.success
      ? '\x1B[42m Success \x1B[0m'
      : '\x1B[41m Failure \x1B[0m',
    rangeStart.index != index - 1
      ? `${rangeStart.index.padStart(4)} ~ ${(index - 1 + '').padStart(4)} -- ${(index - rangeStart.index + '').padStart(4)} elements`
      : (index - 1 + '').padStart(4),
  );
}

for (const [index, line] of Object.entries(data)) {
  let success = eval(line) == index;
  if (success) {
    if (line.length > 200) {
      success = false;
      console.log(` \x1B[1m\x1B[30m\x1B[43m Failure \x1B[0m Line ${+index + 1} (number ${index}) is too long -- ${line.length - 75} chars over`);
    } if (line.length > 75) {
      tooLongForHard.push(index);
    }
    validLines.push(line);
  }
  if (rangeStart) {
    if (rangeStart.success == success) {
      continue;
    }
    printRange(index);
  }
  rangeStart = { index, success };
}

printRange(1001);

if (tooLongForHard.length > 0) {
  console.log();
  console.log(` \x1B[1m\x1B[30m\x1B[43m Warning \x1B[0m ${tooLongForHard.length} lines listed below are too long to pass hard (\x1B[33m${(tooLongForHard.length / 1001 * 100).toFixed(2)}%\x1B[0m left)`);
  let toPrint = '   ';
  for (const [index, value] of Object.entries(tooLongForHard)) {
    if (index % 14 == 0) {
      console.log(toPrint);
      toPrint = '   ';
    }
    toPrint += '\x1B[3' + (index % 3 + 2) + 'm' + value.padStart(4) + '\x1B[0m';
  }
  if (toPrint.length > 0) {
    console.log(toPrint);
  }
  console.log();
}

console.log();
console.log(' \x1B[1m\x1B[30m\x1B[45m Summary \x1B[0m');
console.log(`  \x1B[32m${validLines.length}\x1B[0m lines are valid but \x1B[31m${1001 - validLines.length}\x1B[0m invalid (\x1B[33m${(validLines.length / 1001 * 100).toFixed(2)}%\x1B[0m done)`);
console.log();

const columnsSum =
  validLines
    .map(line => line.length)
    .reduce((l, r) => l + r);
const averageColumns = columnsSum / validLines.length;
const [best, author] = [46.7, 'sait2000'];
const lengthOptimization = best / averageColumns * 100 - 100;

console.log(
  `  Average columns are \x1B[33m${averageColumns.toFixed(1)}\x1B[0m characters per line`);
console.log(
  `  (best ${
  best
  } (by ${author}), currently ${
  lengthOptimization > 0
    ? '\x1B[34m\uf062 '
    : '\x1B[31m\uf063 '
  }${
  Math.abs(lengthOptimization).toFixed(2)
  }%\x1B[0m ${
  lengthOptimization > 0
    ? 'better'
    : 'worse'
  })`);