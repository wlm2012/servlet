package Servlet.File;


import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


/**
 * @author lenovo2
 */

public class FileIoServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String names = getServletConfig().getInitParameter("names");
        String name = getServletContext().getInitParameter("name");
        System.out.println(names);
        System.out.println(name);

        resp.setContentType("application/txt");
        ServletContext servletContext = getServletContext();
        InputStream inputStream = servletContext.getResourceAsStream("/1.txt");
        int read = 0;
        byte[] bytes = new byte[1024];
        OutputStream outputStream = resp.getOutputStream();
        while ((read = inputStream.read(bytes)) > 0) {
            outputStream.write(bytes, 0, read);
        }
        outputStream.flush();
        outputStream.close();
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String names = getServletConfig().getInitParameter("names");
        String name = getServletContext().getInitParameter("name");
        System.out.println(names);
        System.out.println(name);
    }
}
