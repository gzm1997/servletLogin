package servletPackage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>\n" +
                "<html lang='en-US'>\n" +
                "<head>\n" +
                "    <meta charset='utf-8'>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>login</h1>\n" +
                "<form action='/postDeal' method='post'>\n" +
                "    <input type='text' name='user'>\n" +
                "<br>" +
                "    <input type='text' name='password'>\n" +
                "<br>" +
                "    <input type='submit'>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>"
        );
        out.close();
    }
}
