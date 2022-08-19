package User;
import User.UserDAO;
import User.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class textRole {
    public static void main(String[] args) {
            String userID="Hello";
            String userPassword="1234";
            String changeuserID="admin";

            UserDTO userDTO=new UserDTO(userID,userPassword);
            UserDAO userDAO=new UserDAO();

            int insertCount= userDAO.update(userDTO,changeuserID);

//        List<UserDTO> list=userDAO.getUsers();

//        for(UserDTO DTO : list) {
//            System.out.println(DTO);
//        }
    }
}
