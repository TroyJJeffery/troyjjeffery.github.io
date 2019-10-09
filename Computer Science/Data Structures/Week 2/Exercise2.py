"""
Devise an experiment to verify that get item and set item are O(1) for dictionaries.
"""

import timeit


def createDict():
    dict = {}
    count = 0
    for i in range(10000,20000):
    
        key = i
        val = count-1
        dict[i] = val
        count+=1
    return dict
dict=createDict()

def test1():
    return dict[19999]

def test2():
    found = False
    for i in dict:
        if i == 19999:
            found = True
            return True
    if found == False:
       print("not in list")

def test3():
    dict["New"] = "Entry"
    return dict["New"]

def runTests():
    #Runs a timed test of test1 and test2 for comparison.
    t1 = timeit.Timer("test1()", "from __main__ import test1")
    print ("Get", t1.timeit(number=10000), "O of One")

    t2 = timeit.Timer("test2()", "from __main__ import test2")
    print("Find", t2.timeit(number=10000), "O of log (n)")

    t3 = timeit.Timer("test3()", "from __main__ import test3")
    print("Add", t3.timeit(number=10000), "O of One")

if __name__ == '__main__':
    runTests()