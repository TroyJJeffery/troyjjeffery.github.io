"""
Write a recursive function to reverse a list.
"""

def fillList(myList):
    for i in range(10):
        myList.append(i)

    return myList

def swap(myList, i):
    myList = myList

    myList.insert(i, myList[len(myList)-1])
    del myList[len(myList)-1]
    return myList

def revList(myList):
    i=0

    while i < len(myList):
        swap(myList, i)
        i+=1
    return myList

if __name__ == "__main__":
    myList = []
    fillList(myList)


    print(myList)
    print(revList(myList))
