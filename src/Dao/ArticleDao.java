package Dao;

import Util.DbUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

public class ArticleDao {
    public void AddArticle(){
        QueryRunner queryRunner=new QueryRunner();
        try {
            queryRunner.update(DbUtil.getCurrentConn(),"");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
