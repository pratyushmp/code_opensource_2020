import re
import sys

from math import ceil, sqrt


def is_prime(n: int) -> bool:
    """Returns True iff n is prime."""
    if n == 2:
        return True
    elif n < 2 or n % 2 == 0:
        return False
    
    limit = ceil(sqrt(n))
    
    for factor in range(3, limit + 1, 2):
        if n % factor == 0:
            return False
    
    return True


def main():
    while True:
        num = input('Enter a number (or q to quit): ')
        if num.lower() in ['q', 'quit']:
            print('Bye!')
            sys.exit(0)
        if not re.match(r'^[-]?\d+$', num):
            print(f"'{num}' is not a valid number")
            sys.exit(1)
        
        primeness = is_prime(int(num))
        print(f"{num} is {'' if primeness else 'NOT '} prime")


if __name__ == '__main__':
    main()
