import unittest
from CH5_EX1 import *


class FractionTest(unittest.TestCase):

    def setUp(self):
        pass

    def test_fact(self):
        self.assertEqual(fact(1), 1)
        self.assertEqual(fact(3), 6)
        self.assertEqual(fact(5), 120)
        self.assertEqual(fact(10), 3628800)

    def test_calc(self):
        self.assertEqual(calc(1), "1 is factorial 1")
        self.assertEqual(calc(2), "2 is factorial 2")
        self.assertEqual(calc(6), "6 is factorial 3")
        self.assertEqual(calc(120), "120 is factorial 5")
        self.assertEqual(calc(3628800), "3628800 is factorial 10")

        self.assertEqual(calc(100), "Factorial is between 4 and 5")
        self.assertEqual(calc(56), "Factorial is between 4 and 5")
        self.assertEqual(calc(1000), "Factorial is between 6 and 7")

if __name__ == '__main__':
    unittest.main(exit=False)