package seminar04Test.hw;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import seminar04.*;
import seminar04.hw.BookRepository;
import seminar04.hw.BookService;

import java.util.ArrayList;
import java.util.List;


public class MockBookServiceTest {

     String[] book = new String[3];

    List<String[]> books = new ArrayList<>();

    @Test
    public void testBookService(){
        //заполняем одну книгу
        book = new String[] { "1", "Jane Air", "Cosmo" };

        //заполняем ожидаемый список из трех книг
        books.add(book);
        books.add(new String[]{"2", "Jane Air 2", "Cosmo 2"});
        books.add(new String[]{"3", "Jane Air 3", "Cosmo 3"});

        //создаем мок-объект интерфейса BookRepository для тестирования
        BookRepository repository = mock(BookRepository.class);

        //заглушка для метода getBookId
        when(repository.getBookId(anyString())).thenReturn(book);

        //заглушка для метода getBookTitle
        when(repository.getBookTitle(anyString())).thenReturn(books);

        //заглушка для метода getBooksAuthor
        when(repository.getBooksAuthor(anyString())).thenReturn(books);

        //создаем мок-объект класса BookService для тестирования
        BookService library = new BookService(repository);

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
    }
}
