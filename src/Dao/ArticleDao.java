package Dao;


import Entity.Article;
import Util.DbUtil;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class ArticleDao {
    public void AddArticle(Article article) {
        String sql = "INSERT INTO t_article (id, user_id, article, update_time, title) VALUES(?,?,?,?,?);";
        try {
            PreparedStatement ps = DbUtil.getCurrentConn().prepareStatement(sql);
            ps.setString(1, article.getId());
            ps.setString(2, article.getUser_id());
            ps.setString(3, article.getArticle());
            ps.setString(4, article.getTitle());
            ps.setTimestamp(5, article.getUpdate_time());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void DeleteArticle(String id) {
        String sql = "DELETE FROM bbs.t_article WHERE id=?;";
        PreparedStatement ps = null;
        try {
            ps = DbUtil.getCurrentConn().prepareStatement(sql);
            ps.setString(1,id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
