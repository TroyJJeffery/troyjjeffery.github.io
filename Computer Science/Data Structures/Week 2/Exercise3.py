"""
Devise an experiment that compares the performance of the del operator on lists and dictionaries.
"""
import timeit

def createList():
    list = []
    for i in range(10000,20000):
        list.append(i)
    return list

def createDict():
    dict = {}
    count = 0
    for i in range(10000,20000):
    
        key = i
        val = count-1
        dict[i] = val
        count+=1
    return dict

dict = createDict()
list = createList()
print(list)

def test1():
    list.append(1)
    list.pop(5000)

def test2():
    dict.pop(15000, None)
    dict[15000:5]

def runTests():
    #Runs a timed test of test1 and test2 for comparison.
    t1 = timeit.Timer("test1()", "from __main__ import test1")
    print ("List :", t1.timeit(number=10000), "O of log(n)")

    t2 = timeit.Timer("test2()", "from __main__ import test2")
    print("Dictionary :", t2.timeit(number=10000), "O of 1")

if __name__ == '__main__':
    runTests()