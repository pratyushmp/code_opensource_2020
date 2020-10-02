# Problem Link: https://www.hackerrank.com/challenges/py-the-captains-room/problem
# Author: AdityaSingh17

k, arr = int(input()), list(map(int, input().split()))
myset = set(arr)
print(((sum(myset) * k) - (sum(arr))) // (k - 1))
