//Check if all the digits of given integer are even
/* 
example:
input :24862
output:true
input:642386
output:false
*/

function evenDigitsOnly(number) {
  const digits = number.toString().split("");

  return digits.every((digit) => parseInt(digit % 2) === 0);
}

const nums = 248632;
evenDigitsOnly(nums);
