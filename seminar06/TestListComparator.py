import unittest

from ListComparator import ListComparator


class TestListComparator(unittest.TestCase):
    """
Принимает два списка чисел и рассчитывает среднее значение каждого списка.
Сравнивает эти средние значения и выводит соответствующее сообщение:
- Первый список имеет большее среднее значение, если среднее значение первого списка больше.
- Второй список имеет большее среднее значение, если среднее значение второго списка больше.
- Средние значения равны, если средние значения списков равны.

>> > lc = ListComparator([1, 2, 3], [4, 5, 6])
"Второй список имеет большее среднее значение"

>> > lc = ListComparator([], [])
"Средние значения равны"

>> > lc = ListComparator([20], [4, 5, 6])
"Первый список имеет большее среднее значение"
    """

    def test_compare_lists(self):
        lc = ListComparator([1, 2, 3], [4, 5, 6])

        self.assertEqual(lc.compare_lists(), "Второй список имеет большее среднее значение",
                         "для [1, 2, 3] и [4, 5, 6] верно")

        lc = ListComparator([1, 2, 3], [1, 2, 3])

        self.assertEqual(lc.compare_lists(), "Средние значения равны", "для [1, 2, 3]  [1, 2, 3] верно")

        lc = ListComparator([], [])

        self.assertEqual(lc.compare_lists(), "Средние значения равны", "пустых списков верно")

        lc = ListComparator([20],[4, 5, 6])

        self.assertEqual(lc.compare_lists(), "Первый список имеет большее среднее значение", "Ожидаемый провал")
