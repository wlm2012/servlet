package Servlet.Proxy;


import Dao.V6logDao;
import Entity.v6_log;
import Util.DbUtil;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/findv6log")
public class FindV6Log extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        doPost(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {

        String SvrName = req.getParameter("SvrName");
        System.out.println(SvrName);
        V6logDao v6logDao=new V6logDao();
        List<v6_log> v6LogList=v6logDao.findBySvrName(SvrName);

        DbUtil.close();

        Gson gson=new Gson();
        PrintWriter printWriter=resp.getWriter();
        printWriter.write(gson.toJson(v6LogList));
        printWriter.flush();
        printWriter.close();
    }



}
