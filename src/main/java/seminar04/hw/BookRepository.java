package seminar04.hw;

import java.lang.reflect.Array;
import java.util.List;

public interface BookRepository {
     String[] getBookId(String id);
     List<String[]> getBookTitle(String title);
     List<String[]> getBooksAuthor(String author);
}
