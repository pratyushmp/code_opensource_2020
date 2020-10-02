def MergeSort(lst):
    if len(lst) > 1:
        #dividing the list into left and right halves
        mid = len(lst) // 2
        left = lst[:mid]
        right = lst[mid:]

        #recursive division of successive lists until all of them attain a length of 1
        MergeSort(left)
        MergeSort(right)

        i = 0        #iterator for left half
        j = 0        #iterator for right half

        k = 0        #iterator for main list

        while i < len(left) and j < len(right):
            #comparing values of left half with the values of right half and inserting the smaller one in the main list
            if left[i] < right[j]:
                lst[k] = left[i]
                i += 1                    
            else:
                lst[k] = right[j]
                j += 1
            k += 1

        #for the remaining elements
        while i < len(left):
            lst[k] = left[i]
            i += 1
            k += 1

        while j < len(right):
            lst[k] = right[j]
            j += 1
            k += 1

#example
myList = [5, 9, 1, 0, 4]
MergeSort(myList)
print(myList)