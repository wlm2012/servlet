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
    private static ThreadLocal<Connection> tlc = new ThreadLocal<>();
    private static ThreadLocal<PreparedStatement> tlp = new ThreadLocal<>();
    private static List<Connection> listConnections = new CopyOnWriteArrayList<>();

    //创建连接池
    static {
        Properties properties = new Properties();
        try {
            //获取文件流
            InputStream in = DbUtil.class.getClassLoader().getResourceAsStream("boot.properties");
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

    //建立数据库连接，仅供创建数据库连接池时使用
    private static Connection getConn() {
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


    //供Dao层使用
    public static Connection getCurrentConn() {
        Connection conn = tlc.get();
        if (conn == null) {
            if (listConnections.size() > 0) {
                conn = listConnections.get(0);
                tlc.set(conn);
                listConnections.remove(0);
            } else {
                try {
                    Thread.sleep(50000);
                    getCurrentConn();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return conn;
    }

    public static void close() {
        Connection conn = getCurrentConn();
        listConnections.add(conn);
        tlc.remove();
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
        Connection conn=getCurrentConn();
        try {
            conn.commit();
            listConnections.add(conn);
            tlc.remove();
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


    // 测试数据库是否连通
    public static void main(String[] args) {
        System.err.println(getConn());
    }

}
