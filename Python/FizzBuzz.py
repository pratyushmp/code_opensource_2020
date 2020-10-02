# Famous FizzBuzz algorithm
for i in range(1, 101):
	line = ""
	if i % 3 == 0:
		line += "Fizz"
	if i % 5 == 0:
		line += "Buzz"
	print([line, i][line == ""])
