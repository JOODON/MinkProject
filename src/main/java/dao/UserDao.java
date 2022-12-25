package dao;

import dto.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
    private static String dburl="jdbc:mysql://localhost:3307/role";

    private static String dbuser="root";

    private static String dbpassword="kkjjss103@";

    public User getUser(Integer id){
        User user=null;
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection(dburl,dbuser,dbpassword);
            String sql="SELECT * FROM user WHERE Userid=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            if (rs.next()){
                String userId=rs.getString(1);
                String userPassword=rs.getString(2);

                user=new User(userId,userPassword);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }
}
