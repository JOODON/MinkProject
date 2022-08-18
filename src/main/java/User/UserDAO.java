package User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    //데이터 베이스 접속을 위한 필드 생성
    private static String dburl = "jdbc:mysql://localhost:3307/tutorial";
    private static String dbUser = "root";
    private static String dbpasswd = "kkjjss103@";


    public int addUser(UserDTO userDTO){
        int insertCount=0;
        Connection conn=null; //접속하는 부분 설정
        PreparedStatement ps=null;//호출시켜주는 부분 설정
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection(dburl,dbUser,dbpasswd);//나으 데이터베이스에 접근
            String sql="INSERT INTO user (userID,userPassword) VALUES (?,?)";
            ps=conn.prepareStatement(sql);

            ps.setString(1,userDTO.getUserID());
            ps.setString(2,userDTO.getUserPassword());

            insertCount= ps.executeUpdate();//업데이트를 실행해 주는 곳
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if(ps != null && conn != null){
                try {
                    ps.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return insertCount;
    }
    public List<UserDTO> getUsers(){
        List<UserDTO> list = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            //클래스를 찾을수 없을때 예외 처리
            e.printStackTrace();
        }
        String sql="SELECT userID,userPassword FROM user order by userID desc";
        try (Connection conn =DriverManager.getConnection(dburl,dbUser,dbpasswd);
             PreparedStatement ps=conn.prepareStatement(sql)){
            try (ResultSet rs=ps.executeQuery(sql)){
                while (rs.next()){
                    String userID=rs.getString(1);
                    String userPassword=rs.getString(2);
                    UserDTO userDTO=new UserDTO(userID,userPassword);
                    list.add(userDTO);
                }
            }catch (Exception e){
                e.printStackTrace();
            }}catch (Exception ex){
                ex.printStackTrace();
            }
            return list;
        }
        public int delete(UserDTO userDTO){
            int insertCount=0;
            Connection conn=null; //접속하는 부분 설정
            PreparedStatement ps=null;//호출시켜주는 부분 설정
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn= DriverManager.getConnection(dburl,dbUser,dbpasswd);//나으 데이터베이스에 접근
                String sql="DELETE FROM user WHERE userID=?";
                ps=conn.prepareStatement(sql);
                ps.setString(1,userDTO.getUserID());

                insertCount=ps.executeUpdate();
            }catch (Exception e){
                e.printStackTrace();
            }
            finally {
                if(ps != null && conn != null){
                    try {
                        ps.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
            return insertCount;
        }
    }
