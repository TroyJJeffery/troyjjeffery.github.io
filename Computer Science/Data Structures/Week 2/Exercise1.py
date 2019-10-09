"""
Devise an experiment to verify that the list index operator is O(1)
"""

import timeit

"""
Verifies that the index operator is O(1) by comparing it's run time to a BigO of log n function.
"""

list = []
for i in range(10000):
    list.append(i)

def test1():
    #Checks the list at a specific index location and returns it's value.
    return list.index(5482)

def test2():
    #Checks the list to see if a given value is in the list.
    for i in list:
        if [i] == 5482:
            return list.index(i)

def runTests():
    #Runs a timed test of test1 and test2 for comparison.
    t1 = timeit.Timer("test1()", "from __main__ import test1")
    print ("test1", t1.timeit(number=10000), "O of 1")

    t2 = timeit.Timer("test2()", "from __main__ import test2")
    print("test2", t2.timeit(number=10000), "O of log n")
        ###########################################################################################
if __name__ == '__main__':
    runTests()