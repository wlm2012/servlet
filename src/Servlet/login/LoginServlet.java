package Servlet.login;

import Dao.ArticleDao;
import Dao.UserDao;
import Entity.Article;
import Entity.User;
import Util.DbUtil;
import Util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        doPost(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {


        try {
            String name = req.getParameter("name");
            String password = req.getParameter("password");
            UserDao userDao = new UserDao();
            User user = new User();
            user.setName(name);
            user.setPassword(password);
            user = UserDao.FindUser(user);
            String id = user.getId();
            if (StringUtil.isEmpty(id)) {
                req.setAttribute("msg", "账号或密码错误");
                req.getRequestDispatcher("/Login.jsp").forward(req, resp);
            } else {
                HttpSession session = req.getSession();
                session.setAttribute("name", name);
                resp.sendRedirect("/ListArticle");
            }
            DbUtil.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
