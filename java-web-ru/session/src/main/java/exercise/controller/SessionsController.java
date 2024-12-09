package exercise.controller;

import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;

import static exercise.util.Security.encrypt;

import io.javalin.http.Context;
import exercise.model.User;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;

public class SessionsController extends User {

    public SessionsController(String name, String password) {
        super(name, password);
    }

    public SessionsController(Long id, String name, String password) {
        super(id, name, password);
    }

    // BEGIN
    public static void root(Context ctx) {
        String name = ctx.sessionAttribute("currentUser");
        var page = new MainPage(name);
        ctx.render("index.jte", Collections.singletonMap("page", page));
    }

    public static void build(Context ctx) {
        ctx.render("build.jte");
    }

    public static void login(Context ctx) {
        String name = ctx.formParam("name");
        String enteredPassword = encrypt(Objects.requireNonNull(ctx.formParam("password")));
        Optional<User> user = UsersRepository.findByName(name);
        if (user.isPresent() && Objects.hashCode(user.get().getPassword()) == Objects.hashCode(enteredPassword)) {
            ctx.sessionAttribute("currentUser", name);
            ctx.redirect("/");
        } else {
            LoginPage page = new LoginPage(name, "Wrong username or password");
            ctx.render("build.jte", Collections.singletonMap("page", page));
        }
    }

    public static void logout(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect("/");
    }
    // END
}
