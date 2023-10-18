package seminar04.hw;

import java.lang.reflect.Array;
import java.util.List;

public class BookService {

    private BookRepository library;

    public BookService (BookRepository library) {
        this.library = library;
    }


    public String[] findBookId(String id) {
        return library.getBookId(id);
    }


    public List<String[]> findBookTitle(String title) {
        return library.getBookTitle(title);
    }


    public List<String[]> findBooksAuthor(String author) {
        return library.getBooksAuthor(author);
    }
}
