package JDBC;

public class JDBCEXAM2 {
    public static void main(String[] args) {
        int role_id=3;
        String description="데이터 베이스 연습 3";

        Role role=new Role(role_id,description);

        RoleDao dao=new RoleDao();
        int insertCount=dao.addRole(role);

        System.out.println(insertCount);


    }
}
