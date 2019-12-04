package Dao;

import Entity.Article;
import Entity.User;
import Util.DbUtil;

import java.sql.*;
import java.time.LocalDateTime;

public class UserDao {
    public void AddUser(User user) {

    }


    public static User FindUser(User user) {
        String sql = "select * from t_user where name=? and password=? and status='1' limit 1";

        try {
            Connection conn = DbUtil.getCurrentConn();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                user.setId(resultSet.getString("id"));
                return user;
            }
            DbUtil.close(resultSet, ps);
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return user;
    }

    public static User findOneUser(String id) throws SQLException {
        User user = new User();
        try {
            String sql = "select * from t_user where id=? limit 1";

            Connection conn = DbUtil.getCurrentConn();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                user.setId(resultSet.getString("id"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setStatus(resultSet.getString("status"));
                user.setScores(resultSet.getDouble("scores"));
                user.setLastlogintime(resultSet.getTimestamp("lastlogintime").toLocalDateTime());
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return user;
    }
}
