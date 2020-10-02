"""
This is a simple hidden number game.
Here we have assigned a number to a variable from 1 to 100 (in this case 25).
We are asking the user to guess that number in 5 chances.
If the user guesses within 5 chances he will win otherwise he will lose the game.

If you want to make this game more fun you can generate the hidden number using
random.randint(a, b) as shown:
import random

hidden_num = random.randint(1, 100)
"""


hidden_num = 25        # Variable to store hidden number
num_of_guess = 4       # Variable to track number of guesses left
num_of_guess_took = 0  # Variable to track number of guesses user took

print('Welcome to guess the hidden number game')
print('But remember you have only 5 total guesses\n')
print('Guess the hidden number between 1 to 100 : ', end='')
num = int(input())
print(f'You have {num_of_guess} guesses left')

while True:

    if num_of_guess == 0 and num != hidden_num:
        print('\nYou lost!!!!! Game Over')
        break

    elif num == hidden_num:
        print(f'\nWell done you guessed in {num_of_guess_took + 1} chances \nYou won')
        break


    else:
        if num > hidden_num:
            print('\nThink a lesser number : ', end='')
            num = int(input())
            num_of_guess -= 1
            num_of_guess_took += 1
            print(f'You have {num_of_guess} guesses left')
            continue

        else:
            print('\nThink a greater number : ', end='')
            num = int(input())
            num_of_guess -= 1
            num_of_guess_took += 1
            print(f'You have {num_of_guess} guesses left')
            continue
