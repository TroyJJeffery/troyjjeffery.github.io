from unittest import TestCase
from FractionModule import Fraction



class TestFraction(TestCase):

    def setUp(self):
        f1 = Fraction.Fraction(3,5)
        f2 = Fraction(1,4)

    def test_add(self):
        f1 = Fraction.Fraction(3,5)
        # self.assertEqual(f1+f2, 15)
        # self.assertEqual(self.__add__(-5, 10), -5)
        #self.assertEqual(Fraction.add(-5, -10), -15)
        self.assertEqual(f1.__add__(f2), 5)
