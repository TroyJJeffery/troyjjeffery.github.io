"""
Write a recursive function to compute the factorial of a number.
"""


def fact(n):

    """
    @param n -> The factorial you want.
    @param i -> index value
    @param prod -> The current product.
    """

    n, i, prod = n, 1, 1

    while i < n+1:
         prod = prod*i
         i += 1

    return prod


"""
@param num -> The number that you want to know the factorial of.
@param prod -> The product of all numbers so far in the factorial.
@param i -> index value

"""


def calc(num):
    """
    @param num -> The number that you want to know the factorial of.
    @param prod -> The product of all numbers so far in the factorial.
    @param i -> index value

    """
    num, i, done, ans = num, 1, False, None
    if num <= 0:
        raise ValueError("Number must be greater than zero.")
    elif num > 2147483647:
        raise ValueError("Your number is too large for a 32 bit system.")
    else:
        while done == False:
            if fact(i) == num:
                done = True
                ans =  f"{num} is factorial {i}"
            if fact(i) > num:
                done = True
                ans =  f"Factorial is between {i-1} and {i}"
            else:
                i += 1
    return ans



if __name__ == '__main__':
    pass


