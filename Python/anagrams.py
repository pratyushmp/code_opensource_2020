#Program to check if 2 strings are anagram of each other

s1='listen'
s2='silent'

count1 = [0]*256
count2 = [0]*256

for i in s1:
    count1[ord(i)] += 1

for i in s2:
    count2[ord(i)] += 1

if count1 == count2:
    print('yes')
else:
    print('no')
