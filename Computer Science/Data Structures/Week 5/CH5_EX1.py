"""
1. Set up a random experiment to test the difference between a sequential search and a
binary search on a list of integers. Use the binary search functions given in the text
(recursive and iterative). Generate a random, ordered list of integers and do a benchmark
analysis for each one. What are your results? Can you explain them?
"""


"""
@variable - my_list : Every integer from 0 to 100000
@variable - num : A random number between 0 and 100000
@variable - n : The number of repetitions (1,000,000)

Sequential 3.0049973  --> Checks each item until found, then bails.
Binary - Recursive 50.7690359  --> Checks half, if not found returns a new list.
Binary - Iterative 9.466331399999994 -->  Checks half, if not found adjusts search index.
"""

import random
import timeit

def fillList(list):
    #Makes an ordered list of integers.
    for i in range(10000):
        list.append(i)



def binary_search_recursive(a_list, item):
    #From Book
    if len(a_list) == 0:
        return False
    else:
        midpoint = len(a_list) // 2
    if a_list[midpoint] == item:
       return True
    else:
        if item < a_list[midpoint]:
            return binary_search_recursive(a_list[:midpoint], item)
        else:
            return binary_search_recursive(a_list[midpoint + 1:], item)

def binary_search_iterative(a_list, item):
    #From Book
    first = 0
    last = len(a_list) - 1
    found = False
    while first <= last and not found:
        midpoint = (first + last) // 2
        if a_list[midpoint] == item:
            found = True
        else:
            if item < a_list[midpoint]:
                last = midpoint - 1
            else:
                first = midpoint + 1
    return found

def ordered_sequential_search(a_list, item):
    #From Book
    pos = 0
    found = False
    stop = False
    while pos < len(a_list) and not found and not stop:
        if a_list[pos] == item:
            found = True
        else:
            if a_list[pos] > item:
                stop = True
            else:
                 pos = pos+1
        return found


def binary_recursive_no_splice(a_list, item, min=None, max=None):#No Splice
    if min == None:
        min = 0
    if max == None:
        max = len(a_list)

    if len(a_list) == 0:
        return False
    else:
        midpoint = ((max-min) // 2) + min
        if a_list[midpoint] == item:
            return True
        else:
            if item < a_list[midpoint]:
                return binary_recursive_no_splice(a_list, item, min=min, max=midpoint-1)
            else:
                return binary_recursive_no_splice(a_list, item, min=midpoint+1, max=max)
#Helper Methods (to check with breakpoint)
def test1(my_list, num):
    ordered_sequential_search(my_list, num)
def test2(my_list, num):
    binary_search_recursive(my_list, num)
def test3(my_list, num):
    binary_search_iterative(my_list, num)
def test4(my_list, num):
    binary_recursive_no_splice(my_list,num)

def test():
    n= 1000000

    t1 = timeit.Timer("test1(my_list,num)", "from __main__ import my_list, num, ordered_sequential_search,test1")
    print("Sequential", t1.timeit(number=n))

    t2 = timeit.Timer("test2(my_list,num)", "from __main__ import my_list, num, ordered_sequential_search,test2")
    print("Binary - Recursive", t2.timeit(number=n))

    t3 = timeit.Timer("test3(my_list,num)", "from __main__ import my_list, num, ordered_sequential_search,test3")
    print("Binary - Iterative", t3.timeit(number=n))

    t4 = timeit.Timer("test4(my_list,num)", "from __main__ import my_list, num, ordered_sequential_search,test4")
    print("Binary - No Splice", t4.timeit(number=n))

if __name__ == "__main__":
    my_list=[]
    fillList(my_list)
    num = random.randint(0,10000)

    test()