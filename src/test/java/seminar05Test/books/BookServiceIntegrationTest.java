package seminar05Test.books;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seminar05.books.Book;
import seminar05.books.BookService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BookServiceIntegrationTest {
    private BookService bookService;

    @BeforeEach
    public void setup(){
        bookService = new BookService();
    }

    @Test
    public void addBookAndGetAllBooks(){
        // Задание:
        // 1. Создайте 3 книги и добавьте их в BookService
        Book book1 = new Book("Mama", "Gorkiy");
        Book book2 = new Book("Neznaika", "Nosov");
        Book book3 = new Book("Kubik", "Rubik");

        bookService.addBook(book1);
        bookService.addBook(book2);
        bookService.addBook(book3);

        // 2. Получите список всех книг из BookService
        List<Book> allBooks = bookService.getAllBooks();

        // 3. Проверьте что список не является null
        assertNotNull(allBooks);

        // 4. Проверьте что список содержит 3 книги
        assertEquals(3, allBooks.size());

        // 5. Выведите информацию о каждой книге, используя метод toString
        for (Book book: allBooks) {
            System.out.println(book);
        }

        // Используйте методы addBook и getAllBooks из BookService.
        // Проверьте что результаты соответствуют ожиданиям.
        assertEquals("Mama", allBooks.get(0).getTitle());
        assertEquals("Gorkiy", allBooks.get(0).getAuthor());
        assertEquals("Neznaika", allBooks.get(1).getTitle());
        assertEquals("Nosov", allBooks.get(1).getAuthor());
        assertEquals("Kubik", allBooks.get(2).getTitle());
        assertEquals("Rubik", allBooks.get(2).getAuthor());

        // проведите всевозможные интеграционные тесты

    }
}
