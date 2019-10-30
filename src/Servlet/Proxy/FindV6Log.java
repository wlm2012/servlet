package Servlet.Proxy;


import Dao.V6logDao;
import Entity.v6_log;
import Util.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/findv6log")
public class FindV6Log extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String SvrName = req.getParameter("SvrName");
        V6logDao v6logDao=new V6logDao();
        List<v6_log> v6LogList=v6logDao.findBySvrName(SvrName);

        DbUtil.close();
        req.setAttribute("v6LogList", v6LogList);
        req.getRequestDispatcher("svraddr.jsp").forward(req, resp);
    }



}
