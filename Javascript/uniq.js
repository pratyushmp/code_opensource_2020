// Returns filtered array with unique elements in a given array

/*
  Eg. const arr = [1, 2, 1, 2];

  uniq(arr) // Result: [1, 2]

*/

function uniq(arrInput) {
  return arrInput.filter((item, i, ar) => ar.indexOf(item) === i)
}