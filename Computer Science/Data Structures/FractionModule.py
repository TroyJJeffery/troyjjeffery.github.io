"""
Author : Troy Jeffery

Fraction : Takes two integers and makes them into a fraction that can do basic math functions.

Variables
__num : The object's numerator as an integer.
__den : The objects denominator as an integer.

"""
class Fraction:
    #Constructor for class Fraction
    def __init__(self, top, bottom):
        if top <0 and bottom <0: # if -/- result +/+
            bottom*-1
            top*-1

        if top > 0 and bottom < 0: # if +/- result -/+
            top = top*-1
            bottom = bottom*-1

        if top == 0: # if 0/x result 0/0
            top = 0
            bottom = 0

        if bottom == 0: # if x/0 result error
            raise ValueError ("Cannot divide by zero.")

       #Finds the least common denominator between two fractions.
        def gcd(m,n):

            while m%n != 0:
                oldm=m
                oldn=n


                m=oldn
                n=oldm%oldn
            return n    
        
        cd = gcd(top,bottom)

        self.__num = top//cd
        self.__den = bottom//cd



    #Converts fraction into a string.
    def __str__(self):

        return str(self.__num)+"/"+str(self.__den)

    #Adds two fractions together.
    def __add__(self, otherfraction):

        newnum = self.__num*otherfraction.__den+self.__den*otherfraction.__num
        newden = self.__den*otherfraction.__den

        return Fraction(newnum,newden)

    #Subtracts one fraction from another.
    def __sub__(self, frac):
        # a/b-c/d
        ad = self.__num * frac.__den
        bc = self.__den * frac.__num
        newden = self.__den * frac.__den
        newnum = ad - bc

        return Fraction(newnum, newden)

    #Multiplies two fractions.
    def __mul__(self, frac):
        newnum = self.__num * frac.__num
        newden = self.__den * frac.__den

        return Fraction(newnum, newden)

    #Divides one fraction into another.
    def __truediv__(self, frac):
        newnum = self.__num * frac.__den
        newden = self.__den * frac.__num

        return Fraction(newnum, newden)

    #Compares two fractions to each other.
    def __eq__(self, other):
        firstnum = self.__num * other.__den
        secondnum = other.__num * self.__den

        return firstnum == secondnum

    #Checks if two fractions are not equal.
    def __ne__(self, other):
        return not self == other

    #Checks if one fraction is greater than another.
    def __gt__(self, frac):
        firstnum = self.__num * frac.__den
        secondnum = self.__den * frac.__num

        return firstnum > secondnum

    #Checks to see if one fraction is less than another.
    def __lt__(self, frac):

        return not self > frac

    #Formats fractions for display.
    def show(self):

        print(self.__num, "/", self.__den)


############################################################################################
if __name__ == '__main__':
    pass