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
@WebServlet("/ListArticle")
public class ListArticle extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        doPost(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            ArticleDao articleDao = new ArticleDao();
            String Page = req.getParameter("Page");
            String PageNum = req.getParameter("PageNum");
            Integer page = 1;
            Integer pagenum = 5;
            if (StringUtil.isEmpty(Page) || StringUtil.isEmpty(PageNum)) {
                //do nothing
            } else {
                page = Integer.parseInt(Page);
                pagenum = Integer.valueOf(pagenum);
            }

            List<Article> articleList = articleDao.FindArticleByPage(page, pagenum);
            DbUtil.close();
            req.setAttribute("articleList", articleList);
            req.getRequestDispatcher("WEB-INF/article/ListArticle.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
