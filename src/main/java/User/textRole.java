package User;
import User.UserDAO;
import User.UserDTO;

public class textRole {
    public static void main(String[] args) {
        String userID="Anum";
        String userPassword="1234";

        UserDTO userDTO=new UserDTO(userID,userPassword);
        UserDAO userDAO=new UserDAO();

        int insertCount= userDAO.addUser(userDTO);


    }
}
