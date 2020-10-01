def is_prime(n):
    if n == 2:
        return True
    if n < 2:
        return False
    for i in range(2, int(n**0.5)+1):
        if n % i == 0:
            return False
    return True

try:
    number = int(input("Pleae enter the number: "))
    print("Yes!" if is_prime(number) else "No!")
except:
    print("Enter a valid number!")

