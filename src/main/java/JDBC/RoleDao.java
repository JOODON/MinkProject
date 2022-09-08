package JDBC;
//JDBC 기초
//1.IMPORT JAVA.SQL
//2.드라이버 로드
//3단계 Connection 객체 생성
//4단계 Statement 객체 생성
//5단게 SQL 결과물이 있다면 ResultSet 객체 생성
//6단계 객체를 닫는다 순서로 진행
//DriverManager ->Connection -> Statement ->ResultSet 순서로 진행 닫을떄는 반대로 진행!
import java.sql.*;
public class RoleDao {
    private static String dburl="jdbc:mysql://localhost:3307/role";
    private static String dbuser="root";
    private static String dbpassword="kkjjss103@";

    public Role getRole(Integer roldId){
         //롤이라는 데이터를 가져올거기 때문에 롤이라는 형을 선택해줌
         //프라이머리키가 RoleID기 때문에 파라미터에 넣어줌
        Role role=null;//리턴해야될 롤을 설정
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection(dburl,dbuser,dbpassword);
            String sql="SELECT role_id,description FROM role WHERE role_id=?";
            ps=conn.prepareStatement(sql);//SQL쿼리문이 들어가야될곳
            //내가 접속할 url user password 를 가져와야됨
            ps.setInt(1,roldId);
            //해당인자를 파라미터로 가져올거기 떄문에 이걸로 선언
            rs=ps.executeQuery();
            //넥스트라는 메소드는 결과값이 있다면 true가 리턴
            if (rs.next()){
                //여기에는 컬럼이 순서
                int id=rs.getInt(1);
                String description=rs.getString(2);
                role=new Role(id,description);
            }
        }catch (Exception e){

        }finally{

           if(rs !=null){
               try {
                   rs.close();
               }catch (SQLException e){
                   e.printStackTrace();
               }
           }
            if(ps !=null){
                try {
                    rs.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if(conn !=null){
                try {
                    rs.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

        }
        return role;
    }
    public int addRole(Role role){
        int insertCount=0;

        Connection conn=null;
        PreparedStatement ps=null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn=DriverManager.getConnection(dburl,dbuser,dbpassword);

            String sql="INSERT INTO role values(?,?)";

            ps=conn.prepareStatement(sql);

            ps.setInt(1, role.getRoleId());
            ps.setString(2,role.getDescription());

            insertCount=ps.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }finally{

            if(ps !=null){
                try {
                    ps.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if(conn !=null){
                try {
                    conn.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return insertCount;
    }

}
