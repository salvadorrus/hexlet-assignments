package exercise.dto.users;

import exercise.model.User;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

// BEGIN
@AllArgsConstructor
@Getter
public class UsersPage {
    private List<User> users;
    private String term;
}
// END
