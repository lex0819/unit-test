# Урок 4. Зависимости в тестах

## Задание 1. Ответьте письменно на вопросы:

### 1) Почему использование тестовых заглушек может быть полезным при написании модульных тестов?
Потому, что разработчики еще не успели сделать весь функционал. Часть методов еще не готова, их нужно заглушить.

### 2) Какой тип тестовой заглушки следует использовать, если вам нужно проверить, что метод был вызван с определенными аргументами?

Mock, Spy

### 3) Какой тип тестовой заглушки следует использовать, если вам просто нужно вернуть определенное значение или исключение в ответ на вызов метода?

Stab, Fake

### 4) Какой тип тестовой заглушки вы бы использовали для имитации взаимодействия с внешним API или базой данных?

Fake

## Задание 2.

У вас есть класс BookService, 

который использует интерфейс BookRepository 

для получения информации о книгах из базы данных. 

Ваша задача написать unit-тесты для BookService, 

используя Mockito для создания мок-объекта BookRepository.

### Решение

См. исходные классы **BookRepository** и **BookService**

в папке [/main/java/seminar04/hw](../../../main/java/seminar04/hw)

См. тесты в файле [/hw/MockBookServiceTest.java](./hw/MockBookServiceTest.java)

Примеры тестов:

```java
//проверка для getBookId - нулевой элемент массива содержит id книги равный 1
assertEquals("1", repository.getBookId("1")[0]);

//проверка для getBookId - возвращает одну книгу
assertArrayEquals(book, repository.getBookId("1"));

//проверка для getBookTitle - возвращает не пустой список с книгами
assertThat(repository.getBookTitle("Blue jeans")).isNotNull();

//проверка для getBookTitle - возвращает именно ожидаемый список с книгами
assertThat(repository.getBookTitle("Blue jeans")).isEqualTo(books);

//проверка для getBooksAuthor - возвращает список из трёх книг
assertThat(repository.getBooksAuthor("Cosmo").size()).isEqualTo(3);

//проверка для getBooksAuthor - возвращает список из трёх книг, где третья книга именно та, которую ожидаем.
assertThat(repository.getBooksAuthor("Cosmo").get(2)).isEqualTo(books.get(2));
```

