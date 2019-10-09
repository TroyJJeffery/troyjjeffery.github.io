import unittest
from FractionModule import Fraction

class FractionTest(unittest.TestCase):

    #Set's up class instances for each test.
    def setUp(self):
        self.f1 = Fraction(1,2)
        self.f2 = Fraction(1,4)
        self.f3 = Fraction(-1,2)
        self.f4 = Fraction(1,-4)
        self.f5 = Fraction(-1,-2)

    #Verifies addition functions are working normally.
    def test_add(self):
        f1 = Fraction(1,2)
        f2 = Fraction(1,4)
        f3 = Fraction(-1,2)
        f4 = Fraction(1,-4)
        f5 = Fraction(-1,-2)


        self.assertEqual(f1+f2, Fraction(3,4))
        self.assertEqual(f3+f4, Fraction(-3,4))
        self.assertEqual(f5+f5, Fraction(1,1))

    #Verifies subtracting functions are working normally.
    def test_subtract(self):
        f1 = Fraction(1,2)
        f2 = Fraction(1,4)
        f3 = Fraction(-1,2) #-2/4
        f4 = Fraction(1,-4) #-1/4
        f5 = Fraction(-1,-2) #1/2

        self.assertEqual(f1-f2, Fraction(1,4))
        self.assertEqual(f3-f4, Fraction(-1,4))
        #self.assertRaises(ValueError, f5-f5, Fraction(2,2))

    #Verifies multiplication functionality.
    def test_multiply(self):
        f1 = Fraction(1,2)
        f2 = Fraction(1,4)
        f3 = Fraction(-1,2)
        f4 = Fraction(1,-4)
        f5 = Fraction(-1,-2)

        self.assertEqual(f1*f2, Fraction(1,8))
        self.assertEqual(f3*f4, Fraction(1,8))
        self.assertEqual(f5*f5, Fraction(1,4))

    #verifies division capabilities.
    def test_divide(self):
        f1 = Fraction(1,2)
        f2 = Fraction(1,4)
        f3 = Fraction(-1,2)
        f4 = Fraction(1,-4)
        f5 = Fraction(-1,-2)

        self.assertEqual(f1/f2, Fraction(2,1))
        self.assertEqual(f3/f4, Fraction(2,1))
        self.assertEqual(f5/f5, Fraction(1,1))

    #Verifies fraction equality is working correctly.
    def test_equals(self):
        f1 = Fraction(1,2)
        f2 = Fraction(1,4)
        f3 = Fraction(-1,2)
        f4 = Fraction(1,-4)
        f5 = Fraction(-1,-2)

        self.assertEqual(f1==f2, False)
        self.assertEqual(f3==f4, False)
        self.assertEqual(f5==f5, True)

    #Verifies that function greater than equality.
    def test_greaterthan(self):
        f1 = Fraction(1,2)
        f2 = Fraction(1,4)
        f3 = Fraction(-1,2)
        f4 = Fraction(1,-4)
        f5 = Fraction(-1,-2)

        self.assertEqual(f1>f2, True)
        self.assertEqual(f3>f4, False)
        self.assertEqual(f5>f5, False)

    #verifies that lessser than functions work.
    def test_lessthan(self):
        f1 = Fraction(1,2)
        f2 = Fraction(1,4)
        f3 = Fraction(-1,2)
        f4 = Fraction(1,-4)
        f5 = Fraction(-1,-2)

        self.assertEqual(f1<f2, False)
        self.assertEqual(f3<f4, True)
        self.assertEqual(f5<f5, True)

    #Verifies that strings are being created correctly.
    def test_string(self):
        f1 = Fraction(1,2)
        f2 = Fraction(1,4)
        f3 = Fraction(-1,2)
        f4 = Fraction(1,-4)
        f5 = Fraction(-1,-2)

        self.assertEqual(str(f1+f2), "3/4")
        self.assertEqual(str(f3+f4), "-3/4")
        self.assertEqual(str(f5+f5), "1/1")

if __name__ == '__main__':
    unittest.main(exit=False)