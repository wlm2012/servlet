package Servlet.Proxy;

import Util.HttpUtil;

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
            resp.sendRedirect("svraddr.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        AddProxy1();
    }

    public void AddProxy1() {
//        HttpUtil.proxyNoAuth("https://www.ssrtool.com/tool/free_ssr");
//        HttpUtil.proxyNoAuth("https://free-ss.site/");
//        String result=HttpUtil.proxyNoAuth("http://ss.pythonic.life/");
        String result = HttpUtil.postToTest("FuserQuyBrchBrchNOLis",5);
        System.out.println(result);
    }
}
