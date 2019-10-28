"""
2. Implement the binary search using recursion without the slice operator. Recall that you
will need to pass the list along with the starting and ending index values for the sublist.
Generate a random, ordered list of integers and do a benchmark analysis.
"""


"""
Sequential 2.7214764000000002
Binary - Recursive 50.758993499999995
Binary - Iterative 9.403234700000006
Binary - No Splice 24.485811299999995
"""

import random

def fillList(list):
    #Makes an ordered list of integers.
    for i in range(10000):
        list.append(i)

def binary_search_recursive(a_list, item): #Original
    #FFrom Book
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



if __name__ == "__main__":
    list=[]
    fillList(list)
    num = random.randint(0,10000)

    print(binary_recursive_no_splice(list, num))