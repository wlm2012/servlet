package Servlet.Article;


import Dao.ArticleDao;
import Entity.Article;

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
@WebServlet("ListArticle")
public class ListArticle extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/ListArticle.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        ArticleDao articleDao=new ArticleDao();
        Integer Page=Integer.parseInt(req.getParameter("Page"));
        Integer PageNum=Integer.valueOf(req.getParameter("PageNum"));
        List<Article> articleList=articleDao.FindArticleByPage(Page,PageNum);
        req.setAttribute("articleList",articleList);
    }
}
