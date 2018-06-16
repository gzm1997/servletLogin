package servletPackage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/postDeal")
public class PostDeal extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("user");
        String psw = req.getParameter("password");
        FindPsw f = new FindPsw();
        String rightPsw = f.getPsw(user);
        System.out.println("right psw is " + rightPsw);
        PrintWriter out = resp.getWriter();
        if (psw.equals(rightPsw)) {
//            add cookies
            Cookie login = new Cookie("login", "mylogin");
            resp.addCookie(login);

//            add session
            HttpSession session = req.getSession();
            session.setAttribute("login", "this is my login session");

//            add response text
            out.println(
                    "<p>login successfully user " + user + " psw is " + psw + "</p>" +
                    "<a href='/checkSession'>this is a page to check whether set session attribute</a>"
            );
        }
        else {
            out.println("<p>psw is error</p>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
