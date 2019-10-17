package Util;


import java.io.InputStream;
import java.sql.*;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author wlm
 */
public class DbUtil {

    private static String drivename;
    private static String url;
    private static String userName;
    private static String passWord;
    private static Integer jdbcPoolInitSize;
    private static ThreadLocal<Connection> tl = new ThreadLocal<>();
    private static List<Connection> listConnections = new CopyOnWriteArrayList<>();

    static {
        Properties properties = new Properties();
        try {
            //获取文件流
            InputStream in = DbUtil.class.getClassLoader().getResourceAsStream("mysql.properties");
/*            //获取文件的位置
            String filePath=DbUtil.class.getClassLoader().getResource("mysql.properties").getFile();
            System.out.println(filePath);*/

            properties.load(in);

            drivename = properties.getProperty("drivename");
            url = properties.getProperty("url");
            userName = properties.getProperty("userName");
            passWord = properties.getProperty("passWord");
            jdbcPoolInitSize = Integer.parseInt(properties.getProperty("jdbcPoolInitSize"));
            in.close();

            for (int i = 0; i < jdbcPoolInitSize; i++) {
                listConnections.add(getConn());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() {
        Connection conn = null;
        try {

            Class.forName(drivename);
            conn = DriverManager.getConnection(url, userName, passWord);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static Connection getCurrentConn() {
        Connection con = null;
        if (listConnections.size() > 0) {
            con = listConnections.get(0);
            listConnections.remove(0);
        } else {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return con;
    }

    public static void close() {
        try {
            getCurrentConn().close();
            tl.remove();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void startTransaction() {
        try {
            getCurrentConn().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void rollback() {
        try {
            getCurrentConn().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void commit() {
        Connection conn = getCurrentConn();
        try {
            conn.commit();
            tl.remove();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void close(ResultSet rs, Statement st) throws SQLException {
        if (st != null) {
            st.close();
        }

        if (rs != null) {
            rs.close();
        }
    }


    public static void close(ResultSet rs, Statement st, Connection conn) throws SQLException {
        if (conn != null) {
            listConnections.add(conn);
        }
        if (st != null) {
            st.close();
        }
        if (rs != null) {
            rs.close();
        }

    }

    public static void close(Statement st, Connection conn) throws SQLException {
        if (conn != null) {
            listConnections.add(conn);
        }
        if (st != null) {
            st.close();
        }

    }


    // 测试数据库是否连通
    public static void main(String[] args) {
        System.err.println(getConn());
    }

}
