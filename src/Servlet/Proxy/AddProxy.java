package Servlet.Proxy;

import Dao.V6logDao;
import Entity.v6;
import Entity.v6_log;
import Util.DbUtil;
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
        String url="";
        //如果为5、6、7，则使用寻址服务器传回来的地址
        if(num.equals(5)||num.equals(6)||num.equals(7)){
            url=HttpUtil.postToTest(svrName,num);
        }
        //如果为23，则使用测试网厅的地址
        if (num.equals(23)){
            url="http://172.17.17.23:9092/api";
        }
        if (num.equals(0)){
            url=svrName;
        }

        result=HttpUtil.Post(url,body);
        v6 v6=new v6();
        v6.setSvrName(svrName);
        v6.setNum(num);
        v6.setBody(body);
        v6.setResult(result);
        req.setAttribute("v6",v6);

        v6_log v6_log=new v6_log();
        v6_log.setNum(num);
        v6_log.setSvrName(svrName);
        v6_log.setBody(body);

        V6logDao v6logDao=new V6logDao();
        v6logDao.AddV6Log(v6_log);
        DbUtil.close();

        req.getRequestDispatcher("svraddr.jsp").forward(req, resp);
    }

/*    public void AddProxy1() {
        HttpUtil.proxyNoAuth("https://www.ssrtool.com/tool/free_ssr");
        HttpUtil.proxyNoAuth("https://free-ss.site/");
        String result=HttpUtil.proxyNoAuth("http://ss.pythonic.life/");
        String result = HttpUtil.postToTest("FuserQuyBrchBrchNOLis",5);

        System.out.println(result);
    }*/


}
