n=int(input("Enter the size of the pattern : "))
shape=int(input("Enter 1 for start pattern and enter 0 for reverse star pattern : "))
if(shape):
    for i in range(1,n+1):
        for j in range(i):
            print("*",end=" ")
        print("\n")
else:
    for i in range(n,0,-1):
        for j in range(i):
            print("*",end=" ")
        print()
