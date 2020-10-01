#simple code to receive input of a number and tells you if it is a prime number or not
number = int(input('Enter a number: '))
num_list = range(2, number - 1)
def prime_num(input):
    for x in num_list:
        if number % x == 0:
            print("not prime")
            break
        else:
            print('prime')
prime_num(number)
