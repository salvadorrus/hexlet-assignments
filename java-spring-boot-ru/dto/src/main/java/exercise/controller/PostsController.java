package exercise.controller;

import exercise.dto.CommentDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.model.Comment;
import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.dto.PostDTO;

// BEGIN
@RestController
@RequestMapping("/api")
public class PostsController {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/users")
    public List<PostDTO> index() {
        var users = postRepository.findAll();
        var result = users.stream()
                .map(this::postToDTO)
                .toList();
        return result;
    }

    @GetMapping("/users/{id}")
    // Пользователь автоматически преобразуется в JSON
    public PostDTO show(@PathVariable Long id) {
        var post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found"));
        return postToDTO(post);
    }

    private PostDTO postToDTO(Post post) {
        var dtoPost = new PostDTO();
        dtoPost.setId(post.getId());
        dtoPost.setTitle(post.getTitle());
        dtoPost.setBody(post.getBody());
        var comments = commentRepository.findByPostId(post.getId());
        var commentsDTO = comments.stream().map(this::commentToDTO).toList();
        dtoPost.setComments(commentsDTO.toString());
        return dtoPost;
    }

    private CommentDTO commentToDTO(Comment comment) {
        var dtoComment = new CommentDTO();
        dtoComment.setId(comment.getId());
        dtoComment.setBody(comment.getBody());
        return dtoComment;
    }
}
// END
