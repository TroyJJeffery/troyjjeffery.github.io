"""
Given a olist of numbers in random order, write an algorithm that works in O(nlog(n)) to find the kth smallest number in the olist.
"""

import random


def createList():
    olist = []
    i=0
    while i < 1000:
        olist.append(random.randint(500,100000))
        i=i+1
    return olist

def test(k):
    olist = createList()

    nlist=[999999]

    i=0
    for i in range(len(olist)):
        #Iterates over "olist" and sorts out the smallest objects into "nlist"
          if (len(nlist) > 0 and len(nlist) < k):

            j=0
            #This compares the number against numbers in "nlist" placing them in descending order.
            while j < len(nlist):# While the variable is less than the length of the new list.
                if olist[i] > nlist[j]: #
                    nlist.insert(0, olist[i])
                    break

                elif olist[i] == nlist[j]:
                    break

                elif olist[i] < nlist[j]:
                    if j == len(nlist)-1:
                        nlist.append(olist[i])
                        break
                    else:
                      j=j+1


          elif len(nlist) == k:
            if olist[i] < nlist[k-1]:
                j=1
                while j < len(nlist):
                    if olist[i] < nlist[j]:
                        j=j+1
                    elif olist[i] < nlist.index(j-1) & olist[i] > nlist[j]:
                        nlist.insert(j-1, olist[i])
                        del nlist[j-1]

    print(nlist)



if __name__ == '__main__':
    test(9)