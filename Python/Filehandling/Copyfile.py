#Copies text from file and appends to file 2 times
with open("data.txt","a+") as myfile:
    myfile.seek(0)
    content=myfile.read()
    myfile.seek(0)
    for i in range(1,2):
        myfile.write("\n"+content)
    myfile.seek(0)
    print(myfile.read())
