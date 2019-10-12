package Dao;

import Entity.Article;
import Entity.User;
import Util.DbUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public void AddUser(User user) {

    }


    public User FindUser(User user) {
        String sql="select * from t_user where name=? and password=? and status='1'";

        try {
            PreparedStatement ps = DbUtil.getCurrentConn().prepareStatement(sql);
            ps.setString(1, user.getId());
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
}
