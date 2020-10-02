def fibonacci(n)
  if (n<=2)
    return 1
  else
    return (fibonacci(n-1)+fibonacci(n-2))
  end
end

puts "Enter the value upto which fibonacci series gets printed:-"
n=gets.chomp.to_i

puts "The first #{n} values of fibonnaci series are:-"
for c in 1..n
  puts fibonacci(c)
end