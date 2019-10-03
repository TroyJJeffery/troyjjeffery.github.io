import unittest
from FractionModule import Fraction

class FractionTest(unittest.TestCase):

    def setup(self):
        f1 = Fraction(3,5)
        f2 = Fraction(1,4)

    #Verifies addition functions are working normally.
    def test_add(self):
        f1 = Fraction(3,5)
        f2 = Fraction(1,4)
        self.assertEqual(f1+f2, 15)
       # self.assertEqual(Fraction.__add__(-5, 10), -5)
        #self.assertEqual(Fraction.__add__(-5, -10), -15)
        #self.assertEqual(Fraction.__add__(5, 0), 5)
"""""
    #Verifies subtracting functions are working normally.
    def test_subtract(self):
        self.assertEqual(Fraction.__sub__(5, 10), -5)
        self.assertEqual(Fraction.__sub__(-5, 10), -15)
        self.assertEqual(Fraction.__sub__(-5, -10), 5)
        self.assertEqual(Fraction.__sub__(5, 0), 5)

    #Verifies multiplication functionality.
    def test_multiply(self):
        self.assertEqual(Fraction.__mul__(5, 10), 50)
        self.assertEqual(Fraction.__mul__(-5, 10), -50)
        self.assertEqual(Fraction.__mul__(-5, -10), 50)
        self.assertEqual(Fraction.__mul__(5, 0), 0)

    #verifies division capabilities.
    def test_divide(self):
        self.assertEqual(Fraction.__truediv__(5, 10), .5)
        self.assertEqual(Fraction.__truediv__(-5, 10), -.5)
        self.assertEqual(Fraction.__truediv__(-5, -10), .5)
        self.assertEqual(Fraction.__truediv__(0, 5), 0)

        self.assertRaises(ValueError, Fraction.__truediv__, 10, 0)

    #Verifies fraction equality is working correctly.
    def test_equals(self):
        self.assertEqual(Fraction.__eq__(5, 10), 15)
        self.assertEqual(Fraction.__eq__(-5, 10), -5)
        self.assertEqual(Fraction.__eq__(-5, -10), -15)
        self.assertEqual(Fraction.__eq__(5, 0), 0)

    #Verifies that function greater than equality.
    def test_greaterthan(self):
        self.assertEqual(Fraction.__gt__(5, 10), False)
        self.assertEqual(Fraction.__gt__(-5, 10), False)
        self.assertEqual(Fraction.__gt__(-5, -10), True)
        self.assertEqual(Fraction.__gt__(5, 0), True)

    #verifies that lessser than functions work.
    def test_lessthan(self):
        self.assertEqual(Fraction.__lt__(5, 10), True)
        self.assertEqual(Fraction.__lt__(-5, 10), True)
        self.assertEqual(Fraction.__lt__(-5, -10), False)
        self.assertEqual(Fraction.__lt__(5, 0), False)

    #Verifies that strings are being created correctly.
    def test_string(self):
        self.assertEqual(Fraction.__str__(5, 10), "510")
        self.assertEqual(Fraction.__str__(-5, 10), "-510")
        self.assertEqual(Fraction.__str__(-5, -10), "-5-10")
        self.assertEqual(Fraction.__str__(5, 0), "50")
"""
if __name__ == '__main__':
    unittest.main()