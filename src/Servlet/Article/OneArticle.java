package Servlet.Article;


import Dao.ArticleDao;
import Entity.Article;
import Util.DbUtil;
import Util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author lenovo2
 */
@WebServlet("/Article")
public class OneArticle extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArticleDao articleDao = new ArticleDao();
        String id = req.getParameter("id");


        Article article = articleDao.FindArticleById(id);
        DbUtil.close();
        req.setAttribute("article", article);
        req.getRequestDispatcher("WEB-INF/article/OneArticle.jsp").forward(req, resp);
    }
}
