package exercise;

import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.List;
import exercise.model.User;
import exercise.dto.users.UsersPage;
import static io.javalin.rendering.template.TemplateUtil.model;
import io.javalin.rendering.template.JavalinJte;

import org.apache.commons.lang3.StringUtils;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        // BEGIN
        app.get("users/", ctx -> {
            var term = ctx.queryParam("term");
            List<User> users = new ArrayList<>();
            if (term != null) {
                for (var user : USERS) {
                    var check = user.getFirstName().toLowerCase();
                    var check2 = term.toLowerCase();
                    if (check.contains(check2)){
                        users.add(user);
                    }
                }
            }
            else {
                users = new ArrayList<>(USERS);
            }
            var page = new UsersPage(users, term);
            ctx.render("users/index.jte", model("page", page));
        });
        // END

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
