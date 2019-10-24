'''Changing the matrix according to the sorted 2nd column.
    Eg. in this matrix, 2nd column is: 3,6,1,1,5
    After sorting: 1,1,3,5,6
    Now matrix changes accordingly
'''

l=[[0,3,5,9],
    [2,6,5,9],
    [1,1,4,2],
    [5,1,2,3],
    [7,5,2,8]]

c=5
s=[]
for i in range(c):
    s.append(l[i][1])
s.sort()


j=0
i=0
f=0
while i<c:
    if l[i][1] == s[j]:
        l[i],l[j]=l[j],l[i]
        j+=1
        i=j
    else:
        i+=1

for i in l:
    print(i)