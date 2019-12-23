package Servlet.User;


import Dao.UserDao;
import Entity.User;
import Util.IoUtil;
import Util.LogUtil;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/OneUser")
public class OneUser extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/user/OneUser.html").forward(req, resp);

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id = req.getParameter("id");
            Gson gson = new Gson();
            List<User> list = UserDao.findUser(id);
            PrintWriter printWriter = resp.getWriter();
            printWriter.write(gson.toJson(list));
            printWriter.flush();
            printWriter.close();
        } catch (SQLException | IOException | InterruptedException e) {
            LogUtil.error(e.getMessage());
            req.getRequestDispatcher("WEB-INF/bad.jsp").forward(req, resp);
        }
    }

}
