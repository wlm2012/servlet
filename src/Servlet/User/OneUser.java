package Servlet.User;


import Dao.UserDao;
import Entity.User;
import com.google.gson.Gson;
import lombok.SneakyThrows;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/OneUser")
public class OneUser extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {


        try {
            String id = req.getParameter("id");
            User user = UserDao.findOneUser(id);
            Gson gson = new Gson();
            PrintWriter printWriter = resp.getWriter();
            printWriter.write(gson.toJson(user));
            printWriter.flush();
            printWriter.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {

    }

}
