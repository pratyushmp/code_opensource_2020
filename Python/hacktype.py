#!/usr/bin/python
import argparse
from curses import *
import os
parser = argparse.ArgumentParser(
    prog='hackertype',
    description='A CLI tool for making yourself look cool to dumb people.'
)



# args for cli:
parser.add_argument('-fgc', '--fgcolor', type=str, choices=['0','1','2','3','4','5','6','7'], dest='fgc', required=False)
parser.add_argument('-bgc', '--bgcolor', type=str, choices=['0','1','2','3','4','5','6','7'], dest='bgc', required=False)
parser.add_argument('-f', '--file', type=str, dest='file', required=False)
args = parser.parse_args()
s=initscr()
noecho()
start_color()

#default values:
try:
    fgcolor = int(args.fgc)
except:
    fgcolor = COLOR_GREEN
try:
    bgcolor = int(args.bgc)
except:
    bgcolor = COLOR_BLACK

filepath = args.file

if filepath == None:
    filepath = __file__

print(filepath)

#Main function:
try:
    init_pair(2,fgcolor,bgcolor)
    with open(filepath) as filetoread:
        for x in filetoread.read().split(" "):
            s.getch()
            try:
                s.addstr(str(x)+" ",color_pair(2))
            except:
                s.erase()
                s.addstr(str(x)+" ",color_pair(2))



    echo()
    endwin()
    os.system('clear')
except:
    echo()
    endwin()
    os.system('clear')
