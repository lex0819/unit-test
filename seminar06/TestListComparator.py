import unittest
from ListComparator import ListComparator


class TestListComparator(unittest.TestCase):

    def test_compare_lists(self):
        lc = ListComparator([1, 2, 3], [4, 5, 6])

        self.assertEqual(lc.compare_lists(), "Второй список имеет большее среднее значение")

        lc = ListComparator([1, 2, 3], [1, 2, 3])

        self.assertEqual(lc.compare_lists(), "Средние значения равны")

        lc = ListComparator([], [])

        self.assertEqual(lc.compare_lists(), "Средние значения равны")

        lc = ListComparator([4, 5, 6], [])

        self.assertEqual(lc.compare_lists(), "Первый список имеет большее среднее значение")
