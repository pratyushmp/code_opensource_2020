arr = [[0, 6], [1, 4], [3, 5], [3, 8], [4, 7], [5, 9], [6, 10], [8, 11]]


  def findSubsetJobs(list, index)
    if list[index].nil? 
        return
    end
    p list[index]
    findSubsetJobs(list, index+1)
    
  end

  def subsetJobs(list)
    comp = Proc.new{|last, first| last <= first}
    subset = Hash.new{|hash, key| hash[key] = []}

    list.each_index do | i |
        arr2 = []
        arr2 << list[i]

        list.each do | ele |
            lastele = arr2[-1][1]

            if comp.call(lastele, ele[0])
                arr2 << ele
            end
        end
        subset[i] = arr2
    end
   
    largest = []
    subset.each do | key, val |
        if val.length >= largest.length
            largest = val
        end
    end
    p largest
  end

subsetJobs(arr)
#findSubsetJobs(arr, 0)