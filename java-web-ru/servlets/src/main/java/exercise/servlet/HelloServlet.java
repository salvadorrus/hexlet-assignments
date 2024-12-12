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
        String name = getInitParameter("name");
        String message1 = "Hello, " + name + "!";
        String message2 = "Hello, Guest!";
        if (name.isEmpty()) {
            req.setAttribute("message", message2);
        } else {
            req.setAttribute("message", message1);
        }
        req.getRequestDispatcher("/WEB-INF/users.jsp").forward(req, resp);
    }
    // END
}
