sentence = input("Enter String: ")
words = sentence.split(" ")

#+------------+
# This program takes in a string, and checks to see how many steps it would take to make the string a palindrome,
# As well as finding the longest possible string with the given string
#+------------+


#if even number, split half
#if odd number split half+1
counter = 0
not_allowed = False
largest_palindrome = []
largest_palindrome_str = ""

for word in words:
    counter = 0
    sum_second = 0
    sum_first = 0

    half_word_len = int(len(word)/2)
    #if length even
    if len(word)%2==0:
        first_half = list(word[:half_word_len])
        second_half = list(word[half_word_len:])
        unmod_second_half = second_half
        

        for num in first_half:
            sum_first += ord(num)

        for num in second_half:
            sum_second += ord(num)

        if sum_first <= sum_second:
            for x, letter in enumerate(second_half):
                while second_half[x] != first_half[-(x+1)]:
                    second_half[x] = chr(ord(second_half[x]) - 1)
                    counter += 1

        elif sum_first > sum_second:
            first_half = list(word[half_word_len:])
            second_half = list(word[:half_word_len])
            for x, letter in enumerate(second_half):
                while second_half[x] != first_half[-(x+1)]:
                    second_half[x] = chr(ord(second_half[x]) - 1)
                    counter += 1
                else:
                    not_allowed = True

        else:
            pass

        if counter == 0:
            largest_palindrome = first_half + second_half
            for num in largest_palindrome:
                largest_palindrome_str += num

        else:
            rev_first_half = []
            for x, i in enumerate(word):
                rev_first_half.append(word[-(x+1)])
            rev_first_half.pop(0)
            largest_palindrome = [lett for lett in word] + rev_first_half
            for num in largest_palindrome:
                largest_palindrome_str += num
            
        print(counter, end = " ")
        largest_palindrome_str += " "
    
    #length odd
    else:
        first_half = list(word[:half_word_len+1])
        second_half = list(word[half_word_len:])
        unmod_second_half = second_half

        for num in first_half:
            sum_first += ord(num)

        for num in second_half:
            sum_second += ord(num)

        if sum_first <= sum_second:
            for x, letter in enumerate(second_half):
                while second_half[x] != first_half[-(x+1)]:
                    second_half[x] = chr(ord(second_half[x]) - 1)
                    counter += 1
              
        elif sum_first > sum_second:
            first_half = list(word[half_word_len:])
            second_half = list(word[:half_word_len])
            for x, letter in enumerate(second_half):
                while second_half[x] != first_half[-(x+1)]:
                    second_half[x] = chr(ord(second_half[x]) - 1)
                    counter += 1
                else:
                    not_allowed = True

        else:
            pass

        if counter == 0:
            second_half.pop(0)
            largest_palindrome = first_half + second_half
            for num in largest_palindrome:
                largest_palindrome_str += num

        else:
            rev_first_half = []
            for x, i in enumerate(word):
                rev_first_half.append(word[-(x+1)])
            rev_first_half.pop(0)
            largest_palindrome = [lett for lett in word] + rev_first_half
            for num in largest_palindrome:
                largest_palindrome_str += num

        print (counter, end = " ")
        largest_palindrome_str += " "

print()
print(largest_palindrome_str)