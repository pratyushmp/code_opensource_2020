// Custom implementation of Array.prototype.map function JS
/*
  Eg. const arr = [1, 2, 3];

  function incrementByTwo(x) {
    return x + 2;
  }

  const newArr = customMap(arr, incrementByTwo) // result: [3, 4, 5]
*/

function customMap(arr, iterator) {
  const resultArray = [];

  for (let index = 0; index < arr.length; index++) {
    resultArray.push(iterator(arr[index], index, this));
  }
  
  return resultArray;
}