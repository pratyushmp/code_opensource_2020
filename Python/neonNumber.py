# Python program to check and print 
# Neon Numbers upto 10000 

# function to check Neon Number 
def checkNeon (x) : 
	# storing the square of x 
	sq = x * x 
	
	# calculating the sum of sum of digits 
	# of sq 
	sum_digits = 0
	while (sq != 0) : 
		sum_digits = sum_digits + sq % 10
		sq = sq / 10
	
	return (sum_digits == x) 

# Driver Code 

i = 1
# Printing Neon Numbers upto 10000 
while i <= 10000 : 
	if (checkNeon(i)) : 
		print i, 
	i = i + 1

