const readline = require('readline');

/**
 * Create generator from readline.
 * @return {AsyncGenerator<string, string, []>}
 */
async function* rlGenerator() {
  const inputBuffer = [];

  let resolve;
  let promise = new Promise((r) => {
    resolve = r;
  });
  let close = false;

  readline
    .createInterface({ input: process.stdin })
    .on('line', (line) => {
      inputBuffer.push(line);
      resolve();
    })
    .on('close', () => {
      close = true;
      resolve();
    });

  while (true) {
    await promise;
    if (close) {
      return '\0';
    }
    yield inputBuffer.shift();
    if (inputBuffer.length === 0) {
      promise = new Promise((r) => {
        resolve = r;
      });
    }
  }
}

const c = {
  input: rlGenerator(),
  outputBuffer: '',
  print(msg, { end = '\n' } = {}) {
    c.outputBuffer += msg + end;
  },
  exit() {
    process.stdout.write(c.outputBuffer);
    process.exit(0);
  },
};

(async () => {
  const { value: text } = await c.input.next();
  c.print(Number(text).toString(9));
})().then(c.exit);