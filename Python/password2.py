#python program for password with first letter capital always

import random
def shuffle(string):
  tempList = list(string)
  random.shuffle(tempList)
  return ''.join(tempList)
u1=chr(random.randint(65,90))
u2=chr(random.randint(65,90))
l1=chr(random.randint(97,122))
l2=chr(random.randint(97,122))
n1=chr(random.randint(48,57))
n2=chr(random.randint(48,57))
c1=chr(random.randint(35,38))
c2=chr(random.randint(63,64))
password = u2 + l1 + l2 + n1 + n2 + c1 + c2
password = shuffle(password)
print(u1 + password)