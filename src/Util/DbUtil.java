package Util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author wlm
 */
public class DbUtil {

    private static String drivename;
    private static String url;
    private static String userName;
    private static String passWord;
    private static Connection conn = null;
    private static ThreadLocal<Connection> tl = new ThreadLocal<>();

    static {
        Properties properties = new Properties();
        try {
            InputStream in = new BufferedInputStream(new FileInputStream("resources/mysql.properties"));
            properties.load(in);

            drivename = properties.getProperty("drivename");
            url = properties.getProperty("url");
            userName = properties.getProperty("userName");
            passWord = properties.getProperty("passWord");
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() {
        try {
            if (null == conn || conn.isClosed()) {

                Class.forName(drivename);
                conn = DriverManager.getConnection(url, userName, passWord);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static Connection getCurrentConn() {
        Connection conn = tl.get();
        if (null == conn) {
            conn = getConn();
            tl.set(conn);
        }
        return conn;
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
            conn.close();
        }
        if (st != null) {
            st.close();
        }
        if (rs != null) {
            rs.close();
        }

    }


    // 测试数据库是否连通
    public static void main(String[] args) {
        System.err.println(getConn());
    }

}
