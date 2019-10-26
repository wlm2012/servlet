package Servlet.Proxy;

import Util.HttpUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddProxy")
public class AddProxy extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        doPost(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        AddProxy1();
    }

    public void AddProxy1() {
//        HttpUtil.proxyNoAuth("https://www.ssrtool.com/tool/free_ssr");
//        HttpUtil.proxyNoAuth("https://free-ss.site/");
//        String result=HttpUtil.proxyNoAuth("http://ss.pythonic.life/");
        String result = HttpUtil.postToTest("FuserQuyBrchBrchNOLis");
        System.out.println(result);
    }
}
