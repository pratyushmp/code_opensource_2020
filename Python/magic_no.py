'''magic number is defined as a number which can be expressed as a power of 5 
    or sum of unique powers of 5. 
    First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5),....
'''
pow =1
ans=0

n = int(input('Enter nth magic num: '))
temp = n
while(n):
    pow = pow*5
    if n & 1:
        ans+=pow
    n >>= 1

print(temp,'th magic num is: ',ans)
