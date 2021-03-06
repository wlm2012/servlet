package Dao;


import Entity.Article;
import Util.DbUtil;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lenovo2
 */
public class ArticleDao {
    public void AddArticle(Article article) {
        String sql = "INSERT INTO t_article (id, user_id, article, update_time, title) VALUES(?,?,?,?,?);";
        try {
            Connection conn = DbUtil.getCurrentConn();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, article.getId());
            ps.setString(2, article.getUser_id());
            ps.setString(3, article.getArticle());
            ps.setString(4, article.getTitle());
            ps.setTimestamp(5, article.getUpdate_time());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void DeleteArticle(String id) {
        String sql = "DELETE FROM t_article WHERE id=?;";
        PreparedStatement ps = null;
        try {
            Connection conn = DbUtil.getCurrentConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void UpdateArticle(Article article) {
        String sql = "UPDATE t_article SET user_id=?, article=?, title=?, update_time=? WHERE id=?;";
        try {
            Connection conn = DbUtil.getCurrentConn();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(5, article.getId());
            ps.setString(1, article.getUser_id());
            ps.setString(2, article.getArticle());
            ps.setString(3, article.getTitle());
            ps.setTimestamp(4, article.getUpdate_time());
            ps.close();
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<Article> FindArticleByPage(Integer Page, Integer PageNum) {
        String sql = "select * from t_article order by create_time desc limit ?,?";
        List<Article> articleList = new ArrayList<>();
        try {
            Connection conn = DbUtil.getCurrentConn();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, PageNum * (Page - 1));
            ps.setInt(2, PageNum);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Article article = new Article();
                article.setId(resultSet.getString("id"));
                article.setTitle(resultSet.getString("title"));
                String article1=resultSet.getString("article");
                if (article1.length()>100){
                    article1=article1.substring(0, 99);
                }
                article.setArticle(article1);
                article.setUser_id(resultSet.getString("user_id"));
                article.setUpdate_time(resultSet.getTimestamp("update_time"));
                article.setVisited(resultSet.getInt("visited"));
                articleList.add(article);
            }
            DbUtil.close(resultSet, ps);

        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
        return articleList;
    }

    public Article FindArticleById(String id) {
        String sql = "select * from t_article where id=?";
        Article article = new Article();
        try {
            Connection conn = DbUtil.getCurrentConn();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                article.setId(resultSet.getString("id"));
                article.setTitle(resultSet.getString("title"));
                article.setArticle(resultSet.getString("article"));
                article.setUser_id(resultSet.getString("user_id"));
                article.setUpdate_time(resultSet.getTimestamp("update_time"));
                article.setVisited(resultSet.getInt("visited"));
            }
            DbUtil.close(resultSet, ps);
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
        return article;
    }

    public void AddVisited(String id) {
        String sql = "update t_article set visited=visited+1 where id=?;";
        PreparedStatement ps = null;
        try {
            Connection conn = DbUtil.getCurrentConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.close();
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
