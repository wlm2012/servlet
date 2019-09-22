package Dao;

import Util.DbUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.SQLException;

public class ArticleDao {
    public void AddArticle(){
        QueryRunner queryRunner=new QueryRunner();
        try {
            ResultSetHandler
            queryRunner.;
            queryRunner.update(DbUtil.getCurrentConn(),"");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
