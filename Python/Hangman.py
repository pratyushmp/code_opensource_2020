import random


a = ['LETTER', 'HOPE', "FAITH", "AMERICA", 'toothbrush', 'slab', 'rickshaw', 'nothing', 'gift', 'knuckle',
     'bury', 'treason', 'cloudy', 'lubricate', 'empathic', 'withdrawal', 'session', 'guaranteeing', 'russia']

a = [i.upper() for i in a]


b = random.choice(a)

chances = 0
s = []
k = []
for i in range(len(b)):
    print('- ', end='')
print(end='\n')


def display_hangman(tries):
    stages = [
        """
                   --------
                   |      |
                   |      
                   |    
                   |      
                   |     
                   -
                """,

        """
                   --------
                   |      |
                   |      O
                   |    
                   |      
                   |     
                   -
                """,


        """
                   --------
                   |      |
                   |      O
                   |      |
                   |      |
                   |     
                   -
                """,



        """
                   --------
                   |      |
                   |      O
                   |     \\|
                   |      |
                   |     
                   -
                """,


        """
                   --------
                   |      |
                   |      O
                   |     \\|/
                   |      |
                   |      
                   -
                """,


        """
                   --------
                   |      |
                   |      O
                   |     \\|/
                   |      |
                   |     / 
                   -
                """,

        """
                   --------
                   |      |
                   |      O
                   |     \\|/
                   |      |
                   |     / \\
                   -
                """]

    return stages[tries]


while True:
    print(display_hangman(chances))

    l = input('      Enter a letter ').upper()

    s.append(l)
    if l not in b:
        chances += 1
        pic = display_hangman(chances)
        print(pic)

        for i in range(len(b)):
            if b[i] in s:
                print(b[i], end='')
                c = b.count(b[i])
                if k.count(b[i]) < c:
                    k.append(b[i])

            else:
                print('- ', end='')

    else:
        pic = display_hangman(chances)
        print(pic)
        for i in range(len(b)):
            if b[i] in s:
                print(b[i], end='')
                c = b.count(b[i])
                if k.count(b[i]) < c:
                    k.append(b[i])

            else:
                print('- ', end='')

    if chances == 6:
        print(display_hangman(6))
        print('YOU WERE HUNG ')
        print(f'The correct answer is {b.upper()}')
        break

    if len(k) == len(b):
        print('\n')
        print('YOU WIN ')
        break
