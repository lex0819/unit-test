class ListComparator:

    def __init__(self, list1: list, list2: list):

        self.list1 = list1
        self.list2 = list2

    def calculate_average(self, num_list: list) -> float:
        """
Метод подсчитывает среднее арифметическое списка чисел
        :param num_list: список чисел
        :return: среднее арифметическое списка чисел
        """
        if len(num_list) > 0:
            return sum(num_list) / len(num_list)
        else:
            return 0

    def compare_lists(self) -> str:
        """
Метод сравнивает среднее арифметическое двух списков
        :return: результат сравнения в виде строки
        """
        avg1 = self.calculate_average(self.list1)
        avg2 = self.calculate_average(self.list2)

        if avg1 > avg2:
            return "Первый список имеет большее среднее значение"
        elif avg1 < avg2:
            return "Второй список имеет большее среднее значение"
        else:
            return "Средние значения равны"
