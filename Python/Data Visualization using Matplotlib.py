from matplotlib import pyplot as plt

list1 = [1,2,3,4,5,6,7,8,9,10]
list2 = [2,4,6,8,10,12,14,16,18,20]

plt.plot(list1,list2,color = 'red')
plt.xlabel('list1')
plt.ylabel('list2')
plt.title('Simple Graph Using Matplotlib')
plt.show()
plt.scatter(list1,list2,s= 45 ,color = 'blue', alpha = 0.7)             #s->size, alpha-> transperency of the plot
plt.xlabel('list1')
plt.ylabel('list2')
plt.title('Scatter Plot')
plt.show()
