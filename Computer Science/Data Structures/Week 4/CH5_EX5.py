"""
Write a recursive function to compute the Fibonacci sequence. How does the performance of the recursive function compare to that of an iterative version?

1,1,2,3,5,8....
"""
import timeit

def recur(num):

    i = 0
    if num < 2:
        return 1
    else:
        while i < num:
            return recur(num-2) + recur(num-1)

def iter(num):
    y1=1
    y2=1
    i=2

    if num == (0 or 1):
        return 1

    elif num >= 2:

        while i < num:
            y3=y1+y2

            y1=y2
            y2=y3
            return y3

def test():
    """
    Add 281.7978426 Recursive:
    Add 0.020054700000002867 Iterative:
    """
    t1 = timeit.Timer("recur(20)", "from __main__ import recur")
    print("Add", t1.timeit(number=10000), f"Recursive:")

    t2 = timeit.Timer("iter(20)", "from __main__ import iter")
    print("Add", t2.timeit(number=10000), f"Iterative:")

if __name__ == '__main__':
    test()
