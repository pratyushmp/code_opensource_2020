# use the path of your text file instead of "text_file.txt"

# get the file and specify the encoding when you open the file
for line in open("text_file.txt", encoding="utf8"):
	# split the line into a list
	for word in line.split():
		# print each word of the line
		print(word)
