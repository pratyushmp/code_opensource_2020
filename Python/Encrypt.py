##
##  Encryption
##

import random


def phi(n, coPrimeNumbers, p, q):   # Calculating the coprime numbers for given list.
    for i in range(2, n):
        if any([i % p == 0, i % q == 0, not is_prime(i)]):
            coPrimeNumbers.remove(i)

    return coPrimeNumbers


def chooseencryptionkey(e, coPrimeNumbersPQ):   # Choose encryption key with the bounds 1<e<phi(N)
    ran = random.randrange(1, len(coPrimeNumbersPQ))
    e = coPrimeNumbersPQ[ran]
    return e


def is_prime(n):    # Calculating if a given number is prime
    if n == 2 or n == 3: return True
    if n < 2 or n % 2 == 0: return False
    if n < 9: return True
    if n % 3 == 0: return False
    r = int(n ** 0.5)

    # since all primes > 3 are of the form 6n ± 1
    # start with f=5 (which is prime)
    # and test f, f+2 for being prime
    # then loop by 6.

    f = 5
    while f <= r:
        if n % f == 0: return False
        if n % (f + 2) == 0: return False
        f += 6
    return True


def encryptmessage(message, en, n):     # Encrypt given message using public key and set N, (Open lock without key)
    re = message ** en % n

    return re
