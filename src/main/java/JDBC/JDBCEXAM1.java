package JDBC;

public class JDBCEXAM1 {
    public static void main(String[] args) {
        RoleDao dao=new RoleDao();
        Role role=dao.getRole(1);

        System.out.println(role);
    }
}
