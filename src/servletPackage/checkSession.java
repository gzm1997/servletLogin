package servletPackage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

//这个视图用来测试客户端是否被成功设置了session attribute
@WebServlet("/checkSession")
public class checkSession extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        获取客户端的session
        HttpSession session = req.getSession();
//        获取session attribute
        String login = (String) session.getAttribute("login");
        System.out.println("login session is " + login);
        PrintWriter out = resp.getWriter();
        out.println("login session is " + login);
        out.close();
    }
}
