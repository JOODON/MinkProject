package User;

import Util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDAO {
    public int join(String userID, String userPassword){
        String SQL="INSERT INTO USER VALUES (?,?)";
        try {
            Connection conn= DatabaseUtil.getConnection();
            PreparedStatement pstst=conn.prepareStatement(SQL);
            pstst.setString(1,userID);
            pstst.setString(2,userPassword);
            return pstst.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }
    public int delete(String userID){
        String SQL="UPDATE BBS SET bbsAvailable=0 WHERE bbsID=?";
        try {
            Connection conn= DatabaseUtil.getConnection();
            PreparedStatement pstst=conn.prepareStatement(SQL);
            pstst.setString(1,userID);
            return pstst.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }
}
