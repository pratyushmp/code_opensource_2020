/*
Given a String, check if that string is a palindrome,
A palindrome is a word, number, phrase, or other sequence of characters which reads the same backward as forward, such as madam, racecar.
Input:
a string
Output:
if string is a palindrome, output "YES", else output "NO"
Example:
Input:
madam
Output:
YES
*/


#include <iostream>
using namespace std;
int main()
{
    string kata;
    cin>>kata;
    int a=0,j=kata.length()-1;
    for(int i=0;i<kata.length();i++){
        if(kata[i]==kata[j])a++;
        j--;
    }
    if(a==kata.length())cout<<"YOI";
    else cout<<"NEHI";
}
