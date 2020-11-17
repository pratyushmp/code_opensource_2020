word = input("enter word: ")
word = word.casefold()
reverse_word = reversed(word)
if list(word) == list(reverse_word):
   print("The string is a palindrome.")
else:
   print("The string is not a palindrome.")
