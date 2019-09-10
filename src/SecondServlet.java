import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SecondServlet", urlPatterns = "/test")
public class SecondServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String p2 = request.getParameter("param2");
        String message = "<html><body>You said: " + p2 + "</body></html>";
        response.getWriter().print(message);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String p1 = request.getParameter("param1");
        String message = "<html><body>You said: " + p1 + "</body></html>";
        response.getWriter().print(message);

        //String msg = "<html><body>Hello World</body></html>";
        //response.getWriter().print(msg);

    }
}
