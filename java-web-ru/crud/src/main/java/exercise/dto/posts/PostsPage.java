package exercise.dto.posts;

import java.util.List;

import exercise.model.Post;

import lombok.AllArgsConstructor;
import lombok.Getter;


// BEGIN
@AllArgsConstructor
@Getter
public class PostsPage {
    List<Post> posts;
    int pageNumber;
}
// END


