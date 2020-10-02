words = ['eat', 'ate', 'apt', 'pat', 'tea', 'now']

  def findAnagrams(list)
    possible = Hash.new{|hash, key| hash[key] = []}

        list.each do | ele |
            str_arr = ele.split(//)
            possible[ele] = str_arr.sort
        end

    occ = Hash.new{|hash, key| hash[key] = []}

        possible.each do | key, val |
           occ[val.join] << key
        end

        puts occ
  end

findAnagrams(words)