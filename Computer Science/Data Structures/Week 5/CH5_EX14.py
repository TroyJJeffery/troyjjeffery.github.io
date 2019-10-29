"""
14. One way to improve the quick sort is to use an insertion sort on lists that have a small
length (call it the “partition limit”). Why does this make sense? Re-implement the quick
sort and use it to sort a random list of integers. Perform an analysis using different list
sizes for the partition limit.
"""
import timeit
import random

def insertion_sort(a_list):
    for index in range(1, len(a_list)):
        current_value = a_list[index]
        position = index
        while position > 0 and a_list[position - 1] > current_value:
            a_list[position] = a_list[position - 1]
            position = position - 1
        a_list[position] = current_value


def quick_sort_helper(a_list, first, last):
    if first < last:
        split_point = partition(a_list, first, last)
        quick_sort_helper(a_list, first, split_point - 1)
        quick_sort_helper(a_list, split_point + 1, last)

def quick_sort(a_list):
    quick_sort_helper(a_list, 0, len(a_list) - 1)

def partition(a_list, first, last):
    pivot_value = a_list[first]

    left_mark = first + 1
    right_mark = last

    done = False
    while not done:

        while left_mark <= right_mark and a_list[left_mark] <= pivot_value:
            left_mark = left_mark + 1

        while a_list[right_mark] >= pivot_value and right_mark >= left_mark:
            right_mark = right_mark - 1

        if right_mark < left_mark:
            done = True
        else:
            temp = a_list[left_mark]
            a_list[left_mark] = a_list[right_mark]
            a_list[right_mark] = temp

    temp = a_list[first]
    a_list[first] = a_list[right_mark]
    a_list[right_mark] = temp

    return right_mark

def fill(size):
    list=[]
    i=0
    while i < size:
        list.append(random.randint(0,99999999))
        i+=1

    return list

def test1(list):
    quick_sort(list)

def test(list):
    t1 = timeit.Timer("test1(my_list)", "from __main__ import my_list,test1")
    print("Quick Sort", t1.timeit(number=10))


if __name__ ==  "__main__":
    my_list=[]
    i=0
    num=10
    while i < 6:
       my_list = fill(num)
       test(my_list)
       num=num*10
       i=+1
