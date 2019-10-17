"""
Implement a radix sorting machine. 
A radix sort for base 10 integers is a mechanical sorting technique that utilizes a collection of bins, one main bin and 10 digit bins.
Each bin acts like a queue and maintains its values in the order that they arrive. 
The algorithm begins by placing each number in the main bin. 
Then it considers each value digit by digit. 
The first value is removed and placed in a digit bin corresponding to the digit being considered. 
For example, if the ones digit is being considered, 534 is placed in digit bin 4 and 667 is placed in digit bin 7. 
Once all the values are placed in the corresponding digit bins, the values are collected from bin 0 to bin 9 and placed back in the main bin. 
The process continues with the tens digit, the hundreds, and so on. 
After the last digit is processed, the main bin contains the values in order.
"""
import random
from Stack import Stack

def fill(bin):
    random.seed(1)
    for n in range(10):
        bin.append(random.randint(100,999))

def get_digit(digit, num):
    li = list(str(num))

    rev = []
    for i in reversed(li):
        rev.append(i)

    return int(rev[digit-1])

def repeat(bin1,bin2,digit):
    bin1=bin1
    bin2=bin2
    d=digit
    d=0

    while i < d:
        bin2=sort(bin1,d)

        bin1=bin2
        bin2.clear()
        i=i+1
    return bin1

def sortbin(bin,digitqty):
    fbin=bin
    sbin=[]
    d=digitqty

    i=0
    while i < 10: #Add items into bin2 that end with 0,1,2....)
        for num in fbin:
            if get_digit(d,num) == i: #If the last digit is equal to 0,1,2....
                sbin.append(num) #add that number to list 2
        i=i+1 #Otherwise increase the number of the item you are looking for.

    return sbin

def test(digitsToSort):
    d = digitsToSort
    bin1=[]
    fill(bin1)
    bin2=sortbin(bin1,d)

    print("Before ")
    print(bin1)
    print("After ")
    print(bin2)
if __name__ == '__main__':
    test(3)
    #print(get_digit(1,140)==0)