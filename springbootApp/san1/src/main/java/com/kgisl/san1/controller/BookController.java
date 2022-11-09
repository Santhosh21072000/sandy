package com.kgisl.san1.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kgisl.san1.entity.Book;
import com.kgisl.san1.repository.BookRepository;
@RestController
@RequestMapping("/book")
@CrossOrigin("*")
public class BookController {
    @Autowired
    private BookRepository bookRepository;
    @GetMapping("/")
    public List<Book> getAllBooks() {
        List<Book> l = bookRepository.findAll();
        // if(l==null){
        //     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        // }
        // return new ResponseEntity<>(HttpStatus.OK);
        return l;
    }
    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable("id") int id) {
        Optional<Book> l = bookRepository.findById(id);
        return l;
    }
    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable("id") int id) {
        bookRepository.deleteById(id);
    }
    @PostMapping("/")
    public Book createBook(@RequestBody Book book){
        System.out.println(book);
       return bookRepository.save(book);
    }
   @PutMapping("/{id}")
    public Book updateBookById(@PathVariable("id") int id,@RequestBody Book b){
      Optional<Book> op = bookRepository.findById(id);
      Book book=op.get();
      book.setId(b.getId());
      book.setAuthor(b.getAuthor());
      book.setTitle(b.getTitle());
      book.setPrice(b.getPrice());
      System.out.println(book);
      return book;
    }
}