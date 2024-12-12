package exercise.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "HelloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    // BEGIN
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message1 = "Hello, ";
        String message2 = "Hello, Guest!";
        String[] name = {"Jonn"};
        req.setAttribute("message", message1);
        req.setAttribute("name", name);

        req.getRequestDispatcher("/WEB-INF/users.jsp").forward(req, resp);
    }
    // END
}
