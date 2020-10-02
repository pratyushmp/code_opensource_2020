def flatten(list)
	print list
	puts
	return list if list == []
		
	if !list .is_a?(Array) 
		return Array(list)
	end

	flatten(list[0]) + flatten(list.slice(1..-1))
end
 
p flatten([[1], [[2]], 3, [[[[4]], 5]]])


