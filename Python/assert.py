# Program to demostrate assert statement

x = int(input("Enter a number greater than 0:"))

assert x>=0,"Enter a positive number"

print("The number is positive")

# The program will throw an AssertionError if the user enters a value less than 0