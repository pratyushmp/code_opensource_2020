l = [1, 2, 3, 4, 5, 6, 7, 8, 9] 

# How many elements each 
# list should have 
n = 4

# using list comprehension 
x = [l[i:i + n] for i in range(0, len(l), n)] 
print(x) 
