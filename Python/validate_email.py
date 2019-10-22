import re

regex = '^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$'

def validate(email):
    if(re.search(regex,email)):
        print("Valid Email")

    else:
        print("Invalid Email")


if __name__ == '__main__' :
    email = "abc@gmail.com"
    validate(email)

    email = "ownwebsite@ourearth.org"
    validate(email)

    email = "chotachetan@"
    validate(email)