package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.MockBookService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    MockBookService mockBookService;

    @GetMapping("")
    public List<Book> booksList() {
        return mockBookService.getBooksList();
    }

    @PostMapping("")
    public void addBook(@RequestBody Book book) {
        mockBookService.addBook(book);
    }

    @GetMapping("/{id}")
    public Optional<Book> get(@PathVariable Long id) {
        return mockBookService.getBook(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        mockBookService.deleteBook(id);
    }

    @PutMapping("")
    @ResponseBody
    public void update(@RequestBody Book book) {
        mockBookService.updateBook(book);
    }



}
