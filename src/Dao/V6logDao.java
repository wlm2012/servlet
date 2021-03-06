package Dao;

import Entity.v6_log;
import Util.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class V6logDao {

    public  List<v6_log> findBySvrName(String SvrName) throws InterruptedException {

        String sql="select * from t_v6_log where svrName like '%"+SvrName+"%' order by createtime DESC LIMIT 100";

        Connection conn= DbUtil.getCurrentConn();
        List<v6_log> v6LogList=null;
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet resultSet=ps.executeQuery();
            v6LogList=new ArrayList<>(100);
            while (resultSet.next()){
                v6_log v6Log1 =new v6_log();
                v6Log1.setSvrName(resultSet.getString("svrName"));
                v6Log1.setBody(resultSet.getString("body"));
                v6Log1.setDatetime(resultSet.getTimestamp("createtime"));
                v6Log1.setNum(resultSet.getInt("num"));
                v6LogList.add(v6Log1);
            }
            DbUtil.close(resultSet,ps);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return v6LogList;
    }


    public  void AddV6Log(v6_log v6Log) throws InterruptedException {

        String sql="INSERT INTO t_v6_log (`user`, svrName, num, body) VALUES(?,?,?,?);";
        Connection conn=DbUtil.getCurrentConn();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, v6Log.getUser());
            ps.setString(2, v6Log.getSvrName());
            ps.setInt(3, v6Log.getNum());
            ps.setString(4, v6Log.getBody());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
