package Servlet.Proxy;

import Entity.v6;
import Util.HttpUtil;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/v6")
public class AddProxy extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            v6 v6=new v6();
            v6.setNum(5);
            req.setAttribute("v6",v6);
            req.getRequestDispatcher("svraddr.jsp").forward(req, resp);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String svrName = req.getParameter("svrName").trim();
        Integer num = 5;
        if (req.getParameter("num")!=null){
            num = Integer.valueOf(req.getParameter("num"));
        }
        String body = req.getParameter("body");
        String result = req.getParameter("result");
        String url=HttpUtil.postToTest(svrName,num);
        result=HttpUtil.Post(url,body);
        v6 v6=new v6();
        v6.setSvrName(svrName);
        v6.setNum(num);
        v6.setBody(body);
        v6.setResult(result);
        req.setAttribute("v6",v6);
        req.getRequestDispatcher("svraddr.jsp").forward(req, resp);
    }

    public void AddProxy1() {
//        HttpUtil.proxyNoAuth("https://www.ssrtool.com/tool/free_ssr");
//        HttpUtil.proxyNoAuth("https://free-ss.site/");
//        String result=HttpUtil.proxyNoAuth("http://ss.pythonic.life/");
        String result = HttpUtil.postToTest("FuserQuyBrchBrchNOLis",5);

        System.out.println(result);
    }


}
