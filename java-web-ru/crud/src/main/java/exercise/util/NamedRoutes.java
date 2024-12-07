package exercise.util;

public class NamedRoutes {

    public static String rootPath() {
        return "/";
    }

    // BEGIN
    public static String postsPath() {
        return "/posts";
    }

    public static String postsPath(String id) {
        return "/posts/" + id;
    }

    public static String postsPath(Long id) {
        return postsPath(String.valueOf(id));
    }
    // END
}
