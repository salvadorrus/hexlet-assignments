package exercise.service;

import exercise.dto.AuthorCreateDTO;
import exercise.dto.AuthorDTO;
import exercise.dto.AuthorUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.AuthorMapper;
import exercise.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    // BEGIN
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorMapper authorMapper;

    public List<AuthorDTO> getAll() {
        var posts = authorRepository.findAll();
        var result = posts.stream()
                .map(authorMapper::map)
                .toList();
        return result;
    }

    public AuthorDTO create(AuthorCreateDTO authorData) {
        var post = authorMapper.map(authorData);
                authorRepository.save(post);
        var postDTO = authorMapper.map(post);
        return postDTO;
    }

    public AuthorDTO findById(Long id) {
        var post = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found: " + id));
        var postDTO = authorMapper.map(post);
        return postDTO;
    }

    public AuthorDTO update(AuthorUpdateDTO authorData, Long id) {
        var post = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found"));
        authorMapper.update(authorData, post);
        authorRepository.save(post);
        var postDTO = authorMapper.map(post);
        return postDTO;
    }

    public void delete(Long id) {
        authorRepository.deleteById(id);
    }
    // END
}
