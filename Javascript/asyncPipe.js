// Pipe implementation for async functions

/*
  Eg. const fn1 = x => Promise.resolve(x + 1);
      const fn2 = x => Promise.resolve(x + 2);
      const fn3 = x => Promise.resolve(x + 3);

      pipe([fn1, fn2, fn3])(5).then(result => console.log('Result:', result));
      // Logs 11 as output
*/

function asyncPipe(functions) {
  return function (input) {
    return functions.reduce(
      (chain, func) => chain.then(func),
      Promise.resolve(input)
    );
  };
}
