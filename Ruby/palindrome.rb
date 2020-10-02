# Return 7 for the string "MAPTAPTMTPA"

class String
    def palindrome?
        if self.reverse == self
            return true
        end
    end
end

def findPalindrome(str)
    front_arr = str.split(//)
    palindromes = []

    front_arr.each_index do | i |
        # As the combo length increases the amount of combos decreases
        # 1 - 10, 2 - 9, 3 - 8, etc
        combo_amount = front_arr.length-i
        prev = 0
        curr = i

        (0..combo_amount).each do | index |
            str = front_arr[prev..curr].join
            if str.length > i
                if str.palindrome?
                    palindromes << str
                end
            end
            prev += 1
            curr += 1
        end
    end
   
    longest = ""

    palindromes.each do | pal |
        if pal.length > longest.length
            longest = pal
        end
    end

    p longest.length
end

findPalindrome("MAPTAPTMTPA")