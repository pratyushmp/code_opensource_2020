def bubble_sort(array)
  sorted = false

  until sorted
    sorted = true

    (1...array.length).each do |i|
      if array[i - 1] > array[i]
        sorted = false
        array[i - 1], array[i] = array[i], array[i - 1]
      end
    end
  end

  array
end
