// Program is based on Input: nums = [3,1,4,1,5], k = 2
// Output: 2
// Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
// Although we have two 1s in the input, we should only return the number of unique pairs.
var findPairs = function (nums, k) {
  if (k < 0) return 0;
  nums = k === 0 ? nums : Array.from(new Set(nums));
  let m = new Map(),
    res = 0;
  for (let num of nums) {
    if (m.get(num + k) === 1) res++;
    console.log(res, num, k);
    if (num + k !== num - k && m.get(num - k) === 1) res++;
    m.set(num, m.get(num) + 1 || 1);
  }
  return res;
};

console.log(findPairs([1, 2, 3, 4, 5, 6], 3));
