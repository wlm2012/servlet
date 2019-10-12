package Servlet.login;

import Dao.ArticleDao;
import Entity.Article;
import Util.DbUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doPost(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        String user_id = req.getParameter("user_id");
        String article = req.getParameter("article");
        String title = req.getParameter("title");
        Timestamp update_time = Timestamp.valueOf(req.getParameter("update_time"));
        Article articles = new Article();
        articles.setId(id);
        articles.setUser_id(user_id);
        articles.setArticle(article);
        articles.setTitle(title);
        articles.setUpdate_time(update_time);
        ArticleDao articleDao = new ArticleDao();
        articleDao.AddArticle(articles);
        DbUtil.close();
        resp.sendRedirect("/ListArticle");
    }
}
