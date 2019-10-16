#!/bin/python3

import sys


t = int(input().strip())
n = list()
for a0 in range(t):
    n.append(int(input().strip()))

res = 0

for i in range(t):
    n3 = (n[i]-1)//3
    n5 = (n[i]-1)//5
    n15 = (n[i]-1)//15
    res = ((n3/2)*(3 + (3*n3))) + ((n5/2)*(5 + (5*n5))) - ((n15/2)*(15 + (15*n15)))
    print("%d" % res)
