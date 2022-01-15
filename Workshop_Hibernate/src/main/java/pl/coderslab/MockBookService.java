package pl.coderslab;

import org.springframework.stereotype.Component;
import pl.coderslab.controller.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MockBookService {
    private List<Book> booksList;

    public MockBookService() {
        booksList = new ArrayList<>();
        booksList.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        booksList.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        booksList.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }

    public List<Book> getBooksList() {
        return booksList;
    }

    public void addBook(Book book) {
        Long lastId = booksList.stream()
                        .mapToLong(Book::getId)
                        .max()
                        .getAsLong();
        book.setId(lastId + 1L);
        booksList.add(book);
    }


    public Optional<Book> getBook(Long id) {
        return booksList.stream().filter(item -> item.getId().equals(id)).findFirst();
    }

    public void deleteBook(Long id) {
        if (getBook(id).isPresent()) {
            booksList.remove(getBook(id).get());
        }
    }

    public void updateBook(Book book) {
        if (getBook(book.getId()).isPresent()) {
            int index = booksList.indexOf(getBook(book.getId()).get());
            booksList.set(index, book);
        }
    }
}
