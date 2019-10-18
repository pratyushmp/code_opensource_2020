
# Python HCF or GCD function


# First find smaller number among two numbers
# Iterate upto small number using range function and check remainder
# If current num is divisible by both numbers, update the HCF variable

def findHCFOfTwoNumbers(a, b):
    if a > b:
        smaller = b
    else:
        smaller = a
    for i in range(1,smaller + 1):
        if ((a%i == 0) and (b%i==0)):
            hcf = i
    return hcf

num1 = 12
num2 = 18

# If you want to take input from user, uncomment below lines for num1 and num2
# num1 = int(input("Enter first number: "))
# num2 = int(input("Enter second number: "))

print("The H.C.F. of", num1,"and", num2,"is", findHCFOfTwoNumbers(num1, num2))
