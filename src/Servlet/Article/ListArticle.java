package Servlet.Article;


import Dao.ArticleDao;
import Entity.Article;
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
@WebServlet("ListArticle")
public class ListArticle extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArticleDao articleDao = new ArticleDao();
        String Page = req.getParameter("Page");
        String PageNum = req.getParameter("PageNum");
        Integer page = 1;
        Integer pagenum = 15;
        if (StringUtil.isEmpty(Page) || StringUtil.isEmpty(PageNum)) {
            //do nothing
        } else {
            page = Integer.parseInt(Page);
            pagenum = Integer.valueOf(pagenum);
        }

        List<Article> articleList = articleDao.FindArticleByPage(page, pagenum);
        req.setAttribute("articleList", articleList);
        req.getRequestDispatcher("WEB-INF/article/listarticle.jsp").forward(req, resp);
    }
}
