package exercise.service;

import exercise.dto.BookCreateDTO;
import exercise.dto.BookDTO;
import exercise.dto.BookUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.BookMapper;
import exercise.repository.AuthorRepository;
import exercise.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookService {
    // BEGIN
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private AuthorRepository authorRepository;

    public List<BookDTO> getAll() {
        var books = bookRepository.findAll();
        var result = books.stream().map(bookMapper::map).toList();
        return result;
    }

    public BookDTO create(BookCreateDTO data) {
        try {
            var author = authorRepository.findById(data.getAuthorId()).get();
            var book = bookMapper.map(data);
            book.setAuthor(author);
            bookRepository.save(book);
            return bookMapper.map(book);
        } catch (NoSuchElementException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

    public BookDTO findById(Long id) {
        var post = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found: " + id));
        var postDTO = bookMapper.map(post);
        return postDTO;
    }

    public BookDTO update(BookUpdateDTO postData, Long id) {
        var post = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found"));
        bookMapper.update(postData, post);
        bookRepository.save(post);
        var postDTO = bookMapper.map(post);
        return postDTO;
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
    // END
}
