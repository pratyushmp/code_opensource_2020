'''Input a list having negative and positive integers.
    Output: Arranging them in increasing order(excluding negative impact).
    Eg: Input: -8,-5,-3,-1,3,6,9
    Output: -1, -3, 3, -5, 6, -8, 9
    Excluding negation, list is 1,3,3,5,6,8,9. So list will be accordingly.
'''

l=[-8,-5,-3,-1,3,6,9]

n=[]
p=[]
for i in l:
    if i<0:
        n.append(i)
    else:
        p.append(i)

n.reverse()
print(n)
print(p)
i=0
j=0
f=[]
while(i< len(n) or j < len(p)):
    if (i<len(n) and j < len(p)):
        if abs(n[i]) < p[j]:
            f.append(n[i])
            i+=1
        elif abs(n[i])>p[j]:
            f.append(p[j])
            j+=1
        else:
            f.append(n[i])
            f.append(p[j])
            i+=1
            j+=1
    elif i < len(n):
        f.append(n[i])
        i +=1
    else:
        f.append(p[j])
        j +=1


print(f)