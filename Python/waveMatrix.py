'''program to print elements from matrix in a wave like form.
    Like:
        |  ||||  ||||
        |  |  |  |  |
        |  |  |  |  |
        ||||  ||||  |
'''

l=[[1,2,3,4],
    [5,6,7,8],
    [9,10,11,12],
    [13,14,15,16],
    [17,18,19,20]]

M=4
N=5
i=0
while i<M:
    if i%2==0:
        for row in range(0,N):
            print(l[row][i], end=' ')
    else:
        for row in range(N-1,-1,-1):
            print(l[row][i], end=' ')
    i+=1