import random
print("Hi! what is your name?")
name=input()
secretno=random.randint(1,20)   #randint generates random number [gives random number between 1 and 20 including 1n20]
print('DEBUG secret number is '+ str(secretno))
print("well " + name, "this is a Guessing number Game")
print(name+" I am thinking of number between 1 to 20")

for guessTaken in range(1,7):
    print("Guess a number!")
    guess=int(input())
    if guess<secretno:
        print("Your guess is too low")
    elif guess>secretno:
        print("Your guess is too high!")
    else:
        break

if guess == secretno:
    print("you guessed it correctly! in total " + str(guessTaken) + " no of guesses")
else:
    print("NO. the number i was thinking was " +str(secretno))
        




