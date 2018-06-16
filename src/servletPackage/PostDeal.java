package servletPackage;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/postDeal")
public class PostDeal extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        获取表单中的用户和密码
        String user = req.getParameter("user");
        String psw = req.getParameter("password");
//        使用刚刚数据库连接的类进行数据库查询 获取正确密码
        FindPsw f = new FindPsw();
        String rightPsw = f.getPsw(user);
        System.out.println("right psw is " + rightPsw);
        PrintWriter out = resp.getWriter();
//        如果密码正确
        if (psw.equals(rightPsw)) {
//            add cookies
            Cookie login = new Cookie("login", "mylogin");
            resp.addCookie(login);

//            add session attribute
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

    // 登录表单提交过来这个书图类之后 doPost函数首先接受到请求 随之转发给doGet函数 由doGet函数进行处理
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }
}
