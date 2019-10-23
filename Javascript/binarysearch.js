const binarySearch = (arr, target) => {
    let startIndex = 0;
    let endIndex = arr.length - 1;
  
    while (startIndex <= endIndex) {
      const middleIndex = startIndex + Math.floor((endIndex - startIndex) / 2);
  
      if (arr[middleIndex] === target) {
        return `Target found at ${middleIndex}th position`;
      }
  
      if (arr[middleIndex] < target) {
        startIndex = middleIndex + 1;
      } else {
        endIndex = middleIndex - 1;
      }
    }
  
    return -1;
  }

console.log(binarySearch([1,2,3,4,5], 5))