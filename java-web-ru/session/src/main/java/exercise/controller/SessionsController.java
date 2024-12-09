package exercise.controller;

import java.util.Collections;
import java.util.Objects;

import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import io.javalin.http.Context;

public class SessionsController {

    // BEGIN
    public static void root(Context ctx) {
        var user = ctx.sessionAttribute("user");
        var page = new MainPage(user);
        ctx.render("index.jte", Collections.singletonMap("page", page));
    }

    public static void build(Context ctx) {
        var page = new LoginPage("", "");
        ctx.render("build.jte", Collections.singletonMap("page", page));
    }

    public static void login(Context ctx) {
        String name = ctx.formParam("name");
        String enteredPassword = encrypt(Objects.requireNonNull(ctx.formParam("password")));
        var user = UsersRepository.findByName(name);
        if (user != null && Objects.hashCode(user.getClass()) == Objects.hashCode(enteredPassword)) {
            ctx.sessionAttribute("currentUser", name);
            ctx.redirect("/");
        }
        else {
            LoginPage page = new LoginPage(name, "Wrong username or password");
            ctx.render("build.jte", Collections.singletonMap("page", page));
        }
    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("user", null);
        ctx.redirect("/");
    }
    // END
}