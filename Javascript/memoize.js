// Memoizes result of passed function, based on arguments used while calling the function
// useful when arguments are not frequently changing for a function which does heavy computation
/*
  Eg. function heavyComputation(args) {
    return computedResult;
  }

  const memoizedHeavyComputation = memoize(heavyComputation);

  memoizedHeavyComputation(a, b, c) // performs comutation, returns output using a, b and c arguments
  memoizedHeavyComputation(a, b, c) // does not perform heavy computation (since arguments are same), instead returns already computed result
  memoizedHeavyComputation(x, y, z) // performs comutation, returns output using x, y and z arguments
  memoizedHeavyComputation(a, b, c) // again, does not perform heavy computation (since arguments are same), instead returns already computed result
  memoizedHeavyComputation(x, y, z) // again, does not perform heavy computation (since arguments are same), instead returns already computed result
*/

function memoize(func) {
  let memoizedResult = {};
  const sliceFn = Array.prototype.slice;

  return function () {
    var args = sliceFn.call(arguments);

    if (args in memoizedResult) {
      return memoizedResult[args];
    } else {
      return (memoizedResult[args] = func.apply(this, args));
    }
  };
}
