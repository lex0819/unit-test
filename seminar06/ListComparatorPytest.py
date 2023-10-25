import pytest

from ListComparator import ListComparator


@pytest.fixture  # decorator
def listcomparator1():
    return ListComparator([1, 2, 3], [4, 5, 6])


@pytest.fixture  # decorator
def listcomparator2():
    return ListComparator([20, 30], [4, 5, 6])


@pytest.fixture  # decorator
def listcomparator3():
    return ListComparator([1, 2, 3], [1, 2, 3])


@pytest.fixture  # decorator
def listcomparator4():
    return ListComparator([], [])


def test_compare_lists1(listcomparator1):
    res = listcomparator1.compare_lists()
    assert res == "Второй список имеет большее среднее значение"


def test_compare_lists2(listcomparator2):
    res = listcomparator2.compare_lists()
    assert res == "Первый список имеет большее среднее значение"


def test_compare_lists3(listcomparator3):
    res = listcomparator3.compare_lists()
    assert res == "Средние значения равны"


def test_compare_lists4(listcomparator4):
    res = listcomparator4.compare_lists()
    assert res == "Средние значения равны"
