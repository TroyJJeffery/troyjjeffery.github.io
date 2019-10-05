#Finds the least common denominator between two fractions.
def gcd(m,n):

    while m%n != 0:
        oldm=m
        oldn=n


        m=oldn
        n=oldm%oldn
    return n

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
        
        cd = gcd(top,bottom)

        self.num = top//cd
        self.den = bottom//cd

    #Converts fraction into a string.
    def __str__(self):

        return str(self.num)+"/"+str(self.den)

    #Adds two fractions together.
    def __add__(self, otherfraction):

        newnum = self.num*otherfraction.den+self.den*otherfraction.num
        newden = self.den*otherfraction.den

        return Fraction(newnum,newden)

    #Subtracts one fraction from another.
    def __sub__(self, frac):
        # a/b-c/d
        ad = self.num * frac.den
        bc = self.den * frac.num
        newden = self.den * frac.den
        newnum = ad - bc

        return Fraction(newnum, newden)

    #Multiplies two fractions.
    def __mul__(self, frac):
        newnum = self.num * frac.num
        newden = self.den * frac.den

        return Fraction(newnum, newden)

    #Divides one fraction into another.
    def __truediv__(self, frac):
        newnum = self.num * frac.den
        newden = self.den * frac.num

        return Fraction(newnum, newden)

    #Compares two fractions to each other.
    def __eq__(self, other):
        firstnum = self.num * other.den
        secondnum = other.num * self.den

        return firstnum == secondnum

    #Checks if two fractions are not equal.
    def __ne__(self, other):
        return not self == other

    #Checks if one fraction is greater than another.
    def __gt__(self, frac):
        firstnum = self.num * frac.den
        secondnum = self.den * frac.num

        return firstnum > secondnum

    #Checks to see if one fraction is less than another.
    def __lt__(self, frac):

        return not self > frac

    #Formats fractions for display.
    def show(self):

        print(self.num, "/", self.den)


############################################################################################
if __name__ == '__main__':
    pass