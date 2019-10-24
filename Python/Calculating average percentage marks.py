# -*- coding: utf-8 -*-
"""
Created on Thu Oct 24 11:13:56 2019

@author: Prasenjeet
"""
if __name__ == '__main__':
    n = int(input())
    student_marks = {}
    for _ in range(n):
        name, *line = input().split()
        scores = list(map(float, line))
        student_marks[name] = scores
    new_name = input()
new_score = student_marks[new_name]
print("{:.2f}".format((sum(new_score))/len(new_score)))