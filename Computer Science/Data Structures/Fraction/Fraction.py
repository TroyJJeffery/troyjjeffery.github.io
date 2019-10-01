class Fraction:
    #Constructor for class Fraction
    def __init__(self, top, bottom):

        self.num = top
        self.den = bottom

    #Converts fraction into a string.
    def __str__(self):

        return str(self.num)+"/"+str(self.den)

    #Adds two fractions together.
    def __add__(self, otherfraction):

        newnum = self.num*otherfraction.den+self.den*otherfraction.num
        newden = self.den*otherfraction.den
        common = gcd(newnum,newden)

        return Fraction(newnum//common,newden//common)

    #Subtracts one fraction from another.
    def __sub__(self, frac):
        # a/b-c/d
        ad = self.num * frac.den
        bc = self.den * frac.num
        newden = self.den * frac.den
        newnum = ad - bc
        common = gcd(newnum, newden)

        return Fraction(newnum // common, newden // common)

    #Multiplies two fractions.
    def __mul__(self, frac):
        newnum = self.num * frac.num
        newden = self.den * frac.den
        cd = gcd(newnum, newden)

        return Fraction(newnum // cd, newden // cd)

    #Divides one fraction into another.
    def __truediv__(self, frac):
        newnum = self.num * frac.den
        newden = self.den * frac.num
        if newden == 0:
            raise ValueError ("Cannot divide by zero.")
        cd = gcd(newnum, newden)

        return Fraction(newnum // cd, newden // cd)

    #Compares two fractions to each other.
    def __eq__(self,other):
        firstnum = self.num * other.den
        secondnum = other.num * self.den

        return firstnum == secondnum

    #Checks if one fraction is greater than another.
    def __gt__(self, frac):
        firstnum = self.num * frac.den
        secondnum = self.den * frac.num
        newden = self.den * frac.den

        return firstnum > secondnum

    #Checks to see if one fraction is less than another.
    def __lt__(self, frac):
        firstnum = self.num * frac.den
        secondnum = self.den * frac.num

        return firstnum < secondnum

    #Formats fractions for display.
    def show(self):

        print(self.num, "/", self.den)

#Finds the least common denominator between two fractions.
def gcd(m,n):
    while m%n != 0:
        oldm=m
        oldn=n

        m=oldn
        n=oldm%oldn
    return n
############################################################################################
