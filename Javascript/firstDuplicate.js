/*
Problem:First duplicate number for which the second occurrence
has smaller index than second occurence of other number does,
if no such element does return -1

Input:array
outpur:if duplicate number found return number else return -1
examples:
input:[2,1,3,5,3,2]
result:3
input:[2,3,4,5,1]
result:-1
*/

function firstDuplicate(nums) {
  const firstDup = {};
  //iterate the nums
  for (let num of nums) {
    //check for duplicate values
    if (firstDup.hasOwnProperty(num)) {
      //return duplicated num
      return num;
    }
    firstDup[num] = num;
  }
  //dont find return -1
  return -1;
}

const nums = [2, 1, 3, 5, 3, 2];
firstDuplicate(nums);
