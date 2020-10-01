// Implements pipe function
/*
  Eg. const fn1 = x => x + 1;
      const fn2 = x => x + 2;
      const fn3 = x => x + 3;

pipe([fn1, fn2, fn3])(5) // Result: 11
*/

function pipe(functionList) {
  return function (input) {
    return functionList.reduce((result, func) => {
      result = func(result);
      return result;
    }, input);
  };
}
